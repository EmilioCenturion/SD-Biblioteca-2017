package com.sd.uni.biblioteca.dao.prestamo_detalle;

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
import com.sd.uni.biblioteca.domain.prestamo_detalle.Prestamo_detalleDomain;

@Repository
public class Prestamo_detalleDaoImpl extends BaseDaoImpl<Prestamo_detalleDomain> implements IPrestamo_detalleDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Prestamo_detalleDomain save(Prestamo_detalleDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public Prestamo_detalleDomain getById(Integer domainId) {
		return (Prestamo_detalleDomain) sessionFactory.getCurrentSession().get(Prestamo_detalleDomain.class, domainId);
	}

	@Override
	public List<Prestamo_detalleDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Prestamo_detalleDomain.class);
		return criteria.list();
	}

	
	public List<Prestamo_detalleDomain> find(String textToFind) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Prestamo_detalleDomain.class);
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
		List<Prestamo_detalleDomain> prestamos_detalle = criteria.list();
		return prestamos_detalle;
	}

	public List<Prestamo_detalleDomain> find2(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from Prestamo_detalleDomain where _name like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}

}

