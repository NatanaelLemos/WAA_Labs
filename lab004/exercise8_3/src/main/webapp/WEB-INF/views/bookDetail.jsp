<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a Book</title>
</head>
<body>
	<form:form modelAttribute="bookModel" action="${book.id}" method="post">
		<table>
			<tr>
				<td>Title:</td>
				<td><form:input path="title" /></td>
				<td><form:errors path="title" cssClass="error" /></td>
			</tr>
			<tr>
				<td>ISBN:</td>
				<td><form:input path="ISBN" /></td>
				<td><form:errors path="ISBN" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Author:</td>
				<td><form:input path="author" /></td>
				<td><form:errors path="author" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><form:input path="price" /></td>
				<td><form:errors path="price" cssClass="error" /></td>
			</tr>
		</table>
		<input type="submit" value="update" />
	</form:form>
	<form action="delete?bookId=${book.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>