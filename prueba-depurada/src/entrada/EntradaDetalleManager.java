package entrada;

import java.util.Date;

import base.AbstractBaseManager;

import com.sd.uni.biblioteca.dto.entradaDetalle.EntradaDetalleDTO;
import com.sd.uni.biblioteca.dto.entradaDetalle.EntradaDetalleResult;


public class EntradaDetalleManager extends AbstractBaseManager {
	public EntradaDetalleManager() {
		
		super();
		
	}
	
	
	
	public void addEntradaDetalle(Integer entradaId, Integer libroId, int cant) {
		
		EntradaDetalleDTO entradaDetalleDTO = new EntradaDetalleDTO();
		entradaDetalleDTO.setEntradaId(entradaId);
		entradaDetalleDTO.setLibroId(libroId);
		entradaDetalleDTO.setCantidad(cant);
		
		getJerseyClient().resource(getBaseUrl() + "/entradaDetalle").entity(entradaDetalleDTO).post(EntradaDetalleDTO.class);
	}
	
	
	public void getAllEntradaDetalles() {
		EntradaDetalleResult entradaDetalleResult = getJerseyClient().resource(getBaseUrl() + "/entradaDetalle").get(EntradaDetalleResult.class);
		for (EntradaDetalleDTO p : entradaDetalleResult.getEntradaDetalles()) {
			System.out.println("Entrada: "+ p.getEntradaId());
			System.out.println("Libro: "+ p.getLibroId());
			System.out.println("Cantidad: "+ p.getCantidad());
			
		}
	}
	
	public void getByIdEntradaDetalle(int id){
		EntradaDetalleDTO entradaDetalleResult = getJerseyClient().resource(getBaseUrl() + "/entradaDetalle/"+id).get(EntradaDetalleDTO.class);
		System.out.println("Entrada: "+ entradaDetalleResult.getEntradaId());
		System.out.println("Libro: "+ entradaDetalleResult.getLibroId());
		System.out.println("Cantidad: "+ entradaDetalleResult.getCantidad());
		
	}
	
	public void getByPropertyEntradaDetalle(String textToFind){
		EntradaDetalleResult patResult = getJerseyClient().resource(getBaseUrl() + "/entradaDetalle/search/"+textToFind).get(EntradaDetalleResult.class);
		for (EntradaDetalleDTO c : patResult.getEntradaDetalles()) {
			System.out.println("Entrada: "+ c.getEntradaId());
			System.out.println("Libro: "+ c.getLibroId());
			System.out.println("Cantidad: "+ c.getCantidad());
			
		}
		
	}
	
}



