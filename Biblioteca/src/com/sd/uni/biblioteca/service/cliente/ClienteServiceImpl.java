package com.sd.uni.biblioteca.service.cliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;
import com.sd.uni.biblioteca.utils.TomcatConnectors;
import com.sd.uni.biblioteca.dao.cliente.ClienteDaoImpl;
import com.sd.uni.biblioteca.dao.cliente.IClienteDao;
import com.sd.uni.biblioteca.dao.invitacion.IInvitacionDao;
import com.sd.uni.biblioteca.domain.cliente.ClienteDomain;
import com.sd.uni.biblioteca.domain.invitacion.InvitacionDomain;
import com.sd.uni.biblioteca.dto.cliente.ClienteDto;
import com.sd.uni.biblioteca.dto.cliente.ClienteResult;


@Service
public class ClienteServiceImpl extends BaseServiceImpl<ClienteDto, ClienteDomain, ClienteDaoImpl, ClienteResult> implements IClienteService{
	@Autowired
	private IClienteDao _clienteDao;
	
	private static Logger logger = Logger.getLogger(ClienteServiceImpl.class);
	
	@Autowired
	private IInvitacionDao _ofertaDao;
	
	
	@Autowired
	private CacheManager cacheManager;
	
	@Override
	@Transactional
	@CacheEvict(value= "biblioteca-platform-cache",key = "'cliente'")
	@CachePut(value = "biblioteca-platform-cache", key = "'cliente_' + #dto.id", condition="#dto.id!=null")
	public ClienteDto save(ClienteDto dto) {
		final ClienteDomain clienteDomain = convertDtoToDomain(dto);
		final ClienteDomain cliente = _clienteDao.save(clienteDomain);
		final ClienteDto nuevoDto = convertDomainToDto(cliente);
		if (null == dto.getId() ) {
			//getCacheManager().getCache("biblioteca-platform-cache").put("cliente_" +nuevoDto.getId(), nuevoDto);
			cacheManager.getCache("biblioteca-platform-cache").put("cliente_" +nuevoDto.getId(), nuevoDto);
		}
		
		return nuevoDto;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "biblioteca-platform-cache", key = "'cliente_' + #id")
	public ClienteDto getById(Integer id) throws BibliotecaException {
		final ClienteDomain clienteDomain = _clienteDao.getById(id);
		final ClienteDto clienteDTO = convertDomainToDto(clienteDomain);
		return clienteDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public ClienteResult getAll() {
		final List<ClienteDto> clientes = new ArrayList<>();
		for (ClienteDomain domain : _clienteDao.findAll()) {
			final ClienteDto cliente = convertDomainToDto(domain);
			clientes.add(cliente);
		}

		final ClienteResult clienteResult = new ClienteResult();
		clienteResult.setClientes(clientes);
		return clienteResult;
	}

	@Override
	protected ClienteDto convertDomainToDto(ClienteDomain domain) {
		final ClienteDto cliente = new ClienteDto();
		cliente.setId(domain.getId());
		cliente.setNombre(domain.getNombre());
		cliente.setApellido(domain.getApellido());
		cliente.setCi(domain.getCi());
		cliente.setRuc(domain.getRuc());
		cliente.setCorreo(domain.getCorreo());
		cliente.setTelefono(domain.getTelefono());
		cliente.setDireccion(domain.getDireccion());
		cliente.setInvitacion(domain.getInvitacion());
		
		
		TomcatConnectors t = new TomcatConnectors();
		
		return cliente;
	}

	@Override
	protected ClienteDomain convertDtoToDomain(ClienteDto dto) {
		final ClienteDomain cliente = new ClienteDomain();
		cliente.setId(dto.getId());
		cliente.setNombre(dto.getNombre());
		cliente.setApellido(dto.getApellido());
		cliente.setCi(dto.getCi());
		cliente.setRuc(dto.getRuc());
		cliente.setCorreo(dto.getCorreo());
		cliente.setTelefono(dto.getTelefono());
		cliente.setDireccion(dto.getDireccion());
		cliente.setInvitacion(dto.getInvitacion());
		
		if (cliente.getInvitacion()){
			String correo = dto.getCorreo();
			if (!"".equals(correo)){
				System.out.println("Pidiendo notificacion de oferta para: "+ correo);
				final InvitacionDomain invitacionDomain = new InvitacionDomain();
				invitacionDomain.setId(dto.getId());
				invitacionDomain.setCliente(cliente);;
				invitacionDomain.setFechaCreacion(new Date());
				invitacionDomain.setEmail(correo);
				_ofertaDao.save(invitacionDomain);
			}
		}

		
		return cliente;
	}

	@Override
	@Transactional(readOnly = true)
	public ClienteResult find(String textToFind) {
		final List<ClienteDto> clientes = new ArrayList<>();
		for (ClienteDomain domain : _clienteDao.find(textToFind)) {
			final ClienteDto dto = convertDomainToDto(domain);
			clientes.add(dto);
		}
		final ClienteResult clienteResult = new ClienteResult();
		clienteResult.setClientes(clientes);
		return clienteResult;
	}
	
	

	

}