package com.sd.uni.biblioteca.categoria

import com.sd.uni.biblioteca.beans.categoria.CategoriaB
import com.sd.uni.biblioteca.service.categoria.ICategoriaService
import com.sd.uni.biblioteca.service.categoria.CategoriaServiceImpl
import com.sd.uni.biblioteca.service.usuario.IUsuarioService;

class CategoriaController {
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	//service
	def ICategoriaService categoriaService =new CategoriaServiceImpl()

    def index() {
		redirect(action: "list", params: params)
	}
	
	def list(Integer max) {
		def text = params.text
		categoriaService= new CategoriaServiceImpl()
		def categorias = categoriaService.getAll()
		
		if(null != text && !"".equals(text)){
			
			categorias = categoriaService.find(text)
			
			
			
		}else{
			categorias = categoriaService.getAll()
		}
		
		
		[categoriaInstanceList: categorias, categoriaInstanceTotal:categorias.size()]
	}
	
	def create() {
		[categoriaInstance: new CategoriaB(params)]
	}
	
	
	def save() {
		def newCategoria = new CategoriaB(params)
		
		def categoriaInstance = categoriaService.save(newCategoria)
		
		if (!categoriaInstance.getId()) {
			render(view: "create", model: [categoriaInstance: categoriaInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'categoria.label', default: 'Categoria'),
			categoriaInstance.getId()
		])
		redirect(action: "list")
	}
	
	def showResult(Integer max) {
		def text = params.text
		categoriaService=new CategoriaServiceImpl()
		def categorias = categoriaService.getAll()
		if(null != text && !"".equals(text)){
			categorias = categoriaService.find(text)
			
		}else{
			categorias = categoriaService.getAll()
		}
		
		render (template:"showResult", model:[categoriaInstanceList: categorias, categoriaInstanceTotal:categorias.size()])
	}
	
	def show(Long id) {
		def categoriaInstance = categoriaService.getById(id.intValue())
		if (!categoriaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'categoria.label', default: 'Categoria'),
				id
			])
			redirect(action: "list")
			return
		}

		[categoriaInstance: categoriaInstance]
	}
	
	def edit(Long id) {
		def categoriaInstance = categoriaService.getById(id.intValue())
		if (!categoriaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'categoria.label', default: 'Categoria'),
				id
			])
			redirect(action: "list")
			return
		}

		[categoriaInstance: categoriaInstance]
	}
	
	def update(Long id) {
		def categoriaInstance = categoriaService.getById(id.intValue())
		categoriaInstance.setDescripcion(params.get("descripcion"))
		
		categoriaService.save(categoriaInstance)
		
		
		redirect(action: "list")
	}

	
}
	
	
		
