package com.sd.uni.biblioteca.dao.motivoEntrada;


import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
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

	@Override
	public List<MotivoEntradaDomain> find(String textToFind) {
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
