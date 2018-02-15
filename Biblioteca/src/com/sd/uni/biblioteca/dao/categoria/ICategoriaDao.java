package com.sd.uni.biblioteca.dao.categoria;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.categoria.CategoriaDomain;

import java.util.List;


public interface ICategoriaDao extends IBaseDao<CategoriaDomain>{
	public List<CategoriaDomain>find(String textToFind);

	public List<CategoriaDomain> find(String textToFind, int page, int maxItems);
}
