package com.sd.uni.biblioteca.service.contacto;

import com.sd.uni.biblioteca.dao.contacto.ContactoDaoImpl;
import com.sd.uni.biblioteca.domain.contacto.ContactoDomain;
import com.sd.uni.biblioteca.dto.contacto.ContactoDto;
import com.sd.uni.biblioteca.dto.contacto.ContactoResult;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface IContactoService extends IBaseService<ContactoDto, ContactoDomain, ContactoDaoImpl, ContactoResult>{
	
}
