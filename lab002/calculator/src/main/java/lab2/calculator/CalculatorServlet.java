package lab2.calculator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String page = 
			"<!DOCTYPE html>\n" 
			+ "<html>\n" 
			+ "	<head>\n"
			+ "		<meta charset=\"UTF-8\" />\n" 
			+ "		<title>Calculate</title>\n" 
			+ "	</head>\n" 
			+ "	<body>\n"
			+ "		<form method=\"POST\">\n" 
			+ "			<div>\n"
			+ "				<input name=\"addNum1\" value=\"{addNum1}\" />\n" 
			+ "				+\n"
			+ "				<input name=\"addNum2\" value=\"{addNum2}\" />\n" 
			+ "				=\n"
			+ "				<input name=\"addResult\" value=\"{addResult}\" />\n" 
			+ "			</div>\n"
			+ "			<br />\n" 
			+ "			<div>\n"
			+ "				<input name=\"multNum1\" value=\"{multNum1}\" />\n" 
			+ "				*\n"
			+ "				<input name=\"multNum2\" value=\"{multNum2}\" />\n" 
			+ "				=\n"
			+ "				<input name=\"multResult\" value=\"{multResult}\" />\n" 
			+ "			</div>\n"
			+ "			<button type=\"submit\">Submit</button>"
			+ "		</form>\n" 
			+ "	</body>\n" 
			+ "</html>";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		String addNum1 = req.getParameter("paddNum1") == null ? "" : req.getParameter("paddNum1");
		String addNum2 = req.getParameter("paddNum2") == null ? "" : req.getParameter("paddNum2");
		String multNum1 = req.getParameter("pmultNum1") == null ? "" : req.getParameter("pmultNum1");
		String multNum2 = req.getParameter("pmultNum2") == null ? "" : req.getParameter("pmultNum2");
		String addResult = "";
		String multResult = "";

		if ((!addNum1.equals("")) && (!addNum2.equals(""))) {
			addResult = Integer.toString(Integer.parseInt(addNum1) + Integer.parseInt(addNum2));
		}

		if ((!multNum1.equals("")) && (!multNum2.equals(""))) {
			multResult = Integer.toString(Integer.parseInt(multNum1) * Integer.parseInt(multNum2));
		}

		out.println(page
				.replace("{addNum1}", addNum1)
				.replace("{addNum2}", addNum2)
				.replace("{addResult}", addResult)
				.replace("{multNum1}", multNum1)
				.replace("{multNum2}", multNum2)
				.replace("{multResult}", multResult)
			);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder url = new StringBuilder();
		url.append("/lab2.calculator/calculator?");
		Enumeration<String> parameterNames = req.getParameterNames();
		
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String paramValue = req.getParameter(paramName);
			
			if(paramName != null && paramValue != null && (!paramName.equals("")) && (!paramValue.equals(""))) {
				if(paramName.startsWith("p")) {
					continue;
				}
				url.append("p" + paramName + "="+ paramValue + "&");
			}
		}

		resp.sendRedirect(url.toString());
	}
}
