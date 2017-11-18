<g:each in="${categoriaInstanceList}" status="i" var="categoriaInstance" >

											<tr >
												<td>
													<g:fieldValue class="form-control" bean="${categoriaInstance}" field="descripcion"/>
												</td>
						
												
												<%--  <td>${fieldValue(bean: categoriaInstance, field: "categoria.id")}</td>		--%>
												<td class="center">
<%--													<g:link action="show" class="btn btn-primary" id="${categoriaInstance.getId()}">${}<i class="fa fa-eye"></i> Ver Detalle</g:link>--%>
													<g:link action="edit" class="btn btn-success" id="${categoriaInstance.getId()}">${}<i class="fa fa-pencil"></i> Editar</g:link>
												<%--	<g:link action="delete" class="btn btn-danger" id="${categoriaInstance.getId()}">${}<i class="fa fa-pencil"></i> Eliminar</g:link>--%>

												</td>
											</tr>
		
										</g:each>
										
