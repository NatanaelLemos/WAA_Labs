package edu.mum.waa.pages;

import java.util.Date;

import edu.mum.waa.BBHttpResponse;

public class Welcome implements IPage {

	@Override
	public void render(BBHttpResponse httpResponse) {
		StringBuilder str = new StringBuilder();
		str.append("<!DOCTYPE html>");
		str.append("<html><head><title>");
		str.append("Welcome");
		str.append("</title></head><body>");
		str.append("<h1>Welcome</h1>");
		str.append("Opened in: ");
		str.append(new Date());
		str.append("</body></html>");
		
		httpResponse.setStatusCode(200);
		httpResponse.setMessage(str.toString());
	}

}
