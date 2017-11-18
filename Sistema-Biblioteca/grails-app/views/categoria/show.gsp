<%@ page import="com.sd.uni.biblioteca.categoria.CategoriaController" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'categoria.label', default: 'Categoria')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
	<div class="col-md-12">
		<h3></h3>
        <div class="row">
        	<div class="col-md-12">
            	<div class="showback">
                	<h4><i class="fa fa-angle-right"></i> Información de la categoria</h4>
                	<hr>
						<div class="row">
							<div class="col-md-6">
								<g:if test="${categoriaInstance?.descripcion}">
								<label><strong>Descripcion: </strong></label>
								<g:fieldValue class="form-control" bean="${categoriaInstance}"  field="descripcion"/>
								</g:if>
							</div>
							
						</div>
						
						<div class="row">
							<div class="col-md-6">
								<g:form>
									<br>
									<fieldset class="buttons">
									<g:link class="btn btn-success" action="edit" id="${categoriaInstance.getId()}"><i class="fa fa-pencil"></i> Editar</g:link>
									
									</fieldset>
								</g:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>

