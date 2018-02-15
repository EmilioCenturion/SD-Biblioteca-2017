package com.sd.uni.biblioteca.motivoSalida

import com.sd.uni.biblioteca.beans.motivoSalida.MotivoSalidaB
import com.sd.uni.biblioteca.service.motivoSalida.IMotivoSalidaService
import com.sd.uni.biblioteca.service.motivoSalida.MotivoSalidaServiceImpl
import com.sd.uni.biblioteca.service.usuario.IUsuarioService;
import grails.plugin.springsecurity.annotation.Secured

class MotivoSalidaController {
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	//service
	def IMotivoSalidaService motivoSalidaService =new MotivoSalidaServiceImpl()

	@Secured(['ROLE_SUPERUSER2', 'ROLE_ADMIN2'])
    def index() {
		redirect(action: "list", params: params)
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def list(Integer max) {
		def text = params.text
		motivoSalidaService= new MotivoSalidaServiceImpl()
		def motivoSalidas = motivoSalidaService.getAll()
		
		if(null != text && !"".equals(text)){
			
			motivoSalidas = motivoSalidaService.find(text)
			
			
			
		}else{
			motivoSalidas = motivoSalidaService.getAll()
		}
		
		
		[motivoSalidaInstanceList: motivoSalidas, motivoSalidaInstanceTotal:motivoSalidas.size()]
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def create() {
		[motivoSalidaInstance: new MotivoSalidaB(params)]
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def save() {
		def newMotivoSalida = new MotivoSalidaB(params)
		
		def motivoSalidaInstance = motivoSalidaService.save(newMotivoSalida)
		
		if (!motivoSalidaInstance.getId()) {
			render(view: "create", model: [motivoSalidaInstance: motivoSalidaInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'motivoSalida.label', default: 'MotivoSalida'),
			motivoSalidaInstance.getId()
		])
		redirect(action: "list")
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def showResult(Integer max) {
		def text = params.text
		motivoSalidaService=new MotivoSalidaServiceImpl()
		def motivoSalidas = motivoSalidaService.getAll()
		if(null != text && !"".equals(text)){
			motivoSalidas = motivoSalidaService.find(text)
			
		}else{
			motivoSalidas = motivoSalidaService.getAll()
		}
		
		render (template:"showResult", model:[motivoSalidaInstanceList: motivoSalidas, motivoSalidaInstanceTotal:motivoSalidas.size()])
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def show(Long id) {
		def motivoSalidaInstance = motivoSalidaService.getById(id.intValue())
		if (!motivoSalidaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'motivoSalida.label', default: 'MotivoSalida'),
				id
			])
			redirect(action: "list")
			return
		}

		[motivoSalidaInstance: motivoSalidaInstance]
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def edit(Long id) {
		def motivoSalidaInstance = motivoSalidaService.getById(id.intValue())
		if (!motivoSalidaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'motivoSalida.label', default: 'MotivoSalida'),
				id
			])
			redirect(action: "list")
			return
		}

		[motivoSalidaInstance: motivoSalidaInstance]
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def update(Long id) {
		def motivoSalidaInstance = motivoSalidaService.getById(id.intValue())
		motivoSalidaInstance.setDescripcion(params.get("descripcion"))
		
		motivoSalidaService.save(motivoSalidaInstance)
		
		
		redirect(action: "list")
	}
	
	
}
