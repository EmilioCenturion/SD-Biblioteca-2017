import usuario.UsuarioManager;


public class WsUsuario {
	
		public static void main(String[] args) {
		
			
			UsuarioManager s = new UsuarioManager();
			s.addUsuario("Liliana", "cualquier cosa", 1);
			s.addUsuario("Elizabeth", "lalala", 1);

			System.out.println( "\nBUSCAR POR ID" );
			s.getByIdUsuario(1);

			System.out.println("\nTODOS LOS DATOS");
			s.getAllUsuarios();

			System.out.println( "\nBUSCAR POR PROPIEDAD" );
			s.getByPropertyUsuario("Liliana");
		}
	

}
