package com.sd.uni.biblioteca.dao.disponibilidad;


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
import com.sd.uni.biblioteca.domain.disponibilidad.DisponibilidadDomain;

@Repository
public class DisponibilidadDaoImpl extends BaseDaoImpl<DisponibilidadDomain> implements IDisponibilidadDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public DisponibilidadDomain save(DisponibilidadDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public DisponibilidadDomain getById(Integer domainId) {
		return (DisponibilidadDomain) sessionFactory.getCurrentSession().get(DisponibilidadDomain.class, domainId);
	}

	@Override
	public List<DisponibilidadDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DisponibilidadDomain.class);
		return criteria.list();
	}

	
	public List<DisponibilidadDomain> find(String textToFind) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(DisponibilidadDomain.class);
		Criterion nameCriterion =Restrictions.ilike("_nombre", textToFind);
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
		List<DisponibilidadDomain> disponibilidades = criteria.list();
		return disponibilidades;
	}

	/*public List<DisponibilidadDomain> find2(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from RolDomain where _nombre like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}*/

}
