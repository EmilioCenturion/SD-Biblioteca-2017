package com.sd.uni.biblioteca.rest.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.base.BaseDTO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Repository
public abstract class BaseResourceImpl<DTO extends BaseDTO> implements IBaseResource<DTO> {
	private final String _resourcePath;
	private final Class<DTO> _dtoClass;
	private final WebResource _webResource;

	private static final String BASE_URL = "http://localhost:8080/biblioteca-platform/rest";
	protected static final String CACHE_REGION = "biblioteca-platform-web-cache";
	

	@Autowired
	@Qualifier("grailsCacheManager")
	private CacheManager _cacheManager;

	
	public BaseResourceImpl(Class<DTO> dtoClass, String resourcePath) {
		_dtoClass = dtoClass;
		_resourcePath = BASE_URL + resourcePath;

		final Client jerseyClient = Client.create();

		_webResource = jerseyClient.resource(_resourcePath);
	}

	protected WebResource getWebResource() {
		return _webResource;
	}

	protected Class<DTO> getDtoClass() {
		return _dtoClass;
	}

	@Override
	public DTO save(DTO dto) {
		return getWebResource().entity(dto).post(getDtoClass());
	}

	@Override
	public DTO getById(Integer id) {
		return getWebResource().path("/" + id).get(getDtoClass());
	}

	protected CacheManager getCacheManager() {
		return _cacheManager;
	}
}
