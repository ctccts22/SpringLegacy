<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String[] str={"사과", "바나나", "포도", "귤", "오렌지"};
  request.setAttribute("str", str);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="fruits" items="${str}">
  ${fruits}<br>
</c:forEach>
</body>
</html>
