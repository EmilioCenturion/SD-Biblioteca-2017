package com.sd.uni.biblioteca.dao.role;


import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dao.base.BaseDaoImpl;
import com.sd.uni.biblioteca.domain.role.RoleDomain;


@Repository
public class RoleDaoImpl extends BaseDaoImpl<RoleDomain> implements IRoleDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public RoleDomain delete(RoleDomain domain){
		sessionFactory.getCurrentSession().delete(domain);
		return domain;
	}
	
	@Override
	public RoleDomain save(RoleDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public RoleDomain getById(Integer domainId) {
		return (RoleDomain) sessionFactory.getCurrentSession().get(RoleDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RoleDomain.class);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleDomain> findAllBy(Map<String, String> args) {
		if(args.containsKey("authority")){
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("select * from role where authority=:authority");
			query.addEntity(RoleDomain.class); // Define el tipo de resultado de la consulta
			query.setString("authority", args.get("authority"));
			return query.list();
		}else{
			return null;
		}
	}

	@Override
	public List<RoleDomain> find(String textToFind) {
		// TODO Auto-generated method stub
		return null;
	}

}

