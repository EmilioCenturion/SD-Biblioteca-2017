package com.sd.uni.biblioteca.dao.categoria;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.categoria.CategoriaDomain;

public interface ICategoriaDao extends IBaseDao<CategoriaDomain> {

	public List<CategoriaDomain>find(String textToFind);

	public List<CategoriaDomain> find(String textToFind, int page, int maxItems);
}
