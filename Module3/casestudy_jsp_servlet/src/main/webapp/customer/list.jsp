<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/18/2022
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
<div id="heading">
    <div id="header">
        <nav class="navbar navbar-light bg-dark">
            <a class="navbar-brand" href="#">
                <img src="https://zoukclub.com/wp-content/uploads/2019/11/Furama-Riverfront-Logo.png" width="60"
                     height="60"
                     alt="">
            </a>
        </nav>
    </div>
    <!--narbar-->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="index.jsp">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/employee">Employee <span class="sr-only">(current)</span></a>
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
            <form class="form-inline my-2 my-lg-0" method="post" action="/customers?action=search">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="searchWord">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</div>



<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="/customers?action=create">Add New Customer</a>
    </h2>
    <h2>
        <a href="/customers?action=sort">Sort by name</a>
    </h2>
</center>
<%--<div align="right">--%>
<%--    <table >--%>
<%--        <form method="post" action="users?action=search">--%>
<%--            <label>Search</label>--%>
<%--            <input type="text" name="search">--%>
<%--            <input type="submit" value="search">--%>
<%--        </form>--%>
<%--    </table>--%>
<%--</div>--%>

<div align="center" style="text-align: center">
    <caption><h2>List of Customers</h2></caption>
    <table border="1" cellpadding="5">

        <tr>
            <th>Customer ID</th>
            <th>Customer Name</th>
            <th>Customer Birthday</th>
            <th>Customer Gender</th>
            <th>Customer ID Card</th>
            <th>Customer Phone</th>
            <th>Customer Email</th>
            <th>Customer Address</th>
            <th>Customer Type Name</th>
            <th>Edit</th>
            <th>Remove</th>
        </tr>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td><c:out value="${customer.getCustomerId()}"/></td>
                <td><c:out value="${customer.getCustomerName()}"/></td>
                <td><c:out value="${customer.getCustomerBirthday()}"/></td>
                <td>
                    <c:choose>
                        <c:when test="${customer.getCustomerGender()==1}">
                            Female
                        </c:when>
                        <c:otherwise>
                            Male
                        </c:otherwise>
                    </c:choose>

                </td>
                <td><c:out value="${customer.getCustomerIdCard()}"/></td>
                <td><c:out value="${customer.getCustomerPhone()}"/></td>
                <td><c:out value="${customer.getCustomerEmail()}"/></td>
                <td><c:out value="${customer.getCustomerAddress()}"/></td>
                <td><c:out value="${customer.customerTypeId.getCustomerTypeName()}"/></td>

                <td>
                    <a href="/customers?action=edit&id=${customer.getCustomerId()}">Edit</a>

                </td>
                <td>
                    <a href="/customers?action=delete&id=${customer.getCustomerId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>


    </table>
</div>

</body>
<jsp:include page="/include/boostrap.jsp"></jsp:include>
</html>
