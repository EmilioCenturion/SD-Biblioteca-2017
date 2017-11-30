<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>Sistema Biblioteca - Login </title>

    <!-- Bootstrap core CSS -->
    <link href="${request.contextPath}/theme/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="${request.contextPath}/theme/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="${request.contextPath}/theme/assets/css/style.css" rel="stylesheet">
    <link href="${request.contextPath}/theme/assets/css/style-responsive.css" rel="stylesheet">

  </head>

  <body>

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	  <div id="login-page">
	  	<div class="container">
	  	
		      <form class="form-login" action='${postUrl}' method='POST' id='loginForm' autocomplete='off'>
		        <h2 class="form-login-heading">Iniciar Sesión</h2>
		        <g:if test='${flash.message}'>
					<div class='login_message'>${flash.message = "Usuario y/o Contraseña incorrectos."}</div>
				</g:if>			
		        
		        <div class="login-wrap">
		            <input type="text" class="form-control" name='j_username' id='username' placeholder="Usuario" autofocus>
		            <br>
		            <input type="password" class="form-control" placeholder="Contraseña" name='j_password' id='password'>
		            <label class="checkbox">
		                <span class="pull-right">
		                    <a data-toggle="modal" href="login.html#myModal"> ¿Olvidaste tu contraseña?</a>
		
		                </span>
		            </label>
		            <p id="remember_me_holder">
						<input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
						<label for='remember_me'><g:message code="Recuérdame"/></label>
					</p>
		            <button class="btn btn-theme btn-block" href="index.html" type="submit"><i class="fa fa-lock"></i>ACEPTAR</button>
		            <hr>
		            
		            <div class="login-social-link centered">
		            <p>o inicia sesión con tus redes sociales</p>
		                <button class="btn btn-facebook" type="submit"><i class="fa fa-facebook"></i> Facebook</button>
		                <button class="btn btn-twitter" type="submit"><i class="fa fa-twitter"></i> Twitter</button>
		            </div>
		            <div class="registration">
		                ¿No tienes una cuenta todavía?<br/>
		                <a class="" href="#">
		                    Crear una cuenta
		                </a>
		            </div>
		
		        </div>
		
		          <!-- Modal -->
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title">¿Olvidaste tu contraseña ?</h4>
		                      </div>
		                      <div class="modal-body">
		                          <p>Ingresa tu dirección de e-mail para recuperar tu contraseña.</p>
		                          <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
		
		                      </div>
		                      <div class="modal-footer">
		                          <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
		                          <button class="btn btn-theme" type="button">Aceptar</button>
		                      </div>
		                  </div>
		              </div>
		          </div>
		          <!-- modal -->
		
		      </form>	  	
	  	
	  	</div>
	  </div>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="${request.contextPath}/theme/assets/js/jquery.js"></script>
    <script src="${request.contextPath}/theme/assets/js/bootstrap.min.js"></script>

    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="assets/js/jquery.backstretch.min.js"></script>
    <script>
        $.backstretch("${request.contextPath}/theme/assets/img/login-bg.jpg", {speed: 500});
    </script>


  </body>
</html>





