package com.sd.uni.biblioteca.dao.contacto;

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
import com.sd.uni.biblioteca.domain.contacto.ContactoDomain;
import com.sd.uni.biblioteca.exception.BibliotecaException;

@Repository
public class ContactoDaoImpl extends BaseDaoImpl<ContactoDomain> implements IContactoDao {
	@Autowired
	private SessionFactory _sessionFactory;

	@Override
	public ContactoDomain save(ContactoDomain domain) {
		_sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public ContactoDomain getById(Integer domainId)  {
		
			return (ContactoDomain) _sessionFactory.getCurrentSession().get(ContactoDomain.class, domainId);
		
	}

	@Override
	public List<ContactoDomain> findAll() {
		final Criteria criteria = _sessionFactory.getCurrentSession().createCriteria(ContactoDomain.class);
		return criteria.list();
	}

	@Override
	public List<ContactoDomain> find(String textToFind) {
		Session session = _sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ContactoDomain.class);
		Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.ilike("_descripcion", textToFind));				
		Criterion idCriterion = null;
		if (StringUtils.isNumeric(textToFind)) {
			idCriterion = Restrictions.eq("_id", Integer.valueOf(textToFind));
		}
		if (idCriterion != null) {
			criteria.add(Restrictions.or(propertyCriterion, idCriterion));
		} else {
			criteria.add(propertyCriterion);
		}
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<ContactoDomain> contactos = criteria.list();
		return contactos;
	}

	

}
