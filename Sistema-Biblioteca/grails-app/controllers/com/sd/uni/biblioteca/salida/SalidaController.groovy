package com.sd.uni.biblioteca.salida



import java.text.SimpleDateFormat

import org.springframework.dao.DataIntegrityViolationException

import com.sd.uni.biblioteca.beans.salida.SalidaB
import com.sd.uni.biblioteca.beans.salidaDetalle.SalidaDetalleB
import com.sd.uni.biblioteca.service.salidaDetalle.*
import com.sd.uni.biblioteca.service.salida.*
import com.sd.uni.biblioteca.service.libro.ILibroService
import com.sd.uni.biblioteca.service.libro.LibroServiceImpl
import com.sd.uni.biblioteca.service.motivoSalida.IMotivoSalidaService
import com.sd.uni.biblioteca.service.motivoSalida.MotivoSalidaServiceImpl
import grails.plugin.springsecurity.annotation.Secured

class SalidaController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	//service
	def ISalidaService salidaService =new SalidaServiceImpl()
	def ILibroService libroService =new LibroServiceImpl()
	def IMotivoSalidaService motivoSalidaService=new MotivoSalidaServiceImpl()
	def ISalidaDetalleService salidaDetalleService=new SalidaDetalleServiceImpl()
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def index() {
		salidaService=new SalidaServiceImpl()
		def salidas = salidaService.getAll()
		[salidaInstanceList: salidas, salidaInstanceTotal:salidas.size()]
		
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def create() {
		[salidaInstance: new SalidaB(params), motivoSalidas: motivoSalidaService.getAll()]
	}

	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def save() {
		def newSalida = new SalidaB(params)
		newSalida.setMotivoSalida(motivoSalidaService.getById(Integer.valueOf(params.motivoSalidaId)))
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		newSalida.setFecha(formatter.parse(formatter.format(new Date())));
		def salidaInstance = salidaService.save(newSalida)
		
		
		
		def maxi = Integer.parseInt(params.get("counter"))
		for (int i = 0; i < maxi; i++) {
			def libro= libroService.getById(Integer.parseInt(params.get("libro["+i.toString()+"]")))
			def cantidad = Integer.parseInt(params.get("cantidad["+i.toString()+"]"))
			def salidaDetalleInstance = new SalidaDetalleB(params)
			def antCantidad= salidaDetalleInstance.getCantidad()
			salidaDetalleInstance.setCantidad( cantidad)
			salidaDetalleInstance.setSalida( salidaInstance)
			salidaDetalleInstance.setLibro(libro)
			def salidaDetalles = salidaDetalleService.save(salidaDetalleInstance)
			}
		
		if (!salidaInstance.getId()) {
			render(view: "create", model: [salidaInstance: salidaInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'salida.label', default: 'Salida'),
			salidaInstance.getId()
		])
		redirect(action: "show", id: salidaInstance.getId())
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def show(Long id) {
		def salidaInstance = salidaService.getById(id.intValue())
		if (!salidaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'salida.label', default: 'Salida'),
				id
			])
			redirect(action: "list")
			return
		}

		[salidaInstance: salidaInstance, salidaDetalles: salidaDetalleService.getAll()]
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def newRow(){
		def idN =  params.get("id")
		def cant = "cantidad["+ idN + "]"
		def libro = "libro["+ idN + "]"
		render(template: 'tableRow', model: [ idNew: idN, , cantidad: cant,  libro: libro, libros: libroService.getAll() ])
		
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def edit(Long id) {
		def salidaInstance = salidaService.getById(id.intValue())
		if (!salidaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'salida.label', default: 'Salida'),
				id
			])
			redirect(action: "index")
			return
		}

		[salidaInstance: salidaInstance, motivoSalidas:motivoSalidaService.getAll()]
	}

	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def update(Long id) {
		def salidaInstance = salidaService.getById(id.intValue())
		salidaInstance.setDescripcion(params.get("descripcion"))
		def motivoSalidaId=params.get("motivoSalidaId").toString().toInteger()
		salidaInstance.setMotivoSalida(motivoSalidaService.getById(motivoSalidaId))
		salidaService.save(salidaInstance)
		
		
		redirect(action: "index")
	}

	



	
}
