<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/23/2022
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>search file</title>

</head>
<body>
<jsp:include page="/include/header.jsp"></jsp:include>
<table border="1" cellpadding="5">
    <caption><h2>List Of Employee</h2></caption>
    <tr>
        <th>Employee ID</th>
        <th>Employee Name</th>
        <th>Employee Birthday</th>
        <th>Employee ID Card</th>
        <th>Employee Salary</th>
        <th>Employee Phone</th>
        <th>Employee Email</th>
        <th>Employee Address</th>
        <th>Position Id</th>
        <th>Education Degree Id</th>
        <th>Division Id</th>

    </tr>
    <c:forEach var="employee" items="${employeeList}">
        <tr>
            <td><c:out value="${employee.getEmployeeId()}"/></td>
            <td><c:out value="${employee.getEmployeeName()}"/></td>
            <td><c:out value="${employee.getEmployeeBirthday()}"/></td>
            <td><c:out value="${employee.getEmployeeIdCard()}"/></td>
            <td><c:out value="${employee.getEmployeeSalary()}"/></td>
            <td><c:out value="${employee.getEmployeePhone()}"/></td>
            <td><c:out value="${employee.getEmployeeEmail()}"/></td>
            <td><c:out value="${employee.getEmployeeAddress()}"/></td>
            <td><c:out value="${employee.getPositionId().getPositionName()}"/></td>
            <td><c:out value="${employee.getEducationDegreeId().getEducationDegreeName()}"/></td>
            <td><c:out value="${employee.getDivisionId().getDivisionName()}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
<jsp:include page="/include/boostrap.jsp"></jsp:include>
</html>
