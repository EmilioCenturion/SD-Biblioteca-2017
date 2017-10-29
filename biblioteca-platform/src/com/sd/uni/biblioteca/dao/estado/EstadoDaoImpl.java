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

	
	public List<EstadoDomain> find(String textToFind) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(EstadoDomain.class);
		Criterion nameCriterion =Restrictions.ilike("_name", textToFind);
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
		List<EstadoDomain> estados = criteria.list();
		return estados;
	}

	public List<EstadoDomain> find2(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from EstadoDomain where _name like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}

}

