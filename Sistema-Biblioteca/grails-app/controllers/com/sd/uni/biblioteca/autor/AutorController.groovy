package com.sd.uni.biblioteca.autor

import com.sd.uni.biblioteca.beans.autor.AutorB
import com.sd.uni.biblioteca.service.autor.IAutorService
import com.sd.uni.biblioteca.service.autor.AutorServiceImpl
import com.sd.uni.biblioteca.service.usuario.IUsuarioService;
import grails.plugin.springsecurity.annotation.Secured

class AutorController {
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	//service
	def IAutorService autorService =new AutorServiceImpl()

	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
    def index() {
		redirect(action: "list", params: params)
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def list(Integer max) {
		def text = params.text
		autorService= new AutorServiceImpl()
		def autores = autorService.find(0,100)
		
		if(null != text && !"".equals(text)){
			
			autores = autorService.find(text)
			
			
			
		}else{
			autores = autorService.find(0,100)
		}
		
		
		[autorInstanceList: autores, autorInstanceTotal:autores.size()]
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def create() {
		[autorInstance: new AutorB(params)]
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def save() {
		def newAutor = new AutorB(params)
		
		def autorInstance = autorService.save(newAutor)
		
		if (!autorInstance.getId()) {
			render(view: "create", model: [autorInstance: autorInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'autor.label', default: 'Autor'),
			autorInstance.getId()
		])
		redirect(action: "list")
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def showResult(Integer max) {
		def text = params.text
		autorService=new AutorServiceImpl()
		def autores = autorService.find(0,100)
		if(null != text && !"".equals(text)){
			autores = autorService.find(text)
			
		}else{
			autores = autorService.find(0,100)
		}
		
		render (template:"showResult", model:[autorInstanceList: autores, autorInstanceTotal:autores.size()])
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def show(Long id) {
		def autorInstance = autorService.getById(id.intValue())
		if (!autorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'autor.label', default: 'Autor'),
				id
			])
			redirect(action: "list")
			return
		}

		[autorInstance: autorInstance]
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def edit(Long id) {
		def autorInstance = autorService.getById(id.intValue())
		if (!autorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'autor.label', default: 'Autor'),
				id
			])
			redirect(action: "list")
			return
		}

		[autorInstance: autorInstance]
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def update(Long id) {
		def autorInstance = autorService.getById(id.intValue())
		autorInstance.setNombre(params.get("nombre"))
		
		autorService.save(autorInstance)
		
		
		redirect(action: "list")
	}
	
	
}
