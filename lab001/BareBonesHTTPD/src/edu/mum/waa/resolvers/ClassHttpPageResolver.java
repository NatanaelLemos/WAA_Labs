package edu.mum.waa.resolvers;

import java.util.*;
import java.util.stream.Collectors;

import org.reflections.Reflections;

import edu.mum.waa.BBHttpRequest;
import edu.mum.waa.BBHttpResponse;
import edu.mum.waa.pages.IPage;

public class ClassHttpPageResolver extends HttpPageResolverCommon implements IHttpPageResolver {

	private String uri;
	private static Set<Class<? extends IPage>> allClasses;

	public ClassHttpPageResolver(String uri) {
		this.uri = uri;
	}

	@Override
	public void processRequest(BBHttpRequest httpRequest, BBHttpResponse httpResponse) {
		try {
			IPage page = getPageViaReflection(uri);
			
			if (page == null) {
				err404(httpResponse);
			}
			
			page.render(httpResponse);
		} catch (Exception ex) {
			err500(httpResponse);
		}
	}

	private IPage getPageViaReflection(String uri) throws InstantiationException, IllegalAccessException {
		if (allClasses == null) {
			allClasses = new Reflections("edu.mum.waa.pages").getSubTypesOf(IPage.class);
		}

		uri = uri.replace(".web", "").replace("/", "").toLowerCase();

		for (Class c : allClasses) {
			if (c.getName().toLowerCase().endsWith(uri)) {
				return instantiate(c);
			}
		}

		return null;
	}

	private IPage instantiate(Class c) throws InstantiationException, IllegalAccessException {
		return (IPage)c.newInstance();
	}
}
