
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="template">
<g:set var="entityName"
	value="${message(code: 'usuario.label', default: 'Usuario')}" />
<title><g:message code="default.create.label"
		args="[entityName]" /></title>
<asset:stylesheet src="application.css" />
<asset:javascript src="application.js" />
</head>
<body >
<h3></h3>
<div class="col-md-12">
<div class="row">
	<div class="col-md-12">
		<div class="content-panel" >
			<h4><i class="fa fa-angle-right"></i> Lista de Usuarios</h4>
	       <hr>
			<g:if test="${flash.message}">
				<div class="message" role="status">
					${flash.message}
				</div>
				</g:if>
				<!--EL BUSCAR -->
	   				<div class="col-md-12">
	   					<div id="searchbox"> 
							<label>Buscar :
		   						<g:remoteField  update="updateMe" id="searching" class="form-control"  name= "searching" paramName ="text" url="[action:'showResult', controller:'user']"/>
							</label>
						</div>
					</div>	
				<!--END BUSCAR -->
				<table   id="list-report" class="table table-striped table-advance table-hover" cellspacing="0" width="100%">
					<thead >
					<tr>
						<g:sortableColumn property="nombre" title="Nombre" />
						<g:sortableColumn property="password" title="Contraseña" />
						<g:sortableColumn property="rol" title="Rol" />
						<td>Acciones</td>
					</tr>
					</thead>
					<tbody id="updateMe">
						<g:render template="/usuario/showResult"  id="updateMe"></g:render>
					</tbody>
				</table>
				<div class="pagination"></div>
			</div>
		</div>
	</div>
</div>
</body>
</html>