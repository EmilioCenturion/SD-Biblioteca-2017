<g:each in="${libroInstanceList}" status="i" var="libroInstance" >

	<tr >
		<td>
			<g:fieldValue class="form-control" bean="${libroInstance}" field="nombre"/>
		</td>
		<td>
			<g:fieldValue class="form-control" bean="${libroInstance}" field="anho"/>
		</td>
		
		<td>
			<g:fieldValue class="form-control" bean="${libroInstance}" field="autor.nombre"/>
		</td>
		<td>
			<g:fieldValue class="form-control" bean="${libroInstance}" field="categoria.descripcion"/>
		</td>
		<td>
			<g:fieldValue class="form-control" bean="${libroInstance}" field="cantidad"/>
		</td>

		<td class="center">
			<g:link action="edit" class="btn btn-success" id="${libroInstance.getId()}"><i class="fa fa-pencil"></i> Editar</g:link>

		</td>
	</tr>
		
</g:each>
										
