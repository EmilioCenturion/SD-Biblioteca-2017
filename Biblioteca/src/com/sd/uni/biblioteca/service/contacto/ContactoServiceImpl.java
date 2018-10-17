package com.sd.uni.biblioteca.service.contacto;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.dao.contacto.IContactoDao;
import com.sd.uni.biblioteca.dao.contacto.ContactoDaoImpl;
import com.sd.uni.biblioteca.domain.contacto.ContactoDomain;
import com.sd.uni.biblioteca.dto.contacto.ContactoDto;
import com.sd.uni.biblioteca.dto.contacto.ContactoResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;



@Service
public class ContactoServiceImpl extends BaseServiceImpl<ContactoDto, ContactoDomain, ContactoDaoImpl, ContactoResult> implements IContactoService{
	@Autowired
	private IContactoDao _contactoDao;
	private static Logger logger = Logger.getLogger(ContactoServiceImpl.class);
	
	@Value("${mail.nombre_usuario:bibliotecadistri@gmail.com}")
	private String nombre_usuario;
	
	@Value("${mail.contrasena:BiiiB2018}")
	private String contrasena;
	
	@Override
	@Transactional
	public ContactoDto save(ContactoDto dto) {
		try { 
			final ContactoDomain contactoDomain = convertDtoToDomain(dto);
			final ContactoDomain contacto = _contactoDao.save(contactoDomain);
			final ContactoDto nuevodto = convertDomainToDto(contacto);
			//try {
				enviar(nuevodto);
			//} catch (BibliotecaException e) {
				// 
				//e.printStackTrace();
			//}
		return nuevodto;
		} catch(Exception ex) { 
			 logger.error(ex);
			 throw new RuntimeException("Error "+ContactoServiceImpl.class+"" + ex.getMessage(), ex); 
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ContactoDto getById(Integer id) {
		final ContactoDomain contactoDomain = _contactoDao.getById(id);
		final ContactoDto contactoDTO = convertDomainToDto(contactoDomain);
		return contactoDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public ContactoResult getAll() {
		final List<ContactoDto> contactos = new ArrayList<>();
		for (ContactoDomain domain : _contactoDao.findAll()) {
			final ContactoDto contacto = convertDomainToDto(domain);
			contactos.add(contacto);
		}

		final ContactoResult contactoResult = new ContactoResult();
		contactoResult.setContactos(contactos);
		return contactoResult;
	}

	@Override
	protected ContactoDto convertDomainToDto(ContactoDomain domain) {
		final ContactoDto contacto = new ContactoDto();
		contacto.setId(domain.getId());
		contacto.setNombre(domain.getNombre());
		contacto.setApellido(domain.getApellido());
		contacto.setCorreo(domain.getCorreo());
		contacto.setTelefono(domain.getTelefono());
		contacto.setMensaje(domain.getMensaje());
	
		return contacto;
	}

	@Override
	protected ContactoDomain convertDtoToDomain(ContactoDto dto){
		final ContactoDomain contacto = new ContactoDomain();
		contacto.setId(dto.getId());
		contacto.setNombre(dto.getNombre());
		contacto.setApellido(dto.getApellido());
		contacto.setCorreo(dto.getCorreo());
		contacto.setTelefono(dto.getTelefono());
		contacto.setMensaje(dto.getMensaje());
		
		return contacto;
	}

	@Override
	@Transactional(readOnly = true)
	public ContactoResult find(String textToFind) {
		final List<ContactoDto> contactos = new ArrayList<>();
		for (ContactoDomain domain : _contactoDao.find(textToFind)) {
			final ContactoDto dto = convertDomainToDto(domain);
			contactos.add(dto);
		}
		final ContactoResult contactoResult = new ContactoResult();
		contactoResult.setContactos(contactos);
		return contactoResult;
	}
	
	
	public ContactoDto enviar(ContactoDto dto){
		System.out.println("Enviando Contacto - mensaje: " + dto.getMensaje());
		System.out.println("Enviando Contacto - cliente: " + dto.getNombre());

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(nombre_usuario, contrasena);
			}
		});
		
		try {
			String text = "<!DOCTYPE html><html lang=\"es\"><head><title>Bootstrap Example</title>"
					+ "<meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
					+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">"
					+ "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>"
					+ "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>"
					+ "<style> .grey-color {background-color: #eee} .white-color {background-color: #fff; width: 50%;} .center {text-align: center; margin-left: auto; margin-right: auto; margin-bottom: auto; margin-top: auto;padding-top: 24px;} </style>"
					+ "<style> .red-color {background-color: #c43b1d} .center {text-align: center; margin-left: auto; margin-right: auto; margin-bottom: auto; margin-top: auto;} </style>"
					+ "</head><body>" 
					+ "<div class=\"container red-color\">"
					+ "<img alt=\" \" style=\"display:inline-block;margin:0;vertical-align:left\" width=\"143px\" height=\"68px\">"
					+ "</div>"
					+ "<div class=\"container grey-color\">"
				  	+ "<div class=\"row\"><div class=\"span12\"><div class=\"hero-unit center\">"
				    + "<br><br><h1>La Casona Restaurant - Contacto de clientes</h1><br/>"
				    + "<p>El cliente <b>" + dto.getNombre() + " " + dto.getApellido() + "</b> ha realizado la siguiente consulta:"
				    + "<div class=\"container white-color center\">"
					+ "<blockquote><br><p>\"" + dto.getMensaje() + "\"</p>"
				    + "<span class=\"label label-warning\"><span class=\"glyphicon glyphicon-info-sign\" aria-hidden=\"true\"></span><small>  No supervisamos las respuestas a este correo. </small></span>"
				    + "<br></div></div><br/></div></body></html>";
			
			System.out.println("Enviando mail de contacto...");
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(nombre_usuario));
			InternetAddress[] mailTo = {
					new InternetAddress("lilianalopez0710@gmail.com")
			};
			message.setRecipients(Message.RecipientType.TO, mailTo);
			
			//message.setSubject("Contacto" + dto.getCorreo());
			message.setContent(text, "text/html; charset=utf-8");
			Transport.send(message);

		} catch (MessagingException e) {
		} 
		return dto;
	}

	

}