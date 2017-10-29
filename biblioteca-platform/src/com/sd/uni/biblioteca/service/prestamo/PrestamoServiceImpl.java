package com.sd.uni.biblioteca.service.prestamo;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.dao.rol.IRolDao;
import com.sd.uni.biblioteca.dao.prestamo.IPrestamoDao;
import com.sd.uni.biblioteca.dao.prestamo.PrestamoDaoImpl;
import com.sd.uni.biblioteca.domain.prestamo.PrestamoDomain;
import com.sd.uni.biblioteca.dto.prestamo.PrestamoDTO;
import com.sd.uni.biblioteca.dto.prestamo.PrestamoResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class PrestamoServiceImpl extends BaseServiceImpl<PrestamoDTO, PrestamoDomain, PrestamoDaoImpl, PrestamoResult>
		implements IPrestamoService {
	@Autowired
	private IPrestamoDao usuarioDao;
	
	@Autowired
	private IPrestamoDao prestamoDao;

	@Override
	@Transactional
	public PrestamoDTO save(PrestamoDTO dto) {
		final PrestamoDomain domain = convertDtoToDomain(dto);
		final PrestamoDomain prestamoDomain = prestamoDao.save(domain);
		return convertDomainToDto(prestamoDomain);
	}

	@Override
	@Transactional
	public PrestamoDTO getById(Integer id) throws BibliotecaException {
		final PrestamoDomain domain = usuarioDao.getById(id);
		final PrestamoDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public PrestamoResult getAll() {
		final List<PrestamoDTO> prestamo = new ArrayList<>();
		for (PrestamoDomain domain : prestamoDao.findAll()) {
			final PrestamoDTO dto = convertDomainToDto(domain);
			prestamo.add(dto);
		}
		final PrestamoResult prestamoResult = new PrestamoResult();
		prestamoResult.setPrestamos(prestamo);
		return prestamoResult;
	}

	@Override
	@Transactional
	public PrestamoResult find(String textToFind) {
		final List<PrestamoDTO> prestamos = new ArrayList<>();
		for (PrestamoDomain domain : prestamoDao.find(textToFind)) {
			final PrestamoDTO dto = convertDomainToDto(domain);
			prestamos.add(dto);
		}
		final PrestamoResult prestamoResult = new PrestamoResult();
		PrestamoResult.setPrestamos(prestamos);
		return prestamoResult;
	}

	@Override
	protected PrestamoDTO convertDomainToDto(PrestamoDomain domain) {
		final PrestamoDTO dto = new PrestamoDTO();
		dto.setId(domain.getId());
		dto.setFecha_prestamo(domain.getFecha_prestamo());
		dto.setFecha_limite(domain.getFecha_limite());
		dto.setEstado_generalId(((PrestamoDomain) domain.getEstado_general).getId());
		dto.setUsuarioId(domain.getUsuario().getId());
		return dto;
	}

	@Override
	protected PrestamoDomain convertDtoToDomain(PrestamoDTO dto) {
		final PrestamoDomain domain = new PrestamoDomain();
		domain.setId(dto.getId());
		domain.setFecha_prestamo(dto.getFecha_prestamo());
		domain.setFecha_limite(dto.getFecha_limite());
		domain.setEstado_generalId(dto.getEstado_generalId());
	
		
		return domain;
	}

}
