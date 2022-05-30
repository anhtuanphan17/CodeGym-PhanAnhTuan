<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/20/2022
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Form</title>
</head>
<body>
<h1>Customer Management</h1>
<h2><a href="/customers">List all customers</a></h2>

<div>
    <form method="post">
        <table>
            <caption><h2>Add new customer</h2></caption>
            <tr>
                <th>Customer Name</th>
                <td>
                    <input type="text" name="customerName" id="customerName" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Birthday</th>
                <td>
                    <input type="text" name="customerBirthday" id="customerBirthday" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Gender</th>
                <td>
                    <input type="text" name="customerGender" id="customerGender" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Id Card</th>
                <td>
                    <input type="text" name="customerIdCard" id="customerIdCard" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Phone</th>
                <td>
                    <input type="text" name="customerPhone" id="customerPhone" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Email</th>
                <td>
                    <input type="text" name="customerEmail" id="customerEmail" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Address</th>
                <td>
                    <input type="text" name="customerAddress" id="customerAddress" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Type ID</th>
                <td>
                    <input type="text" name="customerTypeId" id="customerTypeId" size="45"/>
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
