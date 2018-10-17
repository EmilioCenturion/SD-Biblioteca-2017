package cliente;

import base.AbstractBaseManager;

import com.sd.uni.biblioteca.dto.cliente.ClienteDto;
import com.sd.uni.biblioteca.dto.cliente.ClienteResult;
import com.sd.uni.biblioteca.dto.entrada.EntradaDTO;
import com.sd.uni.biblioteca.dto.entrada.EntradaResult;

public class ClienteManager extends AbstractBaseManager {
	
	public ClienteManager() {
		super();
	}
	
	public void addCliente(String nombre, String apellido, String ruc, String direccion, String telefono, int ci, String correo) {
		
		ClienteDto clienteDTO = new ClienteDto();
		clienteDTO.setNombre(nombre);
		clienteDTO.setApellido(apellido);
		clienteDTO.setDireccion(direccion);
		clienteDTO.setInvitacion(true); //acá se configura para que se envien
		clienteDTO.setCi(ci);
		clienteDTO.setTelefono(telefono);
		clienteDTO.setCorreo(correo);
		clienteDTO.setRuc(ruc);
		getJerseyClient().resource(getBaseUrl() + "/cliente").entity(clienteDTO).post(ClienteDto.class);
	}
	
	public void getAllClientes() {
		ClienteResult clienteResult = getJerseyClient().resource(getBaseUrl() + "/cliente").get(ClienteResult.class);
		for (ClienteDto p : clienteResult.getClientes()) {
			System.out.println("Nombre: "+p.getNombre());
			System.out.println("Apellido: "+p.getApellido());
			System.out.println("Direccion: "+p.getDireccion());
			System.out.println("Oferta: "+p.getInvitacion());
			System.out.println("ci: "+p.getCi());
			System.out.println("Telefono: "+p.getTelefono());
			System.out.println("Ruc: "+p.getRuc());
			System.out.println("Correo: "+p.getCorreo());
			
		}
	}
}
