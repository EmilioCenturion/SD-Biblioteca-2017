package com.sd.uni.biblioteca.service.invitacion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.dao.cliente.IClienteDao;
import com.sd.uni.biblioteca.dao.invitacion.IInvitacionDao;
import com.sd.uni.biblioteca.domain.cliente.ClienteDomain;
import com.sd.uni.biblioteca.domain.contacto.ContactoDomain;
import com.sd.uni.biblioteca.domain.invitacion.InvitacionDomain;





@Service
@Transactional
public class InvitacionServiceImpl implements IInvitacionService{
	@Autowired
	private IInvitacionDao invitacionDao;
	
	@Autowired
	private IClienteDao clienteDao;
	
	
	@Value("${mail.nombre_usuario}")
	private String nombre_usuario;
	
	@Value("${mail.contrasena}")
	private String contrasena;
	
	@Value("${mail.smtp.auth:true}")
	private String auth;
	
	@Value("${mail.smtp.starttls.enable:true}")
	private String enable;
	
	@Value("${mail.host:smtp.gmail.com}")
	private String host;
	
	@Value("${mail.port:587}")
	private String port;

	
	@Transactional(propagation = Propagation.REQUIRES_NEW )
	public boolean enviar(InvitacionDomain invitacion) throws BibliotecaException{

		ClienteDomain cliente = clienteDao.getById(invitacion.getCliente().getId());

		if(null != cliente){
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props,
					new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					System.out.println(nombre_usuario);
					return new PasswordAuthentication(
							"bibliotecadistri@gmail.com", "BiiiB2018");
				}
			});
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
			
			try {
				String text = "<!DOCTYPE html><html lang=\"es\"><head><title>Bootstrap Example</title>"
						+ "<meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
						+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">"
						+ "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>"
						+ "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>"
						+ "<style> .grey-color {background-color: #eee} .center {text-align: center; margin-left: auto; margin-right: auto; margin-bottom: auto; margin-top: auto; padding-top: 24px;} </style>"
						+ "<style> .red-color {background-color: #c43b1d} .center {text-align: center; margin-left: auto; margin-right: auto; margin-bottom: auto; margin-top: auto;} </style>"
						+ "</head><body>"
						+ "<div class=\"container red-color\">"
						+ "<img alt=\" \" style=\"display:inline-block;margin:0;vertical-align:middle\" width=\"143px\" height=\"68px\">"
						+ "</div>"
						+ "<div class=\"container grey-color\">"
					  	+ "<div class=\"row\"><div class=\"span12\"><div class=\"hero-unit center\">"
						+ "<div style=\"background-color:#fff;border-bottom:1px solid #e0e0e0;margin:0 auto;max-width:624px;min-width:154px;padding:0px 24px 0px\" align=\"center\">"
					    + "<br><br><h1>Hola " +  cliente.getNombre() + " " + cliente.getApellido() + "!"  + "</h1><br/>"
					    + "<p>Informacion importante </p>" + "<p> La biblioteca de la ciudad cuenta con nuevos ejemplares para difrutar. Le invitamos coordialmente a pasar por el local" 
					    + ".</p><br><p>Horario de Atecion</p>"
					    + "<p><b>Lunes a viernes: de 7.30 a 18.00 hs </b></p>"
					    + "<p>Para mayor información no dude en contactarnos</p><br>"                            
					    + "<address>"
					    + "<strong></strong><br> Calle 1 , esquina 5 <br>"
					    + "Ciudad nueva<br>"
					    + "<abbr title=\"Phone\">Telefono: </abbr> (071) 88 88 88" 
					    + "<abbr title=\"Email\">, Email: </abbr> bibliotecadistri@gmail.com" 
					    + "</address><br>"
					    + "<span class=\"label label-warning\"><span class=\"glyphicon glyphicon-info-sign\" aria-hidden=\"true\"></span>"
					    + "<br><br></div></div><br/></div></body></html>";
			
				/*****################################################################*****/
				/*Elementos de arriba encapsulados para poder probar con datos rapidos*/
				/****#################################################################****/
				System.out.println("Enviando una oferta al: "+ invitacion.getEmail());
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("yoochunmicky6002@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(invitacion.getEmail()));
				message.setSubject("Notificacion de Oferta");
				message.setContent(text, "text/html; charset=utf-8");
				Transport.send(message);
				
				return true;

			} catch (MessagingException e) {
				throw new BibliotecaException("Envio de oferta fallido.", e);

			} 
		}else {
			return true;
		}	
	}

	@Transactional
	public void enviarInvitaciones() throws BibliotecaException{
		InvitacionDomain of= new InvitacionDomain();
		of.setCliente(clienteDao.getById(1));
		ClienteDomain c= clienteDao.getById(1);
		System.out.println("el cliente es " + c.getCorreo());
		of.setEmail("lilianalopez0710@gmail.com");
		of.setFechaCreacion(new Date());
		final InvitacionDomain ofertaaa = invitacionDao.save(of);
		List<InvitacionDomain> ofertas = invitacionDao.findAll();
		for (InvitacionDomain ofer : ofertas){
			if (enviar(ofer)){
				ofer.setFechaEnvio(new Date());
				invitacionDao.save(ofer);
			}
		}

	}
	
}