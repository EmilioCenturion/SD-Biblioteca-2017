<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'categoria.label', default: 'Categoria')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
	</head>
	<body>
        <div class="container-fluid">
        	<div class="row mt">
        		<div class="col-lg-12">
	            	<div class="form-panel">		
	                	<div class="panel-heading">
							<h4><strong>Registrar</strong></h4>
						</div>
						<div class="panel-body">
							<g:form action="save" >
								<fieldset class="form-horizontal style-form">
									<g:render template="form"/>
								</fieldset>
								<fieldset class="buttons">
									<br>
									<button type="submit" class="btn btn-primary" name="create" value="${message(code: 'default.button.create.label', default: 'Create')}">
	  									<i class="fa fa-floppy-o"></i> Crear  
									</button>
								</fieldset>
							</g:form>						
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/theme/js/bootstrap.min.js"></script>
	</body>
</html>

