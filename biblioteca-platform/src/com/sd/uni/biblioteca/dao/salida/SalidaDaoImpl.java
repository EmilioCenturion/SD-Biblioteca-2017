package com.sd.uni.biblioteca.dao.salida;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.ParseException;

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


import com.sd.uni.biblioteca.dao.salida.ISalidaDao;
import com.sd.uni.biblioteca.domain.salida.SalidaDomain;
import com.sd.uni.biblioteca.domain.usuario.UsuarioDomain;
import com.sd.uni.biblioteca.exception.BibliotecaException;

@Repository
public class SalidaDaoImpl extends BaseDaoImpl<SalidaDomain> implements ISalidaDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SalidaDomain save(SalidaDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public SalidaDomain getById(Integer domainId) {
		return (SalidaDomain) sessionFactory.getCurrentSession().get(SalidaDomain.class, domainId);
	}

	@Override
	public List<SalidaDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SalidaDomain.class);
		return criteria.list();
	}
	
	@Override
	public List<SalidaDomain> find(String textToFind) {

		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from SalidaDomain where _descripcion like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}
	
	
	/*public List<SalidaDomain> find(String textToFind, int page, int maxItems) throws BibliotecaException, ParseException {
		Date minDate, maxDate;
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SalidaDomain.class, "salida").createAlias("salida._motivo_salida", "motivo");
		if (textToFind != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Map<String, String> map = obtenerQuery(textToFind);

			if (map.containsKey("motivo")) { // si quiere filtrar por motivo
				Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.ilike("motivo._descripcion", "%"+map.get("motivo")+"%"));

			}

			if (map.containsKey("start") && map.containsKey("end")) { // buscar entre fechas
																		
				try {
					minDate = formatter.parse(map.get("start"));
					Calendar c = Calendar.getInstance();
					c.setTime(formatter.parse(map.get("end")));
					c.add(Calendar.DATE, 1);
					maxDate = c.getTime();
				
					criteria.add(Restrictions.between("_fecha", minDate, maxDate));
				} catch (ParseException e) {
					throw new BibliotecaException("Formato de ruta invalido", e);
				}
			} else if (map.containsKey("fecha")) { // si quiere filtrar por una
													// fecha
													// especifica
				try {
					criteria.add(Restrictions.eq("_fecha", formatter.parse(map.get("fecha"))));
				} catch (ParseException e) {
					throw new BibliotecaException("Formato de ruta invalido", e);
				}
			}
		}
		criteria.addOrder(Order.desc("_id"));
		criteria.setFirstResult(page * maxItems);
		criteria.setMaxResults(maxItems);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<SalidaDomain> salidas = criteria.list();
		return salidas;
	}
*/
	public List<SalidaDomain> find(String textToFind, int page, int maxItems) throws BibliotecaException, ParseException {
	Session session = sessionFactory.getCurrentSession();
	Criteria criteria = session.createCriteria(SalidaDomain.class);

	if (textToFind != null) {
		Criterion propertyCriterion = Restrictions.ilike("_descripcion",
				textToFind);
		Criterion idCriterion = null;
		if (StringUtils.isNumeric(textToFind)) {
			idCriterion = Restrictions.eq("_id",
					Integer.valueOf(textToFind));
		}
		if (idCriterion != null) {
			criteria.add(Restrictions.or(propertyCriterion, idCriterion));
		} else {
			criteria.add(propertyCriterion);
		}
	}
	criteria.addOrder(Order.asc("_descripcion"));
	criteria.setFirstResult(page * maxItems);
	criteria.setMaxResults(maxItems);
	criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
	List<SalidaDomain> salidas = criteria.list();
	return salidas;
	
	}
	
	private Map<String, String> obtenerQuery(String textToFind) throws BibliotecaException {
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
