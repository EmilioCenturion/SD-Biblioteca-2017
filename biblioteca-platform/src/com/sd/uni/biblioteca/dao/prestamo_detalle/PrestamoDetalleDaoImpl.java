package com.sd.uni.biblioteca.dao.prestamo_detalle;

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
import com.sd.uni.biblioteca.domain.prestamo_detalle.PrestamoDetalleDomain;

@Repository
public class PrestamoDetalleDaoImpl extends BaseDaoImpl<PrestamoDetalleDomain> implements IPrestamoDetalleDao {
	@Autowired
	private SessionFactory sessionFactory;

	public PrestamoDetalleDomain save(PrestamoDetalleDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public PrestamoDetalleDomain getById(Integer domainId) {
		return (PrestamoDetalleDomain) sessionFactory.getCurrentSession().get(PrestamoDetalleDomain.class, domainId);
	}

	@Override
	public List<PrestamoDetalleDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PrestamoDetalleDomain.class);
		return criteria.list();
	}

	
	public List<PrestamoDetalleDomain> find(String textToFind) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PrestamoDetalleDomain.class);
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
		List<PrestamoDetalleDomain> prestamos_detalle = criteria.list();
		return prestamos_detalle;
	}

	public List<PrestamoDetalleDomain> find2(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from Prestamo_detalleDomain where _name like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}

}

