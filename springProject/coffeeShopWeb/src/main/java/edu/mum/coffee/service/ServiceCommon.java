package edu.mum.coffee.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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

	protected Class<T> getTType() {
		return this.tType;
	}

	public ServiceCommon(String uri, Class<T> tType) {
		if (!uri.startsWith("/")) {
			uri = "/" + uri;
		}

		if (!uri.endsWith("/")) {
			uri += "/";
		}

		this.uri = url + uri;
		this.tType = tType;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public List<T> getAll() {
		List<T> result = getClient().getForObject(uri, List.class);
		return fixedList(result);
	}
	
	protected List<T> fixedList(List result){
		if (result.size() == 0) {
			return result;
		}

		String typeName = result.get(0).getClass().getName();
		if (typeName.toUpperCase().contains("LINKEDHASHMAP")) {
			return getResultOneByOne(result);
		} else {
			return result;
		}
	}

	private List<T> getResultOneByOne(List firstResult) {
		try {
			List<T> newResult = new ArrayList<T>();

			for(Object item : firstResult) {
				Object key = ((LinkedHashMap)item).get("id");
				newResult.add(get((K)key));
			}
			
			return newResult;
			
		} catch (Exception e) {
			return null;
		}
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
