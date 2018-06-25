<g:each in="${entradaInstanceList}" status="i" var="entradaInstance" >
	<tr >
		<td>
			<g:fieldValue class="form-control" bean="${entradaInstance}" field="motivoEntrada.descripcion"/>
		</td>
		<td>
			<g:fieldValue class="form-control" bean="${entradaInstance}" field="fecha"/>
		</td>
		<td>
			<g:fieldValue class="form-control" bean="${entradaInstance}" field="descripcion"/>
		</td>
		<%--  <td>${fieldValue(bean: usuarioInstance, field: "usuario.id")}</td>		--%>
		<td class="center">
			<g:link action="show" class="btn btn-primary" id="${entradaInstance.getId()}"><i class="fa fa-eye"></i> Ver Detalle</g:link>
			<g:link action="edit" class="btn btn-success" id="${entradaInstance.getId()}"><i class="fa fa-pencil"></i> Editar</g:link>
		</td>
	</tr>
</g:each>