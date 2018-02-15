package com.sd.uni.biblioteca.dao.salidaDetalle;

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
import com.sd.uni.biblioteca.domain.rol.RolDomain;
import com.sd.uni.biblioteca.domain.salida.SalidaDomain;
import com.sd.uni.biblioteca.domain.salidaDetalle.SalidaDetalleDomain;
import com.sd.uni.biblioteca.domain.usuario.UsuarioDomain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

@Repository
public class SalidaDetalleDaoImpl extends BaseDaoImpl<SalidaDetalleDomain> implements ISalidaDetalleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SalidaDetalleDomain save(SalidaDetalleDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public SalidaDetalleDomain getById(Integer domainId) {
		return (SalidaDetalleDomain) sessionFactory.getCurrentSession().get(SalidaDetalleDomain.class, domainId);
	}

	@Override
	public List<SalidaDetalleDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SalidaDetalleDomain.class);
		return criteria.list();
	}
	
	public List<SalidaDetalleDomain> find(String textToFind) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SalidaDetalleDomain.class);
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
		List<SalidaDetalleDomain> salida_detalles = criteria.list();
		return salida_detalles;
	}

}
