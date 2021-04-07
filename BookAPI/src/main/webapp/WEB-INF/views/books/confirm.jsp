<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 12.02.2021
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>
<div>
    <h3>Czy jesteś pewien:</h3>
</div>

<div>
    <a href="<c:url value="/admin/books/all"/>">nie</a>
    <a href="<c:url value="/admin/books/delete/${id}"/>">tak</a>
</div>
</body>
</html>
