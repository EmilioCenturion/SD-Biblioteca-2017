package com.sd.uni.biblioteca.dao.salida;

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


import com.sd.uni.biblioteca.dao.salida.ISalidaDao;
import com.sd.uni.biblioteca.domain.salida.SalidaDomain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

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
	
	public List<SalidaDomain> find(String textToFind) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SalidaDomain.class);
		Criterion nameCriterion =Restrictions.ilike("_fecha", textToFind);
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
		List<SalidaDomain> salidas = criteria.list();
		return salidas;
	}

}
