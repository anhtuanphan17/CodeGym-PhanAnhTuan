<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/10/2022
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
<h1>Customer List</h1>
<table class="table">
    <thead class="thead-light">
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Date of birth</th>
        <th scope="col">Address</th>
        <th scope="col">Image</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="i" items="${list1}">
        <tr>
            <td>${i.name}</td>
            <td>${i.dateOfBirth}</td>
            <td>${i.address}</td>
            <td><img width="200" height="150" src="${i.image}" alt=""></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
