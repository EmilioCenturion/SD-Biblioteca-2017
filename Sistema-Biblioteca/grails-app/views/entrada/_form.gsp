<div class="col-md-12">
<div class="row">

	<div class="col-md-6">
		<div class="form-group">
			<div class="fieldcontain ${hasErrors(bean: entradaInstance, field: 'motivoEntrada', 'error')} required">
				<label class="col-sm-4 col-sm-4 contmotivoEntrada-label">Motivo Entrada*</label>
				<div class="col-sm-8">
					<g:select class="form-control" id="motivoEntrada" name="motivoEntradaId" from="${motivoEntradas}" optionKey="id" optionValue="descripcion" required="" value="${entradaInstance?.motivoEntrada?.id}"/>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-6" style="display:none;">
		<div class="form-group">
			<label class="col-sm-2 col-sm-2 contmotivoEntrada-label">Fecha*</label>
			<div class="col-sm-10">	
				<g:formatDate date="${new Date()}" class="form-control" name="date" type="date" value="${entradaInstance?.fecha}" /></div>
		</div>
	</div>
	<div class="col-md-6">
		<div class="form-group">
			<label class="col-sm-2 col-sm-2 contmotivoEntrada-label">Descripcion*</label>
			<div class="col-sm-10">	
				<g:textField class="form-control" required="" name="descripcion" value="${entradaInstance?.descripcion}"/>
			</div>
		</div>
	</div>

</div>

</div>