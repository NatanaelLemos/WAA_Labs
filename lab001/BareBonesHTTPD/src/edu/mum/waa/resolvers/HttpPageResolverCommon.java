package edu.mum.waa.resolvers;

import edu.mum.waa.BBHttpResponse;

public abstract class HttpPageResolverCommon {
	public void err404(BBHttpResponse httpResponse) {
		httpResponse.setStatusCode(404);
		httpResponse.setMessage("Not found");
	}
	
	public void err500(BBHttpResponse httpResponse) {
		httpResponse.setStatusCode(500);
		httpResponse.setMessage("Internal server error");
	}
}
