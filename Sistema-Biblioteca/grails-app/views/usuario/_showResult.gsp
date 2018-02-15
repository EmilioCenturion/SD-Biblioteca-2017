
				<g:each in="${usuarioInstanceList}" status="i" var="usuarioInstance" >

											<tr >
												<td>
													<g:fieldValue class="form-control" bean="${usuarioInstance}" field="nombre"/>
												</td>
												<td>
													*****
												</td>
												<td>
													<g:fieldValue class="form-control" bean="${usuarioInstance}" field="rol.nombre"/>
												</td>
												
												
												<%--  <td>${fieldValue(bean: usuarioInstance, field: "usuario.id")}</td>		--%>
												<td class="center">
													<g:link action="show" class="btn btn-primary" id="${usuarioInstance.getId()}"><i class="fa fa-eye"></i> Ver Detalle</g:link>
													<g:link action="edit" class="btn btn-success" id="${usuarioInstance.getId()}"><i class="fa fa-pencil"></i> Editar</g:link>

												</td>
											</tr>
		
										</g:each>
										
