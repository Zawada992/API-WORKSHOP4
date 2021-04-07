<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Book List</title>
</head>
<body>
<table border="1">
    <thead>

    <th>ISBN</th>
    <th>Title</th>
    <th>Author</th>
    <th>Action</th>

    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td>
                <a href="<c:out value="/admin/books/edit/${book.id}"/> ">Edit</a>
                <a href="<c:out value="/admin/books/confirm/${book.id}"/> ">Delete</a>
                <a href="<c:out value="/admin/books/show/${book.id}"/> ">Show</a>
            </td>
        </tr>
    </c:forEach>
    <a href="<c:url value="/admin/books/add?id=${book.id}"/>">Add new book</a>
    </tbody>

</table>
</body>
</html>
