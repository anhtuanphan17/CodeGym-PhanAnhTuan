<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/24/2022
  Time: 8:10 PM
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
<center>
    <h1>Sach Management</h1>
    <h2>
        <a href="/sach">List Sach</a>
    </h2>
</center>

<div>
    <form method="post" action="sach?&action=muon">

        <caption><h2>Muon Sach</h2></caption>

        <table>

            <c:if test="${sach!=null}">
                <input type="hidden" name="sachId" value="${sach.getSachId()}"/>
            </c:if>
            <tr>
                <th> Ma Sach </th>
                <td>
                    <input type="text" name="tenSach" value="${sach.getMaSach()}" size="45"/>
                </td>
            </tr>

            <tr>
                <th> Ten Sach </th>
                <td>
                    <input type="text" name="tenSach" value="${sach.getTenSach()}" size="45"/>
                </td>
            </tr>

            <tr>
            <th>Ten Hoc Sinh</th>
            <td>
                <input type="text" name="tenHocSinh"  size="45"/>
            </td>
            </tr>

            <tr>
                <th>Ngay Muon Sach </th>
                <td>
                    <input type="text" name="ngayMuonSach" size="45"/>
                </td>
            </tr>

<%--            <tr>--%>
<%--                <th>Color</th>--%>
<%--                <td>--%>
<%--                    <select name="color">--%>
<%--                        <c:forEach var="color" items="${colorList}">--%>
<%--                            <option value="${color.getColorId()}" ${color.getColorId()==product.getColorId().getColorId()?"selected":""}>${color.getColorName()}</option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>
<%--                </td>--%>
<%--            </tr>--%>

<%--            <tr>--%>
<%--                <th>Category </th>--%>
<%--                <td>--%>
<%--                    <select name="category">--%>
<%--                        <c:forEach var="category" items="${categoryList}">--%>
<%--                            <option value="${category.getCategoryId()}" ${category.getCategoryId()==product.getCategoryId().getCategoryId()?"selected":""}>${category.getCategoryName()}</option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>
<%--                </td>--%>
<%--            </tr>--%>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Muon"/>
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
