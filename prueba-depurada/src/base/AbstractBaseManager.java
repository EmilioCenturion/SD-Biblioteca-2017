package base;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public abstract class AbstractBaseManager {
	private final String BASE_URL = "http://localhost:8080/Biblioteca/rest";

	private final Client _jerseyClient;
	
	public AbstractBaseManager() {
		
		HTTPBasicAuthFilter feature = new HTTPBasicAuthFilter("admin", "admin");
		_jerseyClient = com.sun.jersey.api.client.Client.create();
		_jerseyClient.addFilter(feature);
	}


	protected String getBaseUrl() {
		return BASE_URL;
	}

	protected Client getJerseyClient() {
		return _jerseyClient;
	}
}
