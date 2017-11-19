package com.sd.uni.biblioteca.entrada


import java.text.SimpleDateFormat

import org.springframework.dao.DataIntegrityViolationException

import com.sd.uni.biblioteca.beans.entrada.EntradaB
import com.sd.uni.biblioteca.beans.entradaDetalle.EntradaDetalleB
import com.sd.uni.biblioteca.service.entradaDetalle.*
import com.sd.uni.biblioteca.service.entrada.*
import com.sd.uni.biblioteca.service.libro.ILibroService
import com.sd.uni.biblioteca.service.libro.LibroServiceImpl
import com.sd.uni.biblioteca.service.motivoEntrada.IMotivoEntradaService
import com.sd.uni.biblioteca.service.motivoEntrada.MotivoEntradaServiceImpl

class EntradaController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	//service
	def IEntradaService entradaService =new EntradaServiceImpl()
	def ILibroService libroService =new LibroServiceImpl()
	def IMotivoEntradaService motivoEntradaService=new MotivoEntradaServiceImpl()
	def IEntradaDetalleService entradaDetalleService=new EntradaDetalleServiceImpl()
	
	def index() {
		entradaService=new EntradaServiceImpl()
		def entradas = entradaService.getAll()
		
		
		[entradaInstanceList: entradas, entradaInstanceTotal:entradas.size()]
	}
	
	def create() {
		[entradaInstance: new EntradaB(params), motivoEntradas: motivoEntradaService.getAll()]
	}

	def save() {
		def newEntrada = new EntradaB(params)
		newEntrada.setMotivoEntrada(motivoEntradaService.getById(Integer.valueOf(params.motivoEntradaId)))
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		newEntrada.setFecha(formatter.parse(formatter.format(new Date())));
		def entradaInstance = entradaService.save(newEntrada)
		
		
		
		def maxi = Integer.parseInt(params.get("counter"))
		for (int i = 0; i < maxi; i++) {
			def libro= libroService.getById(Integer.parseInt(params.get("libro["+i.toString()+"]")))
			def cantidad = Integer.parseInt(params.get("cantidad["+i.toString()+"]"))
			def entradaDetalleInstance = new EntradaDetalleB(params)
			def antCantidad= entradaDetalleInstance.getCantidad()
			entradaDetalleInstance.setCantidad( cantidad)
			entradaDetalleInstance.setEntrada( entradaInstance)
			entradaDetalleInstance.setLibro(libro)
			def entradaDetalles = entradaDetalleService.save(entradaDetalleInstance)
			}
		
		if (!entradaInstance.getId()) {
			render(view: "create", model: [entradaInstance: entradaInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'entrada.label', default: 'Entrada'),
			entradaInstance.getId()
		])
		redirect(action: "show", id: entradaInstance.getId())
	}
	
	def show(Long id) {
		def entradaInstance = entradaService.getById(id.intValue())
		if (!entradaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'entrada.label', default: 'Entrada'),
				id
			])
			redirect(action: "list")
			return
		}

		[entradaInstance: entradaInstance, entradaDetalles: entradaDetalleService.getAll()]
	}
	
	def newRow(){
		def idN =  params.get("id")
		def cant = "cantidad["+ idN + "]"
		def libro = "libro["+ idN + "]"
		render(template: 'tableRow', model: [ idNew: idN, , cantidad: cant,  libro: libro, libros: libroService.getAll() ])
		
	}
	
	def edit(Long id) {
		def entradaInstance = entradaService.getById(id.intValue())
		if (!entradaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'entrada.label', default: 'Entrada'),
				id
			])
			redirect(action: "index")
			return
		}

		[entradaInstance: entradaInstance, motivoEntradas:motivoEntradaService.getAll()]
	}

	

	def update(Long id) {
		def entradaInstance = entradaService.getById(id.intValue())
		entradaInstance.setDescripcion(params.get("descripcion"))
		def motivoEntradaId=params.get("motivoEntradaId").toString().toInteger()
		entradaInstance.setMotivoEntrada(motivoEntradaService.getById(motivoEntradaId))
		entradaService.save(entradaInstance)
		
		
		redirect(action: "index")
	}

	



	
}
