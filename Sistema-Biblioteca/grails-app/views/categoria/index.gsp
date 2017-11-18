
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="template">
<g:set var="entityName"
	value="${message(code: 'categoria.label', default: 'Categoria')}" />
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
						<strong><i class="fa fa-angle-right"></i> Lista de Categorias</strong>
					</h4>
				</div>
				<div class="panel-body" >
					<g:if test="${flash.message}">
						<div class="message" role="status">
							${flash.message}
						</div>
					</g:if>
					
					<!--EL BUSCAR -->
					 
					
   					
   					<div id="searchbox"> 
					<label>Buscar :
   					<g:remoteField  update="updateMe" id="searching" class="form-control"  name= "searching" paramName ="text" url="[action:'showResult', controller:'user']"/>
					</label>
					</div>
					<p></p>
					<p></p>
					
					<!--END BUSCAR -->
					
					
					<div class="" >
						<div class="row" >
							<div class="col-sm-12" >
								
								<table   id="list-report" class="table table-striped table-advance table-hover" cellspacing="0" width="100%">
									<thead >
										<tr>
											<g:sortableColumn property="descripcion" title="Descripcion" />
											
											
											<td>Acciones</td>
										</tr>
									</thead>
									<tbody id="updateMe">
										
										<g:render template="/categoria/showResult"  id="updateMe">
											</g:render>
									</tbody>
								</table>
								
								<div class=""></div>
							</div>
						</div>
					</div>
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