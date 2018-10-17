package com.sd.uni.biblioteca.dao.invitacion;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dao.base.BaseDaoImpl;
import com.sd.uni.biblioteca.domain.invitacion.InvitacionDomain;
import com.sd.uni.biblioteca.exception.BibliotecaException;




@Repository
public class InvitacionDaoImpl extends BaseDaoImpl<InvitacionDomain> implements IInvitacionDao {
		@Autowired
		private SessionFactory _sessionFactory;

		@Override
		public InvitacionDomain save(InvitacionDomain domain) {
			_sessionFactory.getCurrentSession().saveOrUpdate(domain);
			return domain;
		}

		@Override
		public InvitacionDomain getById(Integer domainId) {
				return (InvitacionDomain) _sessionFactory.getCurrentSession().get(InvitacionDomain.class, domainId);
			
		}

		@Override
		public List<InvitacionDomain> findAll() {
			Session session = _sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(InvitacionDomain.class);
			Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.eq("_envio", 0)); 
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			List<InvitacionDomain> ofertas = criteria.list();
			return ofertas;
		}

		@Override
		public List<InvitacionDomain> find(String texto) {
			return null;
		}
		

	}
