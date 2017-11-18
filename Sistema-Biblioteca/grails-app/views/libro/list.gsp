
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="template">
<g:set var="entityName"
	value="${message(code: 'libro.label', default: 'Libro')}" />
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
			<div class="col-md-12">
			<div class="col-sm-4">
			<h4><i class="fa fa-angle-right"></i> Lista de Libros</h4>
	       <hr>
	       </div>
	       	<div class="col-sm-8">
                        <a class="btn btn-theme03" href="/Sistema-Biblioteca/libro/create"
                        role="button"><i class="fa fa-plus"></i> Nuevo libro</a>
                        </div>
	       </div>
			<g:if test="${flash.message}">
				<div class="message" role="status">
					${flash.message}
				</div>
				</g:if>
				<!--EL BUSCAR -->
	   				<div class="col-md-12">
	   					<div id="searchbox"> 
							<label>Buscar :
		   						<g:remoteField  update="updateMe" id="searching" class="form-control"  name= "searching" paramName ="text" url="[action:'showResult', controller:'libro']"/>
							</label>
						</div>
					</div>	
				<!--END BUSCAR -->
				<table   id="list-report" class="table table-striped table-advance table-hover" cellspacing="0" width="100%">
					<thead >
					<tr>
						<g:sortableColumn property="nombre" title="Nombre" />
						<g:sortableColumn property="anho" title="Año" />
						<g:sortableColumn property="autor" title="Autor" />
						<g:sortableColumn property="categoria" title="Categoria" />
						<g:sortableColumn property="cantidad" title="Cantidad" />
						<td>Acciones</td>
					</tr>
					</thead>
					<tbody id="updateMe">
						<g:render template="/libro/showResult"  id="updateMe"></g:render>
					</tbody>
				</table>
				<div class="pagination"></div>
			</div>
		</div>
	</div>
</div>
</body>
</html>