package com.sd.uni.biblioteca.service.prestamo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.biblioteca.beans.prestamo.PrestamoB;
import com.sd.uni.biblioteca.rest.prestamo.IPrestamoResource;
import com.sd.uni.biblioteca.rest.prestamo.PrestamoResourceImpl;
import com.sd.uni.biblioteca.dto.prestamo.PrestamoDTO;
import com.sd.uni.biblioteca.dto.prestamo.PrestamoResult;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;
import com.sd.uni.biblioteca.service.categoria.CategoriaServiceImpl;
import com.sd.uni.biblioteca.service.categoria.ICategoriaService;
import com.sd.uni.biblioteca.service.estadoGeneral.EstadoGeneralServiceImpl;
import com.sd.uni.biblioteca.service.estadoGeneral.IEstadoGeneralService;
import com.sd.uni.biblioteca.service.libro.ILibroService;
import com.sd.uni.biblioteca.service.libro.LibroServiceImpl;
import com.sd.uni.biblioteca.service.usuario.IUsuarioService;
import com.sd.uni.biblioteca.service.usuario.UsuarioServiceImpl;

@Service("prestamoService")
public class PrestamoServiceImpl extends BaseServiceImpl<PrestamoB, PrestamoDTO> implements IPrestamoService {
	@Autowired
	private  IPrestamoResource _prestamoResource= new PrestamoResourceImpl();
	private IUsuarioService _ususarioService=new UsuarioServiceImpl();
	private IEstadoGeneralService _estadoGeneralService=new EstadoGeneralServiceImpl();

	@Override
	public PrestamoB save(PrestamoB bean) {
		final PrestamoDTO dto = convertBeanToDto(bean);
		final PrestamoDTO prestamoDTO = _prestamoResource.save(dto);
		return convertDtoToBean(prestamoDTO);
	}

	@Override
	public List<PrestamoB> getAll() {
		final PrestamoResult result = _prestamoResource.getAll();
		final List<PrestamoDTO> uList = null == result.getPrestamos() ? new ArrayList<PrestamoDTO>() : result.getPrestamos();
		final List<PrestamoB> prestamos = new ArrayList<PrestamoB>();

		for (PrestamoDTO dto : uList) {
			final PrestamoB prestamo = convertDtoToBean(dto);
			prestamos.add(prestamo);
		}
		return prestamos;
	}

	@Override
	public PrestamoB getById(Integer id) {
		final PrestamoDTO dto = _prestamoResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected PrestamoB convertDtoToBean(PrestamoDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("fecha_prestamo", dto.getFechaPrestamo());
		params.put("fecha_limite", dto.getFechaLimite());
		final PrestamoB prestamo = new PrestamoB(params);
		prestamo.setUsuario(_ususarioService.getById(dto.getUsuarioId()));
		prestamo.setEstadoGeneral(_estadoGeneralService.getById(dto.getEstadoGeneralId()));
		return prestamo;
	}

	@Override
	protected PrestamoDTO convertBeanToDto(PrestamoB bean) {
		final PrestamoDTO dto = new PrestamoDTO();
		dto.setId(bean.getId());
		dto.setUsuarioId(bean.getUsuario().getId());
		dto.setEstadoGeneralId(bean.getEstadoGeneral().getId());
		dto.setFechaPrestamo(bean.getFecha_prestamo());
		dto.setFechaLimite(bean.getFecha_limite());
		return dto;
	}

}