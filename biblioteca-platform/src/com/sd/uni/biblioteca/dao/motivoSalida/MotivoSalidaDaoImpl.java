package com.sd.uni.biblioteca.dao.motivoSalida;


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
import com.sd.uni.biblioteca.domain.motivo_salida.MotivoSalidaDomain;

@Repository
public class MotivoSalidaDaoImpl extends BaseDaoImpl<MotivoSalidaDomain> implements IMotivoSalidaDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public MotivoSalidaDomain save(MotivoSalidaDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public MotivoSalidaDomain getById(Integer domainId) {
		return (MotivoSalidaDomain) sessionFactory.getCurrentSession().get(MotivoSalidaDomain.class, domainId);
	}

	@Override
	public List<MotivoSalidaDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MotivoSalidaDomain.class);
		return criteria.list();
	}

	
	public List<MotivoSalidaDomain> find(String textToFind) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MotivoSalidaDomain.class);
		Criterion descripcionCriterion =Restrictions.ilike("_descripcion", textToFind);
		Criterion idCriterion = null;
		if (StringUtils.isNumeric(textToFind)) {
			idCriterion=Restrictions.eq("_id", Integer.valueOf(textToFind));
		}
		
		if(idCriterion!=null){
			criteria.add(Restrictions.or(descripcionCriterion, idCriterion));
		}else{
			criteria.add(descripcionCriterion);
		}
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<MotivoSalidaDomain> motivo_salidas = criteria.list();
		return motivo_salidas;
	}

	/*public List<MotivoSalidaDomain> find2(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from RolDomain where _nombre like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}*/

}
