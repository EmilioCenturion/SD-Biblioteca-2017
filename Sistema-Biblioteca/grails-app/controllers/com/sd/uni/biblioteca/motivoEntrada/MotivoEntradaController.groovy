package com.sd.uni.biblioteca.motivoEntrada

import com.sd.uni.biblioteca.beans.motivoEntrada.MotivoEntradaB
import com.sd.uni.biblioteca.service.motivoEntrada.IMotivoEntradaService
import com.sd.uni.biblioteca.service.motivoEntrada.MotivoEntradaServiceImpl
import com.sd.uni.biblioteca.service.usuario.IUsuarioService;
import grails.plugin.springsecurity.annotation.Secured

class MotivoEntradaController {
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	//service
	def IMotivoEntradaService motivoEntradaService =new MotivoEntradaServiceImpl()

	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def index() {
		redirect(action: "list", params: params)
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def list(Integer max) {
		def text = params.text
		motivoEntradaService= new MotivoEntradaServiceImpl()
		def motivoEntradas = motivoEntradaService.getAll()
		
		if(null != text && !"".equals(text)){
			
			motivoEntradas = motivoEntradaService.find(text)
			
			
			
		}else{
			motivoEntradas = motivoEntradaService.getAll()
		}
		
		
		[motivoEntradaInstanceList: motivoEntradas, motivoEntradaInstanceTotal:motivoEntradas.size()]
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def create() {
		[motivoEntradaInstance: new MotivoEntradaB(params)]
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def save() {
		def newMotivoEntrada = new MotivoEntradaB(params)
		
		def motivoEntradaInstance = motivoEntradaService.save(newMotivoEntrada)
		
		if (!motivoEntradaInstance.getId()) {
			render(view: "create", model: [motivoEntradaInstance: motivoEntradaInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'motivoEntrada.label', default: 'MotivoEntrada'),
			motivoEntradaInstance.getId()
		])
		redirect(action: "list")
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def showResult(Integer max) {
		def text = params.text
		motivoEntradaService=new MotivoEntradaServiceImpl()
		def motivoEntradas = motivoEntradaService.getAll()
		if(null != text && !"".equals(text)){
			motivoEntradas = motivoEntradaService.find(text)
			
		}else{
			motivoEntradas = motivoEntradaService.getAll()
		}
		
		render (template:"showResult", model:[motivoEntradaInstanceList: motivoEntradas, motivoEntradaInstanceTotal:motivoEntradas.size()])
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def show(Long id) {
		def motivoEntradaInstance = motivoEntradaService.getById(id.intValue())
		if (!motivoEntradaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'motivoEntrada.label', default: 'MotivoEntrada'),
				id
			])
			redirect(action: "list")
			return
		}

		[motivoEntradaInstance: motivoEntradaInstance]
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def edit(Long id) {
		def motivoEntradaInstance = motivoEntradaService.getById(id.intValue())
		if (!motivoEntradaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'motivoEntrada.label', default: 'MotivoEntrada'),
				id
			])
			redirect(action: "list")
			return
		}

		[motivoEntradaInstance: motivoEntradaInstance]
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def update(Long id) {
		def motivoEntradaInstance = motivoEntradaService.getById(id.intValue())
		motivoEntradaInstance.setDescripcion(params.get("descripcion"))
		
		motivoEntradaService.save(motivoEntradaInstance)
		
		
		redirect(action: "list")
	}
	
	
}
