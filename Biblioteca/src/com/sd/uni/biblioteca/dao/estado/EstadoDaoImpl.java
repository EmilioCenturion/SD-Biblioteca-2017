package com.sd.uni.biblioteca.dao.estado;

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
import com.sd.uni.biblioteca.domain.estado.EstadoDomain;

@Repository
public class EstadoDaoImpl extends BaseDaoImpl<EstadoDomain> implements IEstadoDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public EstadoDomain save(EstadoDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public EstadoDomain getById(Integer domainId) {
		return (EstadoDomain) sessionFactory.getCurrentSession().get(EstadoDomain.class, domainId);
	}

	@Override
	public List<EstadoDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EstadoDomain.class);
		return criteria.list();
	}
	
	@Override
	public List<EstadoDomain> find(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from EstadoDomain where _descripcion like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}

}

