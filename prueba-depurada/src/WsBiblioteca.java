import java.text.ParseException;
import java.text.SimpleDateFormat;

import libro.LibroManager;
import reserva.ReservaManager;
import salida.SalidaManager;
import usuario.UsuarioManager;
import autor.AutorManager;
import categoria.CategoriaManager;

import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import entrada.EntradaManager;

public class WsBiblioteca {
	
		public static void main(String[] args) {
			
			autores();
			categorias();
			usuarios();
			entradas();
			reservas();
			salidas();
			libros();
		
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
		public static void autores(){
			
			AutorManager s = new AutorManager();
			s.addAutor("Autor Juan Perez");
			s.addAutor("Autora Mariana Mertinez");

			System.out.println( "\nBUSCAR POR ID" );
			s.getByIdAutor(1);
			
			System.out.println( "\nBUSCAR POR PROPIEDAD" );
			s.getByPropertyAutor("Juan");
			
			System.out.println("\nTODOS LOS DATOS");
			s.getAllAutors();

			
		}
		
		public static void categorias(){
			
			CategoriaManager c = new CategoriaManager();
			c.addCategoria("Ciencia Ficcion");
			c.addCategoria("Ciencias Juridicas");
			c.addCategoria("Anatomia");
			
			System.out.println( "\nBUSCAR POR ID" );
			c.getByIdCategoria(1);

			System.out.println( "\nBUSCAR POR PROPIEDAD" );
			c.getByPropertyCategoria("Ciencias");
			
			System.out.println("\nTODOS LOS DATOS");
			//c.getAllCategorias();

			
		}

		public static void libros(){
			
			LibroManager s = new LibroManager();
			s.addLibro("Libro 1", "1980", 1, 2, 10);
			s.addLibro("Novela 9", "1993" , 2, 3, 5);
		
			System.out.println( "\nBUSCAR POR ID" );
			s.getByIdLibro(1);
		
			System.out.println("\nTODOS LOS DATOS");
			s.getLibros(2,0);
		
			System.out.println( "\nBUSCAR POR PROPIEDAD" );
			s.getByPropertyLibro("2");
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
			SalidaManager s = new SalidaManager();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			
			try {
				
				s.addSalida("Descripcion uno", formatter.parse("20-06-2017") , 1);
				s.addSalida("Cualquier descripcion 2", formatter.parse("11-08-2017"), 2);
			
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		
			System.out.println( "\nBUSCAR POR ID" );
			s.getByIdSalida(1);
		
			System.out.println("\nTODOS LOS DATOS");
			s.getAllSalidas();
		
		}


}

