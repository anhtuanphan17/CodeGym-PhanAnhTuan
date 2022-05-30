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
<%--hiển thị title--%>
<h1>Employee Management</h1>
<h2><a href="/employee">List Employee-</a></h2>

<%--hiển thị form để người dùng điền vào--%>

<div>
    <form method="post">
        <table>
            <caption><h2>Add new employee</h2></caption>
            <tr>
                <th>Employee Name</th>
                <td>
                    <input type="text" name="employeeName" id="employeeName" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Birthday</th>
                <td>
                    <input type="text" name="employeeBirthday" id="employeeBirthday" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Id Card</th>
                <td>
                    <input type="text" name="employeeIdCard" id="employeeIdCard" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Salary</th>
                <td>
                    <input type="text" name="employeeSalary" id="employeeSalary" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Phone</th>
                <td>
                    <input type="text" name="employeePhone" id="employeePhone" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Email</th>
                <td>
                    <input type="text" name="employeeEmail" id="employeeEmail" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Address</th>
                <td>
                    <input type="text" name="employeeAddress" id="employeeAddress" size="45"/>
                </td>
            </tr>

            <tr>
                <th>Position</th>
                <td>
                    <select name="positionName">
                        <c:forEach var="position" items="${positionList}">
                            <option value="${position.getPositionId()}">${position.getPositionName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <th>Education Degree</th>
                <td>
                    <select name="educationDegreeName">
                        <c:forEach var="educationDegree" items="${educationDegreeList}">
                            <option value="${educationDegree.getEducationDegreeId()}">${educationDegree.getEducationDegreeName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <th>Division</th>
                <td>
                    <select name="divisionName">
                        <c:forEach var="division" items="${divisionList}">
                            <option value="${division.getDivisionId()}">${division.getDivisionName()}</option>
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
