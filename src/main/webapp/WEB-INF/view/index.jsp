<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=utf-8" %>
<html>
<body>
<h2>Spring mvc 客戶管理系統</h2>

<div>
	<a href="${pageContext.request.contextPath}/customer/list" >賣場客戶清單</a>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
