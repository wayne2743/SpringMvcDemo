<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Save user</title>
</head>
<body>
	<h2>User Registration</h2>
	<form:form modelAttribute="loginUser" action="${pageContext.request.contextPath}/user/update" method="POST">
		<table>
			<tr>
				<td>User Name :</td>
				<td><form:input path="userName" /></td>
				<td><form:errors class="error"  path="userName" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:input path="password" /></td>
				<td><form:errors class="error"  path="password" /></td>
			</tr>
		</table>

		<button type="submit">submit</button>
	</form:form>
</body>
</html>