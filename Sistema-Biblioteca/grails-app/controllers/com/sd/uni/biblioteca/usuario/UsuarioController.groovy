package com.sd.uni.biblioteca.usuario


import org.springframework.dao.DataIntegrityViolationException

import com.sd.uni.biblioteca.beans.usuario.UsuarioB
import com.sd.uni.biblioteca.service.rol.*
import com.sd.uni.biblioteca.service.usuario.*

class UsuarioController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	//service
	def IUsuarioService usuarioService =new UsuarioServiceImpl()
	def IRolService rolService=new RolServiceImpl()

	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		def text = params.text
		usuarioService=new UsuarioServiceImpl()
		def usuarios = usuarioService.getAll()
		
		if(null != text && !"".equals(text)){
			
			usuarios = usuarioService.find(text)
			
			
			
		}else{
			usuarios = usuarioService.getAll()
		}
		
		
		[usuarioInstanceList: usuarios, usuarioInstanceTotal:usuarios.size()]
	}
	
	def list2(Integer max) {
		def text = params.text
		usuarioService=new UsuarioServiceImpl()
		def usuarios = usuarioService.getAll()
		
		if(null != text && !"".equals(text)){
			usuarios = usuarioService.find(text)
			
		}else{
			usuarios = usuarioService.getAll()
		}
		
		
		[usuarioInstanceList: usuarios, usuarioInstanceTotal:usuarios.size()]
	}
	
	
	def showResult(Integer max) {
		def text = params.text
		usuarioService=new UsuarioServiceImpl()
		def usuarios = usuarioService.getAll()
		if(null != text && !"".equals(text)){
			usuarios = usuarioService.find(text)
			
		}else{
			usuarios = usuarioService.getAll()
		}
		
		render (template:"showResult", model:[usuarioInstanceList: usuarios, usuarioInstanceTotal:usuarios.size()])
	}

	
	

	def create() {
		[usuarioInstance: new UsuarioB(params), rols:rolService.getAll()]
	}

	def save() {
		def newUsuario = new UsuarioB(params)
		newUsuario.setRol(rolService.getById(Integer.valueOf(params.rolId)))
		
		def usuarioInstance = usuarioService.save(newUsuario)
		
		if (!usuarioInstance.getId()) {
			render(view: "create", model: [usuarioInstance: usuarioInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'usuario.label', default: 'Usuario'),
			usuarioInstance.getId()
		])
		redirect(action: "show", id: usuarioInstance.getId())
	}
	
	
	
	
	

	def show(Long id) {
		def usuarioInstance = usuarioService.getById(id.intValue())
		if (!usuarioInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'usuario.label', default: 'Usuario'),
				id
			])
			redirect(action: "list")
			return
		}

		[usuarioInstance: usuarioInstance]
	}

	def edit(Long id) {
		def usuarioInstance = usuarioService.getById(id.intValue())
		if (!usuarioInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'usuario.label', default: 'Usuario'),
				id
			])
			redirect(action: "list")
			return
		}

		[usuarioInstance: usuarioInstance, rols:rolService.getAll()]
	}

	

	def update(Long id) {
		def usuarioInstance = usuarioService.getById(id.intValue())
		//usuarioInstance.properties= params
		usuarioInstance.setNombre(params.get("nombre"))
		usuarioInstance.setContrasenha(params.get("contrasenha"))
		def rolId=params.get("rolId").toString().toInteger()
		usuarioInstance.setRol(rolService.getById(rolId))
		usuarioService.save(usuarioInstance)
		
		
		redirect(action: "list")
	}

	
}
