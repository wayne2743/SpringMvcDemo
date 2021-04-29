<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html; charset=utf-8" %>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>List Customers</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
}

#clickButton {
	margin: 10px;
}

.link{
	margin: 10px;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="clickButton">
		<button onclick="window.location.href='${pageContext.request.contextPath}/customer/customerInfoPage'">Add Customer</button>
		<button onclick="window.location.href='${pageContext.request.contextPath}/customer/list'">List All customer</button>
	</div>
	<div id="container">
		<div id="content">
			<!-- add out html table here -->

			<c:if test="${customers.size() > 0}">
				<table>
						<tr>
							<td>FirstName</td>
							<td>LastName</td>
							<td>email</td>
							<td></td>
							<td></td>
						</tr>
					<c:forEach var="tempCustomer" items="${customers}">
							<tr>
								<td>${tempCustomer.firstName}</td>
								<td>${tempCustomer.lastName}</td>
								<td>${tempCustomer.email}</td>
								<td><a href="/tracker.maven/customer/customerUpdatePage?customerId=${tempCustomer.id}">update</a>
								<td><a href="/tracker.maven/customer/deleteCustomer?customerId=${tempCustomer.id}">delete</a>
								</td>
							</tr>
					</c:forEach>
				</table>				
			</c:if>

		</div>
	</div>
	
	<div class="link">
		<a href="${pageContext.request.contextPath}" >back to main page</a>
	</div>
</body>
</html>