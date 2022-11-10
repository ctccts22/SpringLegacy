<%@ page import="model.MemberVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String data=request.getParameter("data");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
Controller 에서 받은 값을 출력 : <%=data%>
</body>
</html>
