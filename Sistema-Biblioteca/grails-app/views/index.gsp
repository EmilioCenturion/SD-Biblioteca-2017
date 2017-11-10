
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
	<div class="container-fluid" >
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>
						<strong><i class="fa fa-angle-right"></i> Pagina Principal</strong>
					</h4>
				</div>
				<div class="panel-body" >
					Página en desarrollo. ¡Vaya a usuarios mientras!
				</div>
			</div>
		</div>
	</div>
	
<script>

function ajaxSearch(str) {
	
	 if(str.length>5){
		 alert("entro")
	 }
  
}
</script>


<script>
function letterDelimiter(str) {
	
	$(".container-fluid").css("color", "#000000");
  
}
</script>
	
	<!-- jQuery -->
	<script src=" ${request.contextPath}/template/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
</body>
</html>