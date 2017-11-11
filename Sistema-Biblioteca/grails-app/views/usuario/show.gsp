<%@ page import="com.sd.uni.biblioteca.usuario.UsuarioController" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
	<div class="col-md-12">
		<h3></h3>
        <div class="row">
        	<div class="col-md-12">
            	<div class="showback">
                	<h4><i class="fa fa-angle-right"></i> Información del Usuario</h4>
                	<hr>
						<div class="row">
							<div class="col-md-6">
								<g:if test="${usuarioInstance?.nombre}">
								<label><strong>Nombre: </strong></label>
								<g:fieldValue class="form-control" bean="${usuarioInstance}"  field="nombre"/>
								</g:if>
							</div>
							<div class="col-md-6">
								<label><strong>Contrasenha: </strong><span>****</span> </label>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<g:if test="${usuarioInstance?.rol}">
								<label><strong>Rol: </strong></label>
								<g:fieldValue class="form-control" bean="${usuarioInstance}" field="rol.nombre"/>
								</g:if>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<g:form>
									<br>
									<fieldset class="buttons">
									<g:link class="btn btn-success" action="edit" id="${usuarioInstance.getId()}"><i class="fa fa-pencil"></i> Editar</g:link>
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

