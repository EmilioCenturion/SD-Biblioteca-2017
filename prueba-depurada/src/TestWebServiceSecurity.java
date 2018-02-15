


import com.sd.uni.biblioteca.dto.user.UserDTO;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class TestWebServiceSecurity {

	public static void main(String[] args) {

		HTTPBasicAuthFilter feature = new HTTPBasicAuthFilter("admin", "admin");
		com.sun.jersey.api.client.Client jerseyClient = com.sun.jersey.api.client.Client.create();
		jerseyClient.addFilter(feature);

		UserDTO user = jerseyClient.resource("http://localhost:8080/biblioteca-platform/rest/user/1").get(UserDTO.class);

		System.out.println(user.getUsername());

	}
}