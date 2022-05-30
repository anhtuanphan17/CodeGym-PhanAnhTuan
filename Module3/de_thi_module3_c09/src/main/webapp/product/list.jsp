<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/23/2022
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
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
        <form class="form-inline my-2 my-lg-0" action="/products?action=searchName" method="post">
            <input class="form-control mr-sm-2" type="search" placeholder="Search By Name" aria-label="Search" name="searchWord">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <form class="form-inline my-2 my-lg-0" action="/products?action=searchPrice" method="post">
            <input class="form-control mr-sm-2" type="search" placeholder="Search By Price" aria-label="Search" name="searchWord">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <form class="form-inline my-2 my-lg-0" action="/products?action=searchPrice" method="post">
            <input class="form-control mr-sm-2" type="search" placeholder="Search By category" aria-label="Search" name="searchWord">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<center>
    <h1>Product Management</h1>
    <h2>
        <a href="/products?action=create">Add New Product</a>
    </h2>
    <h2>
        <a href="/products?action=sort">Sort by name</a>
    </h2>
</center>
<div align="center">

    <table border="1" id="example" class="table table-striped table-bordered">

        <thead>
        <tr>
            <th>STT</th>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Product Price</th>
            <th>Product Quantity</th>
            <th>Product Color</th>
            <th>Product Category</th>
            <th>Edit</th>
            <th>Remove</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="product" items="${productList}" varStatus="loop">

            <tr>
                <td><c:out value="${loop.count}"></c:out> </td>
                <td><c:out value="${product.getProductId()}"/></td>
                <td><c:out value="${product.getProductName()}"/></td>
                <td><c:out value="${product.getPrice()}"/></td>
                <td><c:out value="${product.getQuantity()}"/></td>
                <td><c:out value="${product.getColorId().getColorName()}"/></td>
                <td><c:out value="${product.getCategoryId().getCategoryName()}"/></td>
                <td>
                    <a href="/products?action=edit&id=${product.getProductId()}">Edit</a>
                </td>
                <td>
                        <%--                <a href="/employee?action=delete&id=${employee.getEmployeeId()}">Delete</a>--%>
                    <button onclick="deleteById('${product.getProductId()}')" type="button" class="btn btn-primary"
                            data-toggle="modal" data-target="#exampleModal">
                        Delete
                    </button>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/products?" method="get">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="deleteByModal" id="deleteByModal">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Do you want to remove</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    yes or no?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </form>
        </div>
    </div>
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

<script>
    $.extend(true, $.fn.dataTable.defaults, {
        "searching": false,
        "ordering": false
    });
    $(document).ready(function () {
        $('#example').DataTable({
            "lengthMenu": [[5, 10, 15, -1], [5, 10, 15, "All"]]
        });
    });
</script>

<%--catch modal--%>

<script>
    function deleteById(id) {
        document.getElementById("deleteByModal").value = id;
    }
</script>

</html>
