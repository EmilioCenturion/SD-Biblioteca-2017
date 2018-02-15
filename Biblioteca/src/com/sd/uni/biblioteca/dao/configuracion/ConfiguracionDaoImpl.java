package com.sd.uni.biblioteca.dao.configuracion;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dao.base.BaseDaoImpl;
import com.sd.uni.biblioteca.domain.configuracion.ConfiguracionDomain;

@Repository
public class ConfiguracionDaoImpl extends BaseDaoImpl<ConfiguracionDomain> implements IConfiguracionDao{

	@Autowired
	private SessionFactory sessionFactory;

	public ConfiguracionDomain delete(ConfiguracionDomain domain){
		sessionFactory.getCurrentSession().delete(domain);
		return domain;
	}

	@Override
	public ConfiguracionDomain save(ConfiguracionDomain domain){
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public ConfiguracionDomain getById(Integer domainId){
		return (ConfiguracionDomain) sessionFactory.getCurrentSession().get(ConfiguracionDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConfiguracionDomain> findAll(){
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ConfiguracionDomain.class);
		return criteria.list();
	}

	@Override
	public ConfiguracionDomain getBy(Map<String, String> args) {		
		return null;		
	}

	@Override
	public List<ConfiguracionDomain> find(String textToFind) {
		// TODO Auto-generated method stub
		return null;
	}
}