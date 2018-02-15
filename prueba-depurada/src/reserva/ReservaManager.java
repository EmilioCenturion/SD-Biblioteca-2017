package reserva;

import java.util.Date;

import base.AbstractBaseManager;

import com.sd.uni.biblioteca.dto.reserva.ReservaDTO;
import com.sd.uni.biblioteca.dto.reserva.ReservaResult;
import com.sd.uni.biblioteca.dto.usuario.UsuarioDTO;
import com.sd.uni.biblioteca.dto.usuario.UsuarioResult;

public class ReservaManager extends AbstractBaseManager {
	public ReservaManager() {
		
		super();
		
	}
	
	
	
	public void addReserva(Date fechaPedido, Date fechaReserva, Integer usuarioId) {
		
		ReservaDTO reservaDTO = new ReservaDTO();
		reservaDTO.setFechaPedido(fechaPedido);
		reservaDTO.setFechaReserva(fechaReserva);
		reservaDTO.setUsuarioId(usuarioId);
		
		getJerseyClient().resource(getBaseUrl() + "/reserva").entity(reservaDTO).post(ReservaDTO.class);
	}
	
	
	public void getAllReservas() {
		ReservaResult reservaResult = getJerseyClient().resource(getBaseUrl() + "/reserva").get(ReservaResult.class);
		for (ReservaDTO p : reservaResult.getReservas()) {
			System.out.println("Fecha Pedido: "+p.getFechaPedido());
			System.out.println("Fecha Reserva: "+p.getFechaReserva());
			System.out.println("Usuario: "+p.getUsuarioId());
			
		}
	}
	
	public void getByIdReserva(int id){
		ReservaDTO reservaResult = getJerseyClient().resource(getBaseUrl() + "/reserva/"+id).get(ReservaDTO.class);
		System.out.println("Fecha Pedido: "+ reservaResult .getFechaPedido());
		System.out.println("Fecha Reserva: "+ reservaResult .getFechaReserva());
		System.out.println("Usuario: "+ reservaResult .getUsuarioId());
		
	}
	
	public void getByPropertyReserva(String textToFind){
		ReservaResult patResult = getJerseyClient().resource(getBaseUrl() + "/reserva/search/"+textToFind).get(ReservaResult.class);
		for (ReservaDTO c : patResult.getReservas()) {
			System.out.println("Fecha Pedido: "+c.getFechaPedido());
			System.out.println("Fecha Reserva: "+c.getFechaReserva());
			System.out.println("Usuario: "+c.getUsuarioId());
			
		}
		
	}
	
}


