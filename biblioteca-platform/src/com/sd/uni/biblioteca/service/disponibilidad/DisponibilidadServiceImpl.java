package com.sd.uni.biblioteca.service.disponibilidad;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.dao.disponibilidad.IDisponibilidadDao;
import com.sd.uni.biblioteca.dao.disponibilidad.DisponibilidadDaoImpl;
import com.sd.uni.biblioteca.dao.libro.ILibroDao;
import com.sd.uni.biblioteca.dao.categoria.ICategoriaDao;
import com.sd.uni.biblioteca.domain.disponibilidad.DisponibilidadDomain;
import com.sd.uni.biblioteca.dto.disponibilidad.DisponibilidadDTO;
import com.sd.uni.biblioteca.dto.disponibilidad.DisponibilidadResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class DisponibilidadServiceImpl extends BaseServiceImpl<DisponibilidadDTO, DisponibilidadDomain, DisponibilidadDaoImpl, DisponibilidadResult>
		implements IDisponibilidadService {
	@Autowired
	private IDisponibilidadDao disponibilidadDao;
	
	@Autowired
	private ILibroDao libroDao;
	
	@Autowired
	private ICategoriaDao categoriaDao;

	@Override
	@Transactional
	public DisponibilidadDTO save(DisponibilidadDTO dto) {
		final DisponibilidadDomain domain = convertDtoToDomain(dto);
		final DisponibilidadDomain disponibilidadDomain = disponibilidadDao.save(domain);
		return convertDomainToDto(disponibilidadDomain);
	}

	@Override
	@Transactional
	public DisponibilidadDTO getById(Integer id) throws BibliotecaException {
		final DisponibilidadDomain domain = disponibilidadDao.getById(id);
		final DisponibilidadDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public DisponibilidadResult getAll() {
		final List<DisponibilidadDTO> disponibilidad = new ArrayList<>();
		for (DisponibilidadDomain domain : disponibilidadDao.findAll()) {
			final DisponibilidadDTO dto = convertDomainToDto(domain);
			disponibilidad.add(dto);
		}
		final DisponibilidadResult disponibilidadResult = new DisponibilidadResult();
		disponibilidadResult.setDisponibilidades(disponibilidad);
		return disponibilidadResult;
	}

	@Override
	@Transactional
	public DisponibilidadResult find(String textToFind) {
		final List<DisponibilidadDTO> disponibilidades = new ArrayList<>();
		for (DisponibilidadDomain domain : disponibilidadDao.find(textToFind)) {
			final DisponibilidadDTO dto = convertDomainToDto(domain);
			disponibilidades.add(dto);
		}
		final DisponibilidadResult disponibilidadResult = new DisponibilidadResult();
		disponibilidadResult.setDisponibilidades(disponibilidades);
		return disponibilidadResult;
	}

	@Override
	protected DisponibilidadDTO convertDomainToDto(DisponibilidadDomain domain) {
		final DisponibilidadDTO dto = new DisponibilidadDTO();
		dto.setId(domain.getId());
		dto.setCantidad(domain.getCantidad());
		dto.setLibroId(domain.getLibro().getId());
		return dto;
	}

	@Override
	protected DisponibilidadDomain convertDtoToDomain(DisponibilidadDTO dto) {
		final DisponibilidadDomain domain = new DisponibilidadDomain();
		domain.setId(dto.getId());
		domain.setCantidad(dto.getCantidad());
		domain.setLibro(libroDao.getById(dto.getLibroId()));
		
		return domain;
	}

}