package sistema

class LoginController {

    def index() { }
	
	def login(){
		if ((params.nombre == "admin" && params.password == "admin") || (params.nombre == "emilio" && params.password == "12345")){
			flash.message = "Bienvenido"
			redirect(uri:'/')		
			session.login = "admin"
		}else{
			flash.message = "Login Fallido"
			redirect(action: 'index')
		}
		
	}
	def logout = {
		session.login = null
		redirect(action: 'index')
	}
}
