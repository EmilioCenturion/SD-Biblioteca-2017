package com.sd.uni.biblioteca.libro

import com.sd.uni.biblioteca.beans.libro.LibroB
import com.sd.uni.biblioteca.service.autor.AutorServiceImpl
import com.sd.uni.biblioteca.service.autor.IAutorService
import com.sd.uni.biblioteca.service.categoria.CategoriaServiceImpl
import com.sd.uni.biblioteca.service.categoria.ICategoriaService
import com.sd.uni.biblioteca.service.libro.ILibroService
import com.sd.uni.biblioteca.service.libro.LibroServiceImpl

import grails.plugin.springsecurity.annotation.Secured

class LibroController {
	
	static allowedMethods = [save: "POST", update: "POST"]
	
		//service
		def ILibroService libroService
		def IAutorService autorService
		def ICategoriaService categoriaService

	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
    def index() { 
		redirect(action: "list", params: params)
		
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def list(Integer max) {
		def text = params.text
		libroService=new LibroServiceImpl()
		def libros = libroService.find(0,100)
		
		if(null != text && !"".equals(text)){
			
			libros = libroService.find(text)

		}else{
			libros = libroService.find(0,100)
		}
		
		
		[libroInstanceList: libros, libroInstanceTotal:libros.size()]
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def showResult(Integer max) {
		def text = params.text
		libroService=new LibroServiceImpl()
		def libros = libroService.getAll()
		if(null != text && !"".equals(text)){
			libros = libroService.find(text)
			
		}else{
			libros = libroService.getAll()
		}
		
		render (template:"showResult", model:[libroInstanceList: libros, libroInstanceTotal:libros.size()])
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def create() {
		
		[libroInstance: new LibroB(params), autors:autorService.find(0,200), categorias:categoriaService.find(0,200)]
	}

	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def save() {
		def newLibro = new LibroB(params)
		newLibro.setAutor(autorService.getById(Integer.valueOf(params.autorId)))
		newLibro.setCategoria(categoriaService.getById(Integer.valueOf(params.categoriaId)))
		
		def libroInstance = libroService.save(newLibro)
		
		if (!libroInstance.getId()) {
			render(view: "create", model: [libroInstance: libroInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'libro.label', default: 'Libro'),
			libroInstance.getId()
		])
		redirect(action: "list")
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def show(Long id) {
		def libroInstance = libroService.getById(id.intValue())
		if (!libroInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'usuario.label', default: 'Libro'),
				id
			])
			redirect(action: "list")
			return
		}

		[libroInstance: libroInstance]
	}
	
	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def edit(Long id) {
		def libroInstance = libroService.getById(id.intValue())
		if (!libroInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'libro.label', default: 'Libro'),
				id
			])
			redirect(action: "list")
			return
		}

		[libroInstance: libroInstance, autors:autorService.getAll(), categorias:categoriaService.getAll()]
	}

	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def update(Long id) {
		def libroInstance = libroService.getById(id.intValue())
		libroInstance.setNombre(params.get("nombre"))
		libroInstance.setAnho(params.get("anho"))
		def autorId=params.get("autorId").toString().toInteger()
		libroInstance.setAutor(autorService.getById(autorId))
		def categoriaId=params.get("categoriaId").toString().toInteger()
		libroInstance.setCategoria(categoriaService.getById(categoriaId))
		libroService.save(libroInstance)
		
		
		redirect(action: "list")
	}
}
