package com.sd.uni.biblioteca.dao.libro;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dao.base.BaseDaoImpl;
import com.sd.uni.biblioteca.dao.libro.ILibroDao;
import com.sd.uni.biblioteca.domain.libro.LibroDomain;

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

	
	public List<LibroDomain> find(String textToFind) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(LibroDomain.class);
		Criterion nameCriterion =Restrictions.ilike("_name", textToFind);
		Criterion idCriterion = null;
		if (StringUtils.isNumeric(textToFind)) {
			idCriterion=Restrictions.eq("_id", Integer.valueOf(textToFind));
		}
		
		if(idCriterion!=null){
			criteria.add(Restrictions.or(nameCriterion, idCriterion));
		}else{
			criteria.add(nameCriterion);
		}
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<LibroDomain> libros = criteria.list();
		return libros;
	}

	public List<LibroDomain> find2(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from LibroDomain where _name like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}

}

