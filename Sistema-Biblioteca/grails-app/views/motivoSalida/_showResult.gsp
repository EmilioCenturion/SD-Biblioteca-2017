<g:each in="${motivoSalidaInstanceList}" status="i" var="motivoSalidaInstance" >

											<tr >
												<td>
													<g:fieldValue class="form-control" bean="${motivoSalidaInstance}" field="descripcion"/>
												</td>
						
												
												<%--  <td>${fieldValue(bean: motivoSalidaInstance, field: "motivoSalida.id")}</td>		--%>
												<td class="center">
<%--													<g:link action="show" class="btn btn-primary" id="${motivoSalidaInstance.getId()}">${}<i class="fa fa-eye"></i> Ver Detalle</g:link>--%>
													<g:link action="edit" class="btn btn-success" id="${motivoSalidaInstance.getId()}"><i class="fa fa-pencil"></i> Editar</g:link>

												</td>
											</tr>
		
										</g:each>
										
