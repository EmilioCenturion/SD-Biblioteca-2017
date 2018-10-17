package com.sd.uni.biblioteca.dao.cliente;

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
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.domain.cliente.ClienteDomain;

@Repository
public class ClienteDaoImpl extends BaseDaoImpl<ClienteDomain> implements IClienteDao {
	@Autowired
	private SessionFactory _sessionFactory;

	@Override
	public ClienteDomain save(ClienteDomain domain) {
		_sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public ClienteDomain getById(Integer domainId) {
		
			return (ClienteDomain) _sessionFactory.getCurrentSession().get(ClienteDomain.class, domainId);
		
	}

	@Override
	public List<ClienteDomain> findAll() {
		final Criteria criteria = _sessionFactory.getCurrentSession().createCriteria(ClienteDomain.class);
		return criteria.list();
	}

	@Override
	public List<ClienteDomain> find(String textToFind) {
		Session session = _sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ClienteDomain.class);
		Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.ilike("_nombre", textToFind))
				.add(Restrictions.ilike("_apellido", textToFind))
				.add(Restrictions.ilike("_ruc", textToFind))
				.add(Restrictions.ilike("_telefono", textToFind))
				.add(Restrictions.ilike("_correo", textToFind))
				.add(Restrictions.ilike("_direccion", textToFind))
				.add(Restrictions.ilike("_oferta", textToFind));
				//.add(Restrictions.ilike("_oferta", Boolean.valueOf(textToFind)));	
		Criterion idCriterion = null;
		if (StringUtils.isNumeric(textToFind)) {
			idCriterion = Restrictions.eq("_ci", Integer.valueOf(textToFind));
		}
		if (idCriterion != null) {
			criteria.add(Restrictions.or(propertyCriterion, idCriterion));
		} else {
			criteria.add(propertyCriterion);
		}
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<ClienteDomain> clientes = criteria.list();
		return clientes;
	}

	

}