<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<div>
			<input name="addNum1" value="<% out.println(request.getParameter("addNum1")); %>"/>
			<input name="addNum2" value="<% out.println(request.getParameter("addNum2")); %>"/>
			<input name="addResult" value="<% out.println((request.getParameter("addNum1") != null && request.getParameter("addNum2") != null) ? Integer.toString(Integer.parseInt(request.getParameter("addNum1")) + Integer.parseInt(request.getParameter("addNum2"))) : ""); %>" />
		</div>
		<div>
			<input name="multNum1" value="<% out.println(request.getParameter("multNum1")); %>"/>
			<input name="multNum2" value="<% out.println(request.getParameter("multNum2")); %>"/>
			<input name="multResult" value="<% out.println((request.getParameter("multNum1") != null && request.getParameter("multNum2") != null) ? Integer.toString(Integer.parseInt(request.getParameter("multNum1")) * Integer.parseInt(request.getParameter("multNum2"))) : ""); %>" />
		</div>
		<button type="submit">Submit</button>
	</form>
</body>
</html>