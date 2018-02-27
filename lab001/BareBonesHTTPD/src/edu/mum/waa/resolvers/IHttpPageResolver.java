package edu.mum.waa.resolvers;

import edu.mum.waa.BBHttpRequest;
import edu.mum.waa.BBHttpResponse;

public interface IHttpPageResolver {

	void processRequest(BBHttpRequest httpRequest, BBHttpResponse httpResponse);

}
