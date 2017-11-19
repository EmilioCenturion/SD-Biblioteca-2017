package com.sd.uni.biblioteca.service.entradaDetalle;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.biblioteca.beans.entradaDetalle.EntradaDetalleB;
import com.sd.uni.biblioteca.rest.entradaDetalle.IEntradaDetalleResource;
import com.sd.uni.biblioteca.rest.entradaDetalle.EntradaDetalleResourceImpl;
import com.sd.uni.biblioteca.dto.entradaDetalle.EntradaDetalleDTO;
import com.sd.uni.biblioteca.dto.entradaDetalle.EntradaDetalleResult;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;
import com.sd.uni.biblioteca.service.entrada.EntradaServiceImpl;
import com.sd.uni.biblioteca.service.entrada.IEntradaService;
import com.sd.uni.biblioteca.service.libro.ILibroService;
import com.sd.uni.biblioteca.service.libro.LibroServiceImpl;
@Service("entradaDetalleService")
public class EntradaDetalleServiceImpl extends BaseServiceImpl<EntradaDetalleB, EntradaDetalleDTO> implements IEntradaDetalleService {
	@Autowired
	private  IEntradaDetalleResource _entradaDetalleResource= new EntradaDetalleResourceImpl();
	@Autowired
	private ILibroService _libroService=new LibroServiceImpl();
	@Autowired
	private IEntradaService _entradaService=new EntradaServiceImpl();

	public EntradaDetalleServiceImpl() {
	}

	@Override
	public EntradaDetalleB save(EntradaDetalleB bean) {
		final EntradaDetalleDTO dto = convertBeanToDto(bean);
		final EntradaDetalleDTO entradaDetalleDTO = _entradaDetalleResource.save(dto);
		return convertDtoToBean(entradaDetalleDTO);
	}

	@Override
	public List<EntradaDetalleB> getAll() {
		final EntradaDetalleResult result = _entradaDetalleResource.getAll();
		final List<EntradaDetalleDTO> uList = null == result.getEntradaDetalles() ? new ArrayList<EntradaDetalleDTO>() : result.getEntradaDetalles();
		final List<EntradaDetalleB> entradaDetalles = new ArrayList<EntradaDetalleB>();

		for (EntradaDetalleDTO dto : uList) {
			final EntradaDetalleB entradaDetalle = convertDtoToBean(dto);
			entradaDetalles.add(entradaDetalle);
		}
		return entradaDetalles;
	}

	@Override
	public EntradaDetalleB getById(Integer id) {
		final EntradaDetalleDTO dto = _entradaDetalleResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected EntradaDetalleB convertDtoToBean(EntradaDetalleDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		
		final EntradaDetalleB entradaDetalle = new EntradaDetalleB(params);
		entradaDetalle.setLibro(_libroService.getById(dto.getLibroId()));
		entradaDetalle.setEntrada(_entradaService.getById(dto.getEntradaId()));
		entradaDetalle.setCantidad(dto.getCantidad());
		return entradaDetalle;
	}

	@Override
	protected EntradaDetalleDTO convertBeanToDto(EntradaDetalleB bean) {
		final EntradaDetalleDTO dto = new EntradaDetalleDTO();
		dto.setId(bean.getId());
		dto.setLibroId(bean.getLibro().getId());
		dto.setEntradaId(bean.getEntrada().getId());
		dto.setCantidad(bean.getCantidad());
		return dto;
	}

}
