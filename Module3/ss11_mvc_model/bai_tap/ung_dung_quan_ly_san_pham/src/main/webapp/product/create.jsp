<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/14/2022
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Form</title>
</head>
<body>
<h1>create new product</h1>
<p>
    <c: if test="${"message"!=null}">
        <span>${"message"}</span>
    </c:>

<p>
    <a href="/products">Back to product list</a>
</p>

<form method="post">
    <fieldset>
        <legend>Product Information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="price" id="price"></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="description" id="description"></td>
            </tr>
            <tr>
                <td>Producer</td>
                <td><input type="text" name="producer" id="producer"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"></td>

            </tr>
        </table>

    </fieldset>

</form>

</body>
</html>
