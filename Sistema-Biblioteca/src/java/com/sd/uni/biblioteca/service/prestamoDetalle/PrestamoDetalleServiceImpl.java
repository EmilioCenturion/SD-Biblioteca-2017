package com.sd.uni.biblioteca.service.prestamoDetalle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.biblioteca.beans.prestamoDetalle.PrestamoDetalleB;
import com.sd.uni.biblioteca.rest.prestamoDetalle.IPrestamoDetalleResource;
import com.sd.uni.biblioteca.rest.prestamoDetalle.PrestamoDetalleResourceImpl;
import com.sd.uni.biblioteca.dto.prestamo_detalle.PrestamoDetalleDTO;
import com.sd.uni.biblioteca.dto.prestamo_detalle.PrestamoDetalleResult;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;
import com.sd.uni.biblioteca.service.libro.ILibroService;
import com.sd.uni.biblioteca.service.libro.LibroServiceImpl;
import com.sd.uni.biblioteca.service.prestamo.IPrestamoService;
import com.sd.uni.biblioteca.service.prestamo.PrestamoServiceImpl;
import com.sd.uni.biblioteca.service.rol.IRolService;
import com.sd.uni.biblioteca.service.rol.RolServiceImpl;
@Service("prestamoDetalleService")
public class PrestamoDetalleServiceImpl extends BaseServiceImpl<PrestamoDetalleB, PrestamoDetalleDTO> implements IPrestamoDetalleService {
	@Autowired
	private  IPrestamoDetalleResource _prestamoDetalleResource= new PrestamoDetalleResourceImpl();
	@Autowired
	private IPrestamoService _prestamoService=new PrestamoServiceImpl();
	@Autowired
	private ILibroService _libroService=new LibroServiceImpl();
	@Autowired
	private IEstadoService _estadoService=new EstadoServiceImpl();

	public PrestamoDetalleServiceImpl() {
	}

	@Override
	public PrestamoDetalleB save(PrestamoDetalleB bean) {
		final PrestamoDetalleDTO dto = convertBeanToDto(bean);
		final PrestamoDetalleDTO prestamoDetalleDTO = _prestamoDetalleResource.save(dto);
		return convertDtoToBean(prestamoDetalleDTO);
	}

	@Override
	public List<PrestamoDetalleB> getAll() {
		final PrestamoDetalleResult result = _prestamoDetalleResource.getAll();
		final List<PrestamoDetalleDTO> uList = null == result.getPrestamoDetalles() ? new ArrayList<PrestamoDetalleDTO>() : result.getPrestamosDetalle();
		final List<PrestamoDetalleB> usuarios = new ArrayList<PrestamoDetalleB>();

		for (PrestamoDetalleDTO dto : uList) {
			final PrestamoDetalleB prestamoDetalle = convertDtoToBean(dto);
			prestamoDetalles.add(prestamoDetalle);
		}
		return prestamoDetalles;
	}

	@Override
	public PrestamoDetalleB getById(Integer id) {
		final PrestamoDetalleDTO dto = _prestamoDetalleResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected PrestamoDetalleB convertDtoToBean(PrestamoDetalleDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("fecha_devolucion", dto.getFecha_devolucion());
		final PrestamoDetalleB prestamoDetalle = new PrestamoDetalleB(params);
		prestamoDetalle.setPrestamo(_prestamoService.getById(dto.getPrestamoId()));
		prestamoDetalle.setLibro(_libroService.getById(dto.getLibroId()));
		prestamoDetalle.setEstado(_estadoService.getById(dto.getEstadoId()));
		return prestamoDetalle;
	}

	@Override
	protected PrestamoDetalleDTO convertBeanToDto(PrestamoDetalleB bean) {
		final PrestamoDetalleDTO dto = new PrestamoDetalleDTO();
		dto.setId(bean.getId());
		dto.setLibroId(bean.getLibro().getId());
		dto.setPrestamoId(bean.getPrestamo().getId());
		dto.setEstadoId(bean.getEstado().getId());
		dto.setFecha_devolucion(bean.getFecha_devolucion());
		return dto;
	}

}
