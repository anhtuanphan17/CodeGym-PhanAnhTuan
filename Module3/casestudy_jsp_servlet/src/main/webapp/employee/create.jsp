<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/22/2022
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Form</title>
</head>
<body>
<h1>Employee Management</h1>
<h2><a href="/employee">List Employee-</a></h2>

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
</html>
