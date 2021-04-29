<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>save-customer</title>
<style type="text/css">
	.error {
		color:red;
	}
</style>
</head>
<body>
	<div id="header">
		<h2>CRM - Customer Relationship Manager</h2>
	</div>
	
	<div>
		<h3>Save Customer Information</h3>
		<form:form action="updateCustomer" modelAttribute="customer" method="POST">
			<form:hidden path="id" value="${customer.id}" />
			<table>
				<tr>
					<td>First name:</td>
					<td><form:input path="firstName"/></td>
					<td><form:errors class="error"  path="firstName" /></td>
				</tr>
				<tr>
					<td>Last name:</td>
					<td><form:input path="lastName"/></td>
					<td><form:errors class="error"  path="lastName" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email"/></td>
					<td><form:errors class="error" path="email" /></td>
				</tr>
				<tr>
					<td><input type="submit" /></td>
					<td></td>
				</tr>
			</table>
			
		</form:form>
	
	</div>
</body>
</html>