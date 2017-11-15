package com.sd.uni.biblioteca.service.autor;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.biblioteca.beans.autor.AutorB;
import com.sd.uni.biblioteca.rest.autor.IAutorResource;
import com.sd.uni.biblioteca.rest.autor.AutorResourceImpl;
import com.sd.uni.biblioteca.dto.autor.AutorDTO;
import com.sd.uni.biblioteca.dto.autor.AutorResult;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service("autorService")
public class AutorServiceImpl extends BaseServiceImpl<AutorB, AutorDTO>
		implements IAutorService {
	@Autowired
	private IAutorResource _autorResource=new AutorResourceImpl();
	
	@Override
	public AutorB save(AutorB bean) {
		final AutorDTO dto = convertBeanToDto(bean);
		final AutorDTO autorDTO = _autorResource.save(dto);
		return convertDtoToBean(autorDTO);
	}

	@Override
	public List<AutorB> getAll() {
		final AutorResult result = _autorResource.getAll();
		final List<AutorDTO> rList = null == result.getAutors() ? new ArrayList<AutorDTO>()
				: result.getAutors();
		final List<AutorB> autors = new ArrayList<AutorB>();

		for (AutorDTO dto : rList) {
			final AutorB autorB = convertDtoToBean(dto);
			autors.add(autorB);
		}
		return autors;
	}

	@Override
	public AutorB getById(Integer id) {
		final AutorDTO dto = _autorResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected AutorB convertDtoToBean(AutorDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("nombre", dto.getNombre());
		final AutorB autorB = new AutorB(params);
		return autorB;
	}

	@Override
	protected AutorDTO convertBeanToDto(AutorB bean) {
		final AutorDTO dto = new AutorDTO();
		dto.setId(bean.getId());
		dto.setNombre(bean.getNombre());
		return dto;
	}

}
