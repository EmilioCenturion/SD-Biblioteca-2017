package salida;

import java.util.Date;

import base.AbstractBaseManager;

import com.sd.uni.biblioteca.dto.salidaDetalle.SalidaDetalleDTO;
import com.sd.uni.biblioteca.dto.salidaDetalle.SalidaDetalleResult;


public class SalidaDetalleManager extends AbstractBaseManager {
	public SalidaDetalleManager() {
		
		super();
		
	}
	
	
	
	public void addSalidaDetalle(Integer salidaId, Integer libroId, int cant) {
		
		SalidaDetalleDTO salidaDetalleDTO = new SalidaDetalleDTO();
		salidaDetalleDTO.setSalidaId(salidaId);
		salidaDetalleDTO.setLibroId(libroId);
		salidaDetalleDTO.setCantidad(cant);
		
		getJerseyClient().resource(getBaseUrl() + "/salidaDetalle").entity(salidaDetalleDTO).post(SalidaDetalleDTO.class);
	}
	
	
	public void getAllSalidaDetalles() {
		SalidaDetalleResult salidaDetalleResult = getJerseyClient().resource(getBaseUrl() + "/salidaDetalle").get(SalidaDetalleResult.class);
		for (SalidaDetalleDTO p : salidaDetalleResult.getSalidaDetalles()) {
			System.out.println("Salida: "+ p.getSalidaId());
			System.out.println("Libro: "+ p.getLibroId());
			System.out.println("Cantidad: "+ p.getCantidad());
			
		}
	}
	
	public void getByIdSalidaDetalle(int id){
		SalidaDetalleDTO salidaDetalleResult = getJerseyClient().resource(getBaseUrl() + "/salidaDetalle/"+id).get(SalidaDetalleDTO.class);
		System.out.println("Salida: "+ salidaDetalleResult.getSalidaId());
		System.out.println("Libro: "+ salidaDetalleResult.getLibroId());
		System.out.println("Cantidad: "+ salidaDetalleResult.getCantidad());
		
	}
	
	public void getByPropertySalidaDetalle(String textToFind){
		SalidaDetalleResult patResult = getJerseyClient().resource(getBaseUrl() + "/salidaDetalle/search/"+textToFind).get(SalidaDetalleResult.class);
		for (SalidaDetalleDTO c : patResult.getSalidaDetalles()) {
			System.out.println("Salida: "+ c.getSalidaId());
			System.out.println("Libro: "+ c.getLibroId());
			System.out.println("Cantidad: "+ c.getCantidad());
			
		}
		
	}
	
}



