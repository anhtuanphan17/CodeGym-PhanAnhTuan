<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/9/2022
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h2>Discount calculator</h2>
<form method="post" action="/DiscountCalculator">
    <label>Product Descripttion </label><br/>
    <input type="text" name="product-description" value="iphone"><br/>
    <label>Price</label><br/>
    <input type="text" name="price" value="500"><br>
    <label>Discount</label><br>
    <input type="text" name="discount"><br>
    <input type="submit" value="convert">




</form>
</body>
</html>
