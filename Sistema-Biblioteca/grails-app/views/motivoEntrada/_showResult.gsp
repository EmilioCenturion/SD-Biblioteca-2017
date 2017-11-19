<g:each in="${motivoEntradaInstanceList}" status="i" var="motivoEntradaInstance" >

											<tr >
												<td>
													<g:fieldValue class="form-control" bean="${motivoEntradaInstance}" field="descripcion"/>
												</td>
						
												
												<%--  <td>${fieldValue(bean: motivoEntradaInstance, field: "motivoEntrada.id")}</td>		--%>
												<td class="center">
<%--													<g:link action="show" class="btn btn-primary" id="${motivoEntradaInstance.getId()}">${}<i class="fa fa-eye"></i> Ver Detalle</g:link>--%>
													<g:link action="edit" class="btn btn-success" id="${motivoEntradaInstance.getId()}">${}<i class="fa fa-pencil"></i> Editar</g:link>

												</td>
											</tr>
		
										</g:each>
										
