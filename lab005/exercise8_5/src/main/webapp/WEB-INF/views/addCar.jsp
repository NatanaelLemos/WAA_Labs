<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a Car</title>
</head>
<body>
	<form:form modelAttribute="car" action="cars" method="post">
		<table>
			<tr>
				<td>Make:</td>
				<td><form:input path="make" /></td>
				<td><form:errors path="make" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Model:</td>
				<td><form:input path="model" /></td>
				<td><form:errors path="model" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Year:</td>
				<td><form:input path="year" /></td>
				<td><form:errors path="year" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Color:</td>
				<td><form:input path="color" /></td>
				<td><form:errors path="color" cssClass="error" /></td>
			</tr>
		</table>
		<input type="submit" />

	</form:form>
</body>
</html>