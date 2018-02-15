package com.sd.uni.biblioteca.service.autor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.dao.autor.AutorDaoImpl;
import com.sd.uni.biblioteca.dao.autor.IAutorDao;
import com.sd.uni.biblioteca.domain.autor.AutorDomain;
import com.sd.uni.biblioteca.dto.autor.AutorDTO;
import com.sd.uni.biblioteca.dto.autor.AutorResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;




@Service
public class AutorServiceImpl extends BaseServiceImpl<AutorDTO, AutorDomain, AutorDaoImpl, AutorResult>
		implements IAutorService {
	@Autowired
	private IAutorDao autorDao;
	
	
	@Autowired
	private CacheManager cacheManager;

	@Override
	@Transactional
	@CacheEvict(value= "biblioteca-platform-cache",key = "'autor_'")
	@CachePut(value = "biblioteca-platform-cache", key = "'autor_' + #dto.id", condition="#dto.id!=null")
	public AutorDTO save(AutorDTO dto) {
		final AutorDomain domain = convertDtoToDomain(dto);
		final AutorDomain autorDomain = autorDao.save(domain);
		return convertDomainToDto(autorDomain);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value="biblioteca-platform-cache", key="'autor_'+#id")
	public AutorDTO getById(Integer id) throws BibliotecaException {
		final AutorDomain domain = autorDao.getById(id);
		final AutorDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value= "biblioteca-platform-cache")
	public AutorResult getAll() {
		final List<AutorDTO> autors = new ArrayList<>();
		for (AutorDomain domain : autorDao.findAll()) {
			final AutorDTO dto = convertDomainToDto(domain);
			cacheManager.getCache("biblioteca-platform-cache")
						.put("autor_" + domain.getId(), domain);
			autors.add(dto);
		}
		final AutorResult autorResult = new AutorResult();
		autorResult.setAutors(autors);
		return autorResult;
	}

	@Override
	@Transactional
	public AutorResult find(String textToFind) {
		final List<AutorDTO> autores = new ArrayList<>();
		for (AutorDomain domain : autorDao.find(textToFind)) {
			final AutorDTO dto = convertDomainToDto(domain);
			autores.add(dto);
		}
		final AutorResult autorResult = new AutorResult();
		autorResult.setAutors(autores);
		return autorResult;
	}

	@Override
	protected AutorDTO convertDomainToDto(AutorDomain domain) {
		final AutorDTO dto = new AutorDTO();
		dto.setId(domain.getId());
		dto.setNombre(domain.getNombre());
		return dto;
	}

	@Override
	protected AutorDomain convertDtoToDomain(AutorDTO dto) {
		final AutorDomain domain = new AutorDomain();
		domain.setId(dto.getId());
		domain.setNombre(dto.getNombre());
		return domain;
	}
	
	@Override
	@Transactional(readOnly = true)
	public AutorResult find(String textToFind, int page, int maxItems) throws BibliotecaException {
		final List<AutorDTO> autores = new ArrayList<>();
		for (AutorDomain domain : autorDao.find(textToFind, page, maxItems)) {
			final AutorDTO dto = convertDomainToDto(domain);
			autores.add(dto);
		}
		final AutorResult autorResult = new AutorResult();
		autorResult.setAutors(autores);
		return autorResult;
	}

}