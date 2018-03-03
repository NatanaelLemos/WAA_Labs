<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> --%>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%-- 	pageEncoding="UTF-8"%> --%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd"> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<%-- <title><spring:message code="welcome.listTitle" /></title> --%>
<!-- </head> -->
<!-- <body> -->
<!-- 	<h1> -->
<%-- 		<spring:message code="welcome.listTitle" /> --%>
<!-- 	</h1> -->

<!-- 	<h3> -->
<%-- 		<spring:message code="welcome.listTitle" /> --%>
<!-- 	</h3> -->

<!-- 	<ul> -->
<!-- 		<li> -->
<!-- 			<a href="carList"> -->
<%-- 				<spring:message code="welcome.carLink" /> --%>
<!-- 			</a> -->
<!-- 		</li> -->
<!-- 		<li> -->
<!-- 			<a href="bookStore"> -->
<%-- 				<spring:message code="welcome.bookLink" /> --%>
<!-- 			</a> -->
<!-- 		</li> -->
<!-- 	</ul> -->

<!-- </body> -->
<!-- </html> -->

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
	<h1>
		Welcome
	</h1>

	<h3>
		Select one
	</h3>

	<ul>
		<li>
			<a href="cars">
				Cars
			</a>
		</li>
		<li>
			<a href="bookStore">
				Books
			</a>
		</li>
	</ul>

</body>
</html>