package com.sd.uni.biblioteca.service.salidaDetalle;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.biblioteca.beans.salidaDetalle.SalidaDetalleB;
import com.sd.uni.biblioteca.rest.salidaDetalle.ISalidaDetalleResource;
import com.sd.uni.biblioteca.rest.salidaDetalle.SalidaDetalleResourceImpl;
import com.sd.uni.biblioteca.dto.salidaDetalle.SalidaDetalleDTO;
import com.sd.uni.biblioteca.dto.salidaDetalle.SalidaDetalleResult;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;
import com.sd.uni.biblioteca.service.salida.SalidaServiceImpl;
import com.sd.uni.biblioteca.service.salida.ISalidaService;
import com.sd.uni.biblioteca.service.libro.ILibroService;
import com.sd.uni.biblioteca.service.libro.LibroServiceImpl;
@Service("salidaDetalleService")
public class SalidaDetalleServiceImpl extends BaseServiceImpl<SalidaDetalleB, SalidaDetalleDTO> implements ISalidaDetalleService {
	@Autowired
	private  ISalidaDetalleResource _salidaDetalleResource= new SalidaDetalleResourceImpl();
	@Autowired
	private ILibroService _libroService=new LibroServiceImpl();
	@Autowired
	private ISalidaService _salidaService=new SalidaServiceImpl();

	public SalidaDetalleServiceImpl() {
	}

	@Override
	public SalidaDetalleB save(SalidaDetalleB bean) {
		final SalidaDetalleDTO dto = convertBeanToDto(bean);
		final SalidaDetalleDTO salidaDetalleDTO = _salidaDetalleResource.save(dto);
		return convertDtoToBean(salidaDetalleDTO);
	}

	@Override
	public List<SalidaDetalleB> getAll() {
		final SalidaDetalleResult result = _salidaDetalleResource.getAll();
		final List<SalidaDetalleDTO> uList = null == result.getSalidaDetalles() ? new ArrayList<SalidaDetalleDTO>() : result.getSalidaDetalles();
		final List<SalidaDetalleB> salidaDetalles = new ArrayList<SalidaDetalleB>();

		for (SalidaDetalleDTO dto : uList) {
			final SalidaDetalleB salidaDetalle = convertDtoToBean(dto);
			salidaDetalles.add(salidaDetalle);
		}
		return salidaDetalles;
	}

	@Override
	public SalidaDetalleB getById(Integer id) {
		final SalidaDetalleDTO dto = _salidaDetalleResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected SalidaDetalleB convertDtoToBean(SalidaDetalleDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		
		final SalidaDetalleB salidaDetalle = new SalidaDetalleB(params);
		salidaDetalle.setLibro(_libroService.getById(dto.getLibroId()));
		salidaDetalle.setSalida(_salidaService.getById(dto.getSalidaId()));
		salidaDetalle.setCantidad(dto.getCantidad());
		return salidaDetalle;
	}

	@Override
	protected SalidaDetalleDTO convertBeanToDto(SalidaDetalleB bean) {
		final SalidaDetalleDTO dto = new SalidaDetalleDTO();
		dto.setId(bean.getId());
		dto.setLibroId(bean.getLibro().getId());
		dto.setSalidaId(bean.getSalida().getId());
		dto.setCantidad(bean.getCantidad());
		return dto;
	}

}
