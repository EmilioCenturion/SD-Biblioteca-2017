<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="template"/>
	<title><g:message code="Acceso Denegado" /></title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">

			<%-- SIDEBAR  --%>
			<div class="col-sm-3 col-md-2 sidebar">

				<%-- LOGO  --%>
				<g:render template="/layouts/den"></g:render>

				
			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				
			

				
	      <div id="contenido">
	        <div class="jumbotron">
	          <h1>Lo sentimos</h1>
	          <p class="lead">No estás autorizado para ver esta página</p>
	          <p><a class="btn btn-lg btn-success" href="/Sistema-Biblioteca/j_spring_security_logout">Cerrar Sesión</a>
	        </div>
	      </div>
				

			</div>
		</div>
	</div>
</body>
</html>

