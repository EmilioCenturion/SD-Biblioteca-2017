import java.text.ParseException;
import java.text.SimpleDateFormat;

import entrada.EntradaManager;


public class WsEntrada {
	
		public static void main(String[] args) {
		
			
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

			System.out.println( "\nBUSCAR POR PROPIEDAD" );
			s.getByPropertyEntrada("2");
		}
	

}

