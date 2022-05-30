<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/16/2022
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" cellpadding="5">
<caption><h2>List of Users</h2></caption>
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Country</th>

</tr>
<c:forEach var="user" items="${userList}">
    <tr>
    <td><c:out value="${user.getId()}"/></td>
    <td><c:out value="${user.getName()}"/></td>
    <td><c:out value="${user.getEmail()}"/></td>
    <td><c:out value="${user.getCountry()}"/></td>
    </tr>
    </c:forEach>

</body>
</html>
