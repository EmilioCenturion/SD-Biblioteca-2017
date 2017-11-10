package com.sd.uni.biblioteca.dao.autor;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dao.base.BaseDaoImpl;
import com.sd.uni.biblioteca.domain.autor.AutorDomain;

@Repository
public class AutorDaoImpl extends BaseDaoImpl<AutorDomain> implements IAutorDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public AutorDomain save(AutorDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public AutorDomain getById(Integer domainId) {
		return (AutorDomain) sessionFactory.getCurrentSession().get(
				AutorDomain.class, domainId);
	}

	@Override
	public List<AutorDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(AutorDomain.class);
		return criteria.list();
	}

	@Override
	public List<AutorDomain> find(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from AutorDomain where _nombre like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}

	@Override
	public List<AutorDomain> find(String textToFind, int page, int maxItems) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(AutorDomain.class);

		if (textToFind != null) {
			Criterion propertyCriterion = Restrictions.ilike("_nombre",
					textToFind);
			Criterion idCriterion = null;
			if (StringUtils.isNumeric(textToFind)) {
				idCriterion = Restrictions.eq("_id",
						Integer.valueOf(textToFind));
			}
			if (idCriterion != null) {
				criteria.add(Restrictions.or(propertyCriterion, idCriterion));
			} else {
				criteria.add(propertyCriterion);
			}
		}
		criteria.addOrder(Order.asc("_nombre"));
		criteria.setFirstResult(page * maxItems);
		criteria.setMaxResults(maxItems);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<AutorDomain> autores = criteria.list();
		return autores;
	}

}
