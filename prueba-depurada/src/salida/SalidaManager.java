package salida;

import java.util.Date;

import base.AbstractBaseManager;

import com.sd.uni.biblioteca.dto.salida.SalidaDTO;
import com.sd.uni.biblioteca.dto.salida.SalidaResult;
import com.sd.uni.biblioteca.dto.motivoSalida.MotivoSalidaDTO;
import com.sd.uni.biblioteca.dto.motivoSalida.MotivoSalidaResult;

public class SalidaManager extends AbstractBaseManager {
	public SalidaManager() {
		
		super();
		addMotivoSalidas();
		
	}
	
	public void addMotivoSalidas(){
		
		MotivoSalidaDTO motivoSalidaDTO1 = new MotivoSalidaDTO();
		motivoSalidaDTO1.setDescripcion("Extravío");
		
		MotivoSalidaDTO motivoSalidaDTO2 = new MotivoSalidaDTO();
		motivoSalidaDTO2.setDescripcion("Deterioro");
		
		
		
		getJerseyClient().resource(getBaseUrl() + "/motivoSalida").entity(motivoSalidaDTO1).post(MotivoSalidaDTO.class);
		getJerseyClient().resource(getBaseUrl() + "/motivoSalida").entity(motivoSalidaDTO2).post(MotivoSalidaDTO.class);		
	}
	
	public void addSalida(String descripcion, Date fecha, Integer motivoSalidaId) {
		
		SalidaDTO salidaDTO = new SalidaDTO();
		salidaDTO.setDescripcion("Probablemente haya sido robado");
		salidaDTO.setFecha(fecha);
		salidaDTO.setMotivoSalidaId(motivoSalidaId);
		
		getJerseyClient().resource(getBaseUrl() + "/salida").entity(salidaDTO).post(SalidaDTO.class);
	}
	
	
	public void getAllSalidas() {
		SalidaResult salidaResult = getJerseyClient().resource(getBaseUrl() + "/salida").get(SalidaResult.class);
		for (SalidaDTO p : salidaResult.getSalidas()) {
			System.out.println("Fecha: "+p.getFecha());
			System.out.println("Motivo Salida: "+p.getMotivoSalidaId());
			System.out.println("Descripcion: "+p.getDescripcion());
			
		}
	}
	
	public void getByIdSalida(int id){
		SalidaDTO salidaResult = getJerseyClient().resource(getBaseUrl() + "/salida/"+id).get(SalidaDTO.class);
		System.out.println("Fecha: "+ salidaResult.getFecha());
		System.out.println("Motivo Salida: "+ salidaResult.getMotivoSalidaId());
		System.out.println("Descripcion: "+ salidaResult.getDescripcion());
		
	}
	
	public void getByPropertySalida(String textToFind){
		SalidaResult patResult = getJerseyClient().resource(getBaseUrl() + "/salida/search/"+textToFind).get(SalidaResult.class);
		for (SalidaDTO c : patResult.getSalidas()) {
			System.out.println("Fecha: "+ c.getFecha());
			System.out.println("Motivo Salida: "+ c.getMotivoSalidaId());
			System.out.println("Descripcion: "+ c.getDescripcion());
			
		}
		
	}
	
}



