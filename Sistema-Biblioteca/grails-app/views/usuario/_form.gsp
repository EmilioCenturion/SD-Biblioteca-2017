
<div class="row">

	<div class="col-md-6">
		<div class="form-group">
			<label class="col-sm-2 col-sm-2 control-label">Nombre*</label>
			<div class="col-sm-10">
				<g:textField class="form-control" required="" name="nombre" value="${usuarioInstance?.nombre }"/>
			</div>
		</div>
	</div>
	<div class="col-md-6">
		<div class="form-group">
			<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'rol', 'error')} required">
				<label class="col-sm-2 col-sm-2 control-label">Rol*</label>
				<div class="col-sm-10">
					<g:select class="form-control" id="rol" name="rolId" from="${rols}" optionKey="id" optionValue="nombre" required="" value="${usuarioInstance?.rol?.id}"/>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-6">
		<div class="form-group">
			<label class="col-sm-2 col-sm-2 control-label">Contraseña*</label>
			<div class="col-sm-10">	
				<g:textField class="form-control" required="" name="contrasenha" value="${usuarioInstance?.contrasenha}"/>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
</div>

