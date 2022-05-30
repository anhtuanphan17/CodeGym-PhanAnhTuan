<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/14/2022
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>view</title>
</head>
<body>
<h1>Customer details</h1>
<p>
    <a href="/products">Back to products list</a>
</p>
<table>
    <tr>
        <td>Product Id:</td>
        <td>${requestScope["product"].getId()}</td>
    </tr>
    <tr>
        <td>Product Name:</td>
        <td>${requestScope["product"].getProductName()}</td>
    </tr>
    <tr>
        <td>Price:</td>
        <td>${requestScope["product"].getPrice()}</td>
    </tr>
    <tr>
        <td>Description:</td>
        <td>${requestScope["product"].getDescription()}</td>
    </tr>
    <tr>
        <td>Producer:</td>
        <td>${requestScope["product"].getProducer()}</td>
    </tr>
</table>
</body>
</html>
