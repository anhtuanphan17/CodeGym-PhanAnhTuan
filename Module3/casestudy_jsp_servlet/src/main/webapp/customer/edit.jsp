<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/21/2022
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Form</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="/customers">List All Customers</a>
    </h2>
</center>
<div>
    <form method="post" action="customers?&action=edit">
        <table>
            <caption>
                <h2>Edit customer</h2>
            </caption>
            <c:if test="${customer!=null}">
                <input type="hidden" name="customerId" value="${customer.getCustomerId()}"/>
            </c:if>
            <tr>
                <th>Customer Name</th>
                <td>
                    <input type="text" name="customerName" value="${customer.getCustomerName()}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Birthday</th>
                <td>
                    <input type="text" name="customerBirthday" value="${customer.getCustomerBirthday()}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Gender</th>
                <td>
                    <input type="text" name="customerGender" value="${customer.getCustomerGender()}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Id Card</th>
                <td>
                    <input type="text" name="customerIdCard" value="${customer.getCustomerIdCard()}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Phone</th>
                <td>
                    <input type="text" name="customerPhone" value="${customer.getCustomerPhone()}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Email</th>
                <td>
                    <input type="text" name="customerEmail" value="${customer.getCustomerEmail()}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Address</th>
                <td>
                    <input type="text" name="customerAddress" value="${customer.getCustomerAddress()}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Type Name</th>
                <td>
                    <select name="customerTypeName">
                        <c:forEach var="customerType" items="${customerTypeList}">
                            <option value="${customerType.getCustomerTypeId()}" ${customerType.getCustomerTypeId()==customer.getCustomerTypeId().getCustomerTypeId()?"selected":""}>${customerType.getCustomerTypeName()}</option>
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
