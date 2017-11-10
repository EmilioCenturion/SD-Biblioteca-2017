
<div class="row">

	<div class="col-md-6">
		<label>Nombre<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="nombre" value="${usuarioInstance?.nombre }"/>
	
	<div class="col-md-6">
		<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'rol', 'error')} required">
	
		<label>Rol<span class="required-indicator">*</span></label>
		
		<g:select class="form-control" id="rol" name="rolId" from="${rols}" optionKey="id" optionValue="nombre" required="" value="${usuarioInstance?.rol?.id}"/>
		</div>
	</div>
	<div class="col-md-6">
		<label>Constraseña<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="contrasenha" value="${usuarioInstance?.contrasenha}"/>
	</div>
	
	
	
	
	
	
	
	
</div>

