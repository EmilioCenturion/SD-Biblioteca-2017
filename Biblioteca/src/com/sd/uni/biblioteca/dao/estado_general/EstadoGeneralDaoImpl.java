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
import com.sd.uni.biblioteca.domain.estado_general.EstadoGeneralDomain;

@Repository
public class EstadoGeneralDaoImpl extends BaseDaoImpl<EstadoGeneralDomain> implements IEstadoGeneralDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public EstadoGeneralDomain save(EstadoGeneralDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public EstadoGeneralDomain getById(Integer domainId) {
		return (EstadoGeneralDomain) sessionFactory.getCurrentSession().get(EstadoGeneralDomain.class, domainId);
	}

	@Override
	public List<EstadoGeneralDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EstadoGeneralDomain.class);
		return criteria.list();
	}

	@Override
	public List<EstadoGeneralDomain> find(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from Estado_generalDomain where _descripcion like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}

}

