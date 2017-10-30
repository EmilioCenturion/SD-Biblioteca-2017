package entrada;

import java.util.Date;

import base.AbstractBaseManager;

import com.sd.uni.biblioteca.dto.entrada.EntradaDTO;
import com.sd.uni.biblioteca.dto.entrada.EntradaResult;
import com.sd.uni.biblioteca.dto.motivoEntrada.MotivoEntradaDTO;
import com.sd.uni.biblioteca.dto.motivoEntrada.MotivoEntradaResult;

public class EntradaManager extends AbstractBaseManager {
	public EntradaManager() {
		
		super();
		addMotivoEntradas();
		
	}
	
	public void addMotivoEntradas(){
		
		MotivoEntradaDTO motivoEntradaDTO1 = new MotivoEntradaDTO();
		motivoEntradaDTO1.setDescripcion("Donacion");
		
		MotivoEntradaDTO motivoEntradaDTO2 = new MotivoEntradaDTO();
		motivoEntradaDTO2.setDescripcion("Compra");
		
		MotivoEntradaDTO motivoEntradaDTO3 = new MotivoEntradaDTO();
		motivoEntradaDTO3.setDescripcion("Trueque");
		
		getJerseyClient().resource(getBaseUrl() + "/motivoEntrada").entity(motivoEntradaDTO1).post(MotivoEntradaDTO.class);
		getJerseyClient().resource(getBaseUrl() + "/motivoEntrada").entity(motivoEntradaDTO2).post(MotivoEntradaDTO.class);
		getJerseyClient().resource(getBaseUrl() + "/motivoEntrada").entity(motivoEntradaDTO3).post(MotivoEntradaDTO.class);
		
	}
	
	public void addEntrada(String descripcion, Date fecha, Integer motivoEntradaId) {
		
		EntradaDTO entradaDTO = new EntradaDTO();
		entradaDTO.setDescripcion("Donado por el Director");;
		entradaDTO.setFecha(fecha);
		entradaDTO.setMotivoEntradaId(motivoEntradaId);
		
		getJerseyClient().resource(getBaseUrl() + "/entrada").entity(entradaDTO).post(EntradaDTO.class);
	}
	
	
	public void getAllEntradas() {
		EntradaResult entradaResult = getJerseyClient().resource(getBaseUrl() + "/entrada").get(EntradaResult.class);
		for (EntradaDTO p : entradaResult.getEntradas()) {
			System.out.println("Fecha: "+p.getFecha());
			System.out.println("MotivoEntrada: "+p.getMotivoEntradaId());
			System.out.println("Descripcion: "+p.getDescripcion());
			
		}
	}
	
	public void getByIdEntrada(int id){
		EntradaDTO entradaResult = getJerseyClient().resource(getBaseUrl() + "/entrada/"+id).get(EntradaDTO.class);
		System.out.println("Fecha: "+ entradaResult.getFecha());
		System.out.println("MotivoEntrada: "+ entradaResult.getMotivoEntradaId());
		System.out.println("Descripcion: "+ entradaResult.getDescripcion());
		
	}
	
	public void getByPropertyEntrada(String textToFind){
		EntradaResult patResult = getJerseyClient().resource(getBaseUrl() + "/entrada/search/"+textToFind).get(EntradaResult.class);
		for (EntradaDTO c : patResult.getEntradas()) {
			System.out.println("Fecha: "+ c.getFecha());
			System.out.println("MotivoEntrada: "+ c.getMotivoEntradaId());
			System.out.println("Descripcion: "+ c.getDescripcion());
			
		}
		
	}
	
}



