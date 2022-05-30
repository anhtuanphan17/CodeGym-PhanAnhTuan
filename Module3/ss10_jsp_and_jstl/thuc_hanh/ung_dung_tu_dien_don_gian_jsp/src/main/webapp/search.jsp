<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/10/2022
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
Map<String,String> map = new HashMap<>();
%>

<%
    map.put("Hello","Xin chào");
    map.put("Book","Quyển sách");
    map.put("table","bàn");

    String search = request.getParameter("search");
    String result = map.get(search);

    if(result!=null){
        out.println("word: "+search);
        out.println("result: "+ result);
    }else{
        out.println("not found");
    }


%>



</body>
</html>
