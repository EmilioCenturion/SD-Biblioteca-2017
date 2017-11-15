package com.sd.uni.biblioteca.service.disponiblilidad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.biblioteca.beans.disponibilidad.DisponibilidadLibroB;
import com.sd.uni.biblioteca.rest.disponibilidad.IDisponibilidadResource;
import com.sd.uni.biblioteca.rest.disponibilidad.DisponibilidadResourceImpl;
import com.sd.uni.biblioteca.dto.disponibilidad.DisponibilidadDTO;
import com.sd.uni.biblioteca.dto.disponibilidad.DisponibilidadResult;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;
import com.sd.uni.biblioteca.service.categoria.CategoriaServiceImpl;
import com.sd.uni.biblioteca.service.categoria.ICategoriaService;
import com.sd.uni.biblioteca.service.libro.ILibroService;
import com.sd.uni.biblioteca.service.libro.LibroServiceImpl;
import com.sd.uni.biblioteca.service.prestamo.PrestamoB;

@Service("disponibilidadService")
public class DisponibilidadServiceImpl extends BaseServiceImpl<DisponibilidadB, DisponibilidadDTO> implements IDisponibilidadService {
	@Autowired
	private  IDisponibilidadResource _disponibilidadResource= new DisponibilidadResourceImpl();
	@Autowired
	private ILibroService _libroService=new LibroServiceImpl();
	@Autowired
	private ICategoriaService _categoriaService=new CategoriaServiceImpl();

	public DisponibilidadServiceImpl() {
	}

	@Override
	public DisponibilidadB save(DisponibilidadB bean) {
		final DisponibilidadDTO dto = convertBeanToDto(bean);
		final DisponibilidadDTO disponibilidadDTO = _disponibilidadResource.save(dto);
		return convertDtoToBean(disponibilidadDTO);
	}

	@Override
	public List<DisponibilidadB> getAll() {
		final DisponibilidadResult result = _disponibilidadResource.getAll();
		final List<DisponibilidadDTO> uList = null == result.getDisponibilidades() ? new ArrayList<DisponibilidadDTO>() : result.getDisponibilidades();
		final List<DisponibilidadB> disponibilidades = new ArrayList<DisponibilidadB>();

		for (DisponibilidadDTO dto : uList) {
			final DisponibilidadB disponibilidad = convertDtoToBean(dto);
			disponibilidades.add(disponibilidad);
		}
		return disponibilidades;
	}

	@Override
	public DisponibilidadB getById(Integer id) {
		final DisponibilidadDTO dto = _disponibilidadResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected DisponibilidadB convertDtoToBean(DisponibilidadDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("cantidad", dto.getCantidad());
		final DisponibilidadB disponibilidad = new DisponibilidadB(params);
		disponibilidad.setLibro(_libroService.getById(dto.getLibroId()));
		disponibilidad.setCategoria(_categoriaService.getById(dto.getCategoriaId()));
		return disponibilidad;
	}

	@Override
	protected DisponibilidadDTO convertBeanToDto(DisponibilidadB bean) {
		final DisponibilidadDTO dto = new DisponibilidadDTO();
		dto.setId(bean.getId());
		dto.setLibroId(bean.getLibro().getId());
		dto.setCategoriaId(bean.getCategoria().getId());
		dto.setCantidad(bean.getCantidad());
		return dto;
	}

}
