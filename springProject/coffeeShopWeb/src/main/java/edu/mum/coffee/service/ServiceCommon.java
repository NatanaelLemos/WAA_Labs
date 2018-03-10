package edu.mum.coffee.service;

import java.util.List;
import org.springframework.web.client.RestTemplate;

public abstract class ServiceCommon<T, K> {
	
	private static String url = "http://localhost:8090";
	
	private String uri;
	private Class<T> tType;
	
	protected RestTemplate getClient() {
		return new RestTemplate();
	}
	
	protected String getUri() {
		return this.uri;
	}
	
	protected Class<T> getTType(){
		return this.tType;
	}
	
	public ServiceCommon(String uri, Class<T> tType) {
		if(!uri.startsWith("/")) {
			uri = "/" + uri;
		}
		
		if(!uri.endsWith("/")) {
			uri += "/";
		}
		
		this.uri = url + uri;
		this.tType = tType;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return (List<T>)getClient().getForObject(uri, List.class);
	}
	
	public T get(K id) {
		return getClient().getForObject(uri + id.toString(), tType);
	}
	
	public T add(T obj) {
		return getClient().postForObject(uri, obj, tType);
	}
	
	public T edit(K id, T obj) {
		getClient().put(uri + id.toString(), obj);
		return obj;
	}
	
	public void delete(K id) {
		getClient().delete(uri + id.toString());
	}
}
