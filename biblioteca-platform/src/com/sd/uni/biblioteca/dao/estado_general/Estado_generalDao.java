package com.sd.uni.biblioteca.dao.estado_general;

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
import com.sd.uni.biblioteca.domain.estado_general.Estado_generalDomain;

@Repository
public class Estado_generalDaoImpl extends BaseDaoImpl<Estado_generalDomain> implements IEstado_generalDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Estado_generalDomain save(Estado_generalDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public Estado_generalDomain getById(Integer domainId) {
		return (Estado_generalDomain) sessionFactory.getCurrentSession().get(Estado_generalDomain.class, domainId);
	}

	@Override
	public List<Estado_generalDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Estado_generalDomain.class);
		return criteria.list();
	}

	
	public List<Estado_generalDomain> find(String textToFind) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Estado_generalDomain.class);
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
		List<Estado_generalDomain> estados_general = criteria.list();
		return estados_general;
	}

	public List<Estado_generalDomain> find2(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from Estado_generalDomain where _name like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}

}

