<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html; charset=utf-8" %>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
	<title>Login Input Page</title>
	<style type="text/css">
		.link{
			margin:10px;
			float:right;
		}
		.error{
			color: red;
		}
		h2{
			color:blue;
		}
	</style>
</head>
<body>
	<h2>Login Page</h2>
	<div class="link">
		<a href="${pageContext.request.contextPath}/user/toRegitration" >registration</a>
	</div>
	<form:form modelAttribute="loginUser" action="${pageContext.request.contextPath}/user/checkUser"  method="POST">

		<table>
			<tr>
				<td>User Name : </td>
				<td>
					<form:input path="userName" />
		
				</td>
				<td>
					<form:errors class="error"  path="userName" />
					<div class="error">${errMsg}</div>
				</td>			
			</tr>
			<tr>
				<td>Password : </td>
				<td>
					<form:input path="password" />
				</td>
				<td><form:errors class="error"  path="password" /></td>
			</tr>
		</table>
		

		<button type="submit" >submit</button>
	</form:form>
	
</body>
</html>