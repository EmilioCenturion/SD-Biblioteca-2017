package com.sd.uni.biblioteca.dao.base;

import java.util.List;

import com.sd.uni.biblioteca.domain.base.BaseDomain;

public interface IBaseDao<DOMAIN extends BaseDomain> {

	public DOMAIN save(DOMAIN domain);

	public DOMAIN getById(Integer domainId);
	
	public abstract List<DOMAIN>find(String textToFind);

	public List<DOMAIN> findAll();
}
