import java.text.ParseException;
import java.text.SimpleDateFormat;

import reserva.ReservaManager;
import usuario.UsuarioManager;
import entrada.EntradaManager;


public class WsBiblioteca {
	
		public static void main(String[] args) {
			usuarios();
			entradas();
			reservas();
			salidas();
		}
	
		public static void usuarios(){
			
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
		public static void entradas(){
			EntradaManager s = new EntradaManager();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			
			try {
				
				s.addEntrada("Cualquier descripcion", formatter.parse("11-06-2017") , 1);
				s.addEntrada("Cualquier descripcion 2", formatter.parse("11-06-2011"), 2);
			
			} catch (ParseException e) {
				
				e.printStackTrace();
			}

			System.out.println( "\nBUSCAR POR ID" );
			s.getByIdEntrada(1);

			System.out.println("\nTODOS LOS DATOS");
			s.getAllEntradas();

			/*System.out.println( "\nBUSCAR POR PROPIEDAD" );
			s.getByPropertyEntrada("2");*/
			
		}
		
		public static void reservas(){
			ReservaManager s = new ReservaManager();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			
			try {
				
				
				s.addReserva(formatter.parse("21-03-2013"), formatter.parse("13-04-2013"), 1);
				s.addReserva( formatter.parse("11-06-2017"), formatter.parse("20-06-2017") , 2);
			
			} catch (ParseException e) {
				
				e.printStackTrace();
			}

			System.out.println( "\nBUSCAR POR ID" );
			s.getByIdReserva(1);

			System.out.println("\nTODOS LOS DATOS");
			s.getAllReservas();

			/*System.out.println( "\nBUSCAR POR PROPIEDAD" );
			s.getByPropertyReserva("2");*/
		}

		public static void salidas(){
			SalidaManager s = new EntradaManager();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			
			try {
				
				s.addEntrada("Descripcion uno", formatter.parse("20-06-2017") , 1);
				s.addEntrada("Cualquier descripcion 2", formatter.parse("11-08-2017"), 2);
			
			} catch (ParseException e) {
				
				e.printStackTrace();
			}

			System.out.println( "\nBUSCAR POR ID" );
			s.getByIdSalida(1);

			System.out.println("\nTODOS LOS DATOS");
			s.getAllSalidas();

		}


}

