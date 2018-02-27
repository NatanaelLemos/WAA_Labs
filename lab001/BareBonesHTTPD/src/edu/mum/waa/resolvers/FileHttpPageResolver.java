package edu.mum.waa.resolvers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import edu.mum.waa.BBHttpRequest;
import edu.mum.waa.BBHttpResponse;

public class FileHttpPageResolver extends HttpPageResolverCommon implements IHttpPageResolver {

	private String uri;

	public FileHttpPageResolver(String uri) {
		this.uri = uri;
	}

	@Override
	public void processRequest(BBHttpRequest httpRequest, BBHttpResponse httpResponse) {
		try {
			String filePath = new File("").getAbsolutePath();
			File file = new File(filePath + "/web" + uri);

			if (!file.exists() || file.isDirectory()) {
				err404(httpResponse);
				return;
			}

			StringBuilder response = new StringBuilder();
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				String st;
				while ((st = br.readLine()) != null) {
					response.append(st);
				}
				httpResponse.setStatusCode(200);
				httpResponse.setMessage(response.toString());
			} catch (Exception ex) {
				throw ex;
			}
		} catch (Exception e) {
			err500(httpResponse);
		}
	}
}
