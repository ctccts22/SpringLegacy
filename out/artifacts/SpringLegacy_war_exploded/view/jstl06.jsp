<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  List<String> list=new ArrayList<String>();
  list.add("Python");
  list.add("Java");
  list.add("Node.js");
  list.add("C++");
  list.add("JQuery");
  request.setAttribute("list", list);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="sw" items="${list}">
  ${sw}<br>
</c:forEach>
</body>
</html>
