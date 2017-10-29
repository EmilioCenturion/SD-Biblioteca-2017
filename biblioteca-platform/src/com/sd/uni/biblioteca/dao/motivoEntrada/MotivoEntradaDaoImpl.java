package com.sd.uni.biblioteca.dao.motivoEntrada;


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
import com.sd.uni.biblioteca.domain.motivoEntrada.MotivoEntradaDomain;

@Repository
public class MotivoEntradaDaoImpl extends BaseDaoImpl<MotivoEntradaDomain> implements IMotivoEntradaDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public MotivoEntradaDomain save(MotivoEntradaDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public MotivoEntradaDomain getById(Integer domainId) {
		return (MotivoEntradaDomain) sessionFactory.getCurrentSession().get(MotivoEntradaDomain.class, domainId);
	}

	@Override
	public List<MotivoEntradaDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MotivoEntradaDomain.class);
		return criteria.list();
	}

	
	public List<MotivoEntradaDomain> find(String textToFind) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MotivoEntradaDomain.class);
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
		List<MotivoEntradaDomain> motivoEntradas = criteria.list();
		return motivoEntradas;
	}

	public List<MotivoEntradaDomain> find2(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from MotivoEntradaDomain where _descripcion like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}

}
