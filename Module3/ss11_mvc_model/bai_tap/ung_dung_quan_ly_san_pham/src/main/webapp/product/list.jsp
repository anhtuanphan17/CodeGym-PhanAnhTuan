<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/14/2022
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product List</h1>

<p>
    <a href="/products?action=create"> Create new product</a>
</p>

<table border="1">
    <tr>
        <th>Order</th>
        <th>ID</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Producer</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

    <c:forEach var="product" items="${products}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${product.getId()}</td>
            <td><a href="/products?action=view&id=${product.getId()}">${product.getProductName()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getProducer()}</td>
            <td><a href="/products?action=edit&id=${product.getId()}">Edit</a></td>
            <td><a href="/products?action=delete&id=${product.getId()}">Delete</a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
