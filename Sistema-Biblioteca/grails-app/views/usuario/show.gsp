<%@ page import="com.sd.uni.biblioteca.usuario.UsuarioController" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
	
		<div class="container-fluid">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
        	<div class="row">
            	<div class="panel panel-default">		
                	<div class="panel-heading">
						<h4><strong>Información del Usuario</strong></h4>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<g:if test="${usuarioInstance?.nombre}">
								<label>Nombre<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${usuarioInstance}"  field="nombre"/>
							
								</g:if>
							</div>
							<div class="col-md-6">
								
								<label>Contraseña<span class="required-indicator"> **********</span></label>
								
								
							</div>
							<div class="col-md-6">
								<g:if test="${usuarioInstance?.rol}">
								<label>Rol<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${usuarioInstance}" field="rol.nombre"/>
								</g:if>
							</div>
							
						
						</div>
						<g:form>
							</br>
							<fieldset class="buttons">
							<g:link class="btn btn-success" action="edit" id="${userInstance?.id}"><i class="fa fa-pencil"></i> Editar</g:link>
							</fieldset>
						</g:form>
					</div>
				</div>
			</div>
		</div>
		<!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
</body>
</html>

