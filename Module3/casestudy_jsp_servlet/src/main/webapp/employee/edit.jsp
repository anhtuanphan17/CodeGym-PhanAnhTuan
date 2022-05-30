<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/22/2022
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Form</title>
</head>
<body>
<%--hiển thị tiêu đề của trang--%>
<center>
    <h1>Employee Management</h1>
    <h2>
        <a href="/employee">List Employee</a>
    </h2>
</center>

<%--hiển thị form chỉnh sửa--%>

<div>
    <form method="post" action="employee?&action=edit">
        <table>
            <caption>
                <h2>Edit Employee</h2>
            </caption>
            <c:if test="${employee!=null}">
                <input type="hidden" name="employeeId" value="${employee.getEmployeeId()}"/>
            </c:if>
            <tr>
                <th>Employee Name</th>
                <td>
                    <input type="text" name="employeeName" value="${employee.getEmployeeName()}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Birthday</th>
                <td>
                    <input type="text" name="employeeBirthday" value="${employee.getEmployeeBirthday()}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Id Card</th>
                <td>
                    <input type="text" name="employeeIdCard" value="${employee.getEmployeeIdCard()}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Salary</th>
                <td>
                    <input type="text" name="employeeSalary" value="${employee.getEmployeeSalary()}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Phone</th>
                <td>
                    <input type="text" name="employeePhone" value="${employee.getEmployeePhone()}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Email</th>
                <td>
                    <input required maxlength="100" minlength="50" pattern="^/d$" type="text" name="employeeEmail" value="${employee.getEmployeeEmail()}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Address</th>
                <td>
                    <input type="text" name="employeeAddress" value="${employee.getEmployeeAddress()}" size="45"/>
                </td>
            </tr>

            <tr>
                <th>Position</th>
                <td>
                    <select name="positionName">
                        <c:forEach var="position" items="${positionList}">
                            <option value="${position.getPositionId()}" ${position.getPositionId()==employee.getPositionId().getPositionId()?"selected":""}>${position.getPositionName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <th>Education Degree</th>
                <td>
                    <select name="educationDegreeName">
                        <c:forEach var="educationDegree" items="${educationDegreeList}">
                            <option value="${educationDegree.getEducationDegreeId()}" ${educationDegree.getEducationDegreeId()==employee.getEducationDegreeId().getEducationDegreeId()?"selected":""}>${educationDegree.getEducationDegreeName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <th>Division</th>
                <td>
                    <select name="divisionName">
                        <c:forEach var="division" items="${divisionList}">
                            <option value="${division.getDivisionId()}" ${division.getDivisionId()==employee.getDivisionId().getDivisionId()?"selected":""}>${division.getDivisionName()}</option>
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
