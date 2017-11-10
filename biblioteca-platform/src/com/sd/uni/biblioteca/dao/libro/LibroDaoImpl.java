package com.sd.uni.biblioteca.dao.libro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dao.base.BaseDaoImpl;
import com.sd.uni.biblioteca.dao.libro.ILibroDao;
import com.sd.uni.biblioteca.domain.libro.LibroDomain;
import com.sd.uni.biblioteca.exception.BibliotecaException;

@Repository
public class LibroDaoImpl extends BaseDaoImpl<LibroDomain> implements ILibroDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public LibroDomain save(LibroDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}
	
	@Override
	public LibroDomain getById(Integer domainId) {
		return (LibroDomain) sessionFactory.getCurrentSession().get(LibroDomain.class, domainId);
	}

	@Override
	public List<LibroDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LibroDomain.class);
		return criteria.list();
	}

	
	@Override
	public List<LibroDomain> find(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from LibroDomain where _nombre like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}
	
	@Override
	public List<LibroDomain> find(String textToFind, int page, int maxItems) throws BibliotecaException {
		//Date minDate, maxDate;
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(LibroDomain.class, "libro").createAlias("libro._autor", "autor").createAlias("libro._categoria", "categoria");
		if (textToFind != null) {
			Map<String, String> map = obtenerQuery(textToFind);
			if (map.containsKey("text")) {
				String text = map.get("text");
				Criterion propertyCriterion = Restrictions.disjunction()
						.add(Restrictions.ilike("_nombre", "%" + text + "%"));
				Criterion idCriterion = null;
				if (StringUtils.isNumeric(text)) {
					idCriterion = Restrictions.disjunction().add(Restrictions.eq("_id", Integer.valueOf(text)));
				}
				if (idCriterion != null) {
					criteria.add(Restrictions.or(propertyCriterion, idCriterion));
				} else {
					criteria.add(propertyCriterion);
				}
			}
			if (map.containsKey("autor")) { // si quiere filtrar por autor
				Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.eq("autor._id", Integer.parseInt(map.get("autor"))));
				criteria.add(Restrictions.or(propertyCriterion));
			}
			if (map.containsKey("sort")) {
				String sort = (map.get("sort"));
				if(sort.equals("_nombre")){
					if (map.containsKey("order")){
						String order = (map.get("order"));
						if(order.equals("desc")){
							criteria.addOrder(Order.desc(sort).ignoreCase());
						}else{
							criteria.addOrder(Order.asc(sort).ignoreCase());
						}
					}else{
						criteria.addOrder(Order.asc(sort).ignoreCase());
					}
				}else if(sort.equals("_autor")){
					if (map.containsKey("order")){
						String order = (map.get("order"));
						if(order.equals("desc")){
							criteria.addOrder(Order.desc("autor._nombre"));
						}else{
							criteria.addOrder(Order.asc("autor._nombre"));
						}
					}else{
						criteria.addOrder(Order.desc("autor._nombre"));
					}
				}
				else if(sort.equals("_categoria")){
					if (map.containsKey("order")){
						String order = (map.get("order"));
						if(order.equals("desc")){
							criteria.addOrder(Order.desc("categoria._descripcion"));
						}else{
							criteria.addOrder(Order.asc("categoria._descripcion"));
						}
					}else{
						criteria.addOrder(Order.desc("categoria._descripcion"));
					}
				}
			}else{
				criteria.addOrder(Order.asc("_nombre").ignoreCase());
			}
		}else{
			criteria.addOrder(Order.asc("_nombre"));
		}
		
		
		criteria.setFirstResult(page * maxItems);
		criteria.setMaxResults(maxItems);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<LibroDomain> libros = criteria.list();
		return libros;
	}

	private Map<String, String> obtenerQuery(String textToFind) throws BibliotecaException{
		String[] params = textToFind.split("&");
		Map<String, String> map = new HashMap<String, String>();
		try {
			for (String param : params) {
				String name = param.split("=")[0];
				String value = param.split("=")[1];
				map.put(name, value);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new BibliotecaException("Formato de ruta invalido", e);
		}
		return map;
	}

}

