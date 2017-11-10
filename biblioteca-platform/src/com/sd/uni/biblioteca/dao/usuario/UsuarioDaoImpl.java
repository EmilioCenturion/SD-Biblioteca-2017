package com.sd.uni.biblioteca.dao.usuario;


import java.util.HashMap;
import java.util.List;


import java.util.Map;

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
import com.sd.uni.biblioteca.domain.usuario.UsuarioDomain;
import com.sd.uni.biblioteca.exception.BibliotecaException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

@Repository
public class UsuarioDaoImpl extends BaseDaoImpl<UsuarioDomain> implements IUsuarioDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public UsuarioDomain save(UsuarioDomain domain) {
		domain=encryptContrasenha(domain);
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public UsuarioDomain getById(Integer domainId) {
		return (UsuarioDomain) sessionFactory.getCurrentSession().get(UsuarioDomain.class, domainId);
	}

	@Override
	public List<UsuarioDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UsuarioDomain.class);
		return criteria.list();
	}
	
	
	public UsuarioDomain encryptContrasenha(UsuarioDomain domain){
		MessageDigest md = null;
		String contrasenha = domain.getContrasenha();
	        try {
				md= MessageDigest.getInstance("SHA-512");
		        md.update(contrasenha.getBytes());
		        byte[] mb = md.digest();
		        String encContrasenha=String.valueOf(Hex.encodeHex(mb));
		        domain.setContrasenha(encContrasenha);
		        System.out.println(encContrasenha);
		        
	        } catch (NoSuchAlgorithmException e) {
	        	
	            System.out.println("Error");
	        }
	        
	        return domain;
	}

	public List<UsuarioDomain> find2(String textToFind) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UsuarioDomain.class);
		Criterion nameCriterion =Restrictions.ilike("_nombre", textToFind);
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
		List<UsuarioDomain> usuarios = criteria.list();
		return usuarios;
	}
	
	@Override
	public List<UsuarioDomain> find(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from UsuarioDomain where _nombre like :parameter or _contrasenha like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}
	
	@Override
	public List<UsuarioDomain> find(String textToFind, int page, int maxItems) throws BibliotecaException {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UsuarioDomain.class);

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
		List<UsuarioDomain> usuarios = criteria.list();
		return usuarios;
	}
	
	private Map<String, String> obtenerQuery(String textToFind) throws BibliotecaException {
		String[] params = textToFind.split("&");
		Map<String, String> map = new HashMap<String, String>();
		try {
			for (String param : params) {
				String name = param.split("=")[0];
				String value = param.split("=")[1];
				map.put(name, value);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new BibliotecaException("Formato de ruta invalido", e);
		}
		return map;
	}

}



