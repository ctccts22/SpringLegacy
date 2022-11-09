<%@ page import="com.glowsoft.spring_test.model.MemberVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberVO vo = (MemberVO)request.getAttribute("vo");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
Controller 에서 받은 값을 출력
이름 : <%=vo.getName()%>
나이 : <%=vo.getAge()%>
이메일 : <%=vo.getEmail()%>
</body>
</html>