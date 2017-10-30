package com.sd.uni.biblioteca.dao.reservaDetalle;

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




import com.sd.uni.biblioteca.domain.reservaDetalle.ReservaDetalleDomain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;


@Repository
public class ReservaDetalleDaoImpl extends BaseDaoImpl<ReservaDetalleDomain> implements IReservaDetalleDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ReservaDetalleDomain save(ReservaDetalleDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public ReservaDetalleDomain getById(Integer domainId) {
		return (ReservaDetalleDomain) sessionFactory.getCurrentSession().get(ReservaDetalleDomain.class, domainId);
	}

	@Override
	public List<ReservaDetalleDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ReservaDetalleDomain.class);
		return criteria.list();
	}
	
	
	

	
	public List<ReservaDetalleDomain> find2(String textToFind) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ReservaDetalleDomain.class);
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
		List<ReservaDetalleDomain> reservaDetalles = criteria.list();
		return reservaDetalles;
	}

	public List<ReservaDetalleDomain> find(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from ReservaDetalleDomain where _descripcion like :parameter or _ like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}

}


