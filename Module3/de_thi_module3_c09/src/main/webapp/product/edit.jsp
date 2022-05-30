<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/24/2022
  Time: 8:43 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit file</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<%--navbar--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="index.jsp">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/products">Product <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/customers">Customer</a>
            </li>
            <!--                <li class="nav-item dropdown">-->
            <!--                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"-->
            <!--                       aria-expanded="false">-->
            <!--                        Dropdown-->
            <!--                    </a>-->
            <!--                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">-->
            <!--                        <a class="dropdown-item" href="#">Action</a>-->
            <!--                        <a class="dropdown-item" href="#">Another action</a>-->
            <!--                        <div class="dropdown-divider"></div>-->
            <!--                        <a class="dropdown-item" href="#">Something else here</a>-->
            <!--                    </div>-->
            <!--                </li>-->
            <li class="nav-item">
                <a class="nav-link disabled">Contract</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled">Service</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="/products?action=search" method="post">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="searchWord">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>



<center>
    <h1>Product Management</h1>
    <h2>
        <a href="/products">List Products</a>
    </h2>
</center>
<div>
    <form method="post" action="products?&action=edit">
        <caption><h2>Edit Product</h2></caption>
        <table>

            <c:if test="${product!=null}">
                <input type="hidden" name="productId" value="${product.getProductId()}"/>
            </c:if>
            <tr>
                <th>Product Name</th>
                <td>
                    <input type="text" name="productName" value="${product.getProductName()}" size="45"/>
                </td>
            </tr>

                <th>Product Price</th>
                <td>
                    <input type="text" name="price" value="${product.getPrice()}" size="45"/>
                </td>
            </tr>

            <tr>
                <th>Product Quantity</th>
                <td>
                    <input type="text" name="quantity" value="${product.getQuantity()}" size="45"/>
                </td>
            </tr>

            <tr>
                <th>Color</th>
                <td>
                    <select name="color">
                        <c:forEach var="color" items="${colorList}">
                            <option value="${color.getColorId()}" ${color.getColorId()==product.getColorId().getColorId()?"selected":""}>${color.getColorName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <th>Category </th>
                <td>
                    <select name="category">
                        <c:forEach var="category" items="${categoryList}">
                            <option value="${category.getCategoryId()}" ${category.getCategoryId()==product.getCategoryId().getCategoryId()?"selected":""}>${category.getCategoryName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>

        </table>
    </form>
</div>


</body>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</html>
