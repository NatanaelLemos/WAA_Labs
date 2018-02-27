package edu.mum.waa.resolvers;

public class HttpPageResolverFactory {
	public static IHttpPageResolver createInstance(String uri) {
		if(uri.endsWith(".web")) {
			return new ClassHttpPageResolver(uri);
		} else {
			return new FileHttpPageResolver(uri);
		}
	}
}
