<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 12.02.2021
  Time: 00:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book add</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    <div>
        <h2>Dodaj pozycje ksiażki:</h2>
        <div>
            <h4>ISBN:</h4>
            <form:input path="isbn"/>
            <form:errors path="isbn"/>
        </div>
        <div>
            <h4>Title:</h4>
            <form:input path="title"/>
            <form:errors path="title"/>
        </div>
        <div>
            <h4>Author:</h4>
            <form:input path="author"/>
            <form:errors path="author"/>
        </div>
        <div>
            <h4>Publisher:</h4>
            <form:input path="publisher"/>
            <form:errors path="publisher"/>
        </div>
        <div>
            <h4>Type:</h4>
            <form:input path="type"/>
            <form:errors path="type"/>
        </div>

    </div>
    <input type="submit" name="Save">

</form:form>
</body>
</html>
