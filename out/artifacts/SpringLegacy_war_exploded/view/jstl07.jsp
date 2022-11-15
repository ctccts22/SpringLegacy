<%@ page import="model.MemberVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  MemberVO vo=new MemberVO();
  vo.setNum(1);
  vo.setId("bitccom");
  vo.setName("이규노");
  vo.setEmail("sksks@naver.com");
  request.setAttribute("vo", vo);
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
<tr>
  <td>번호</td>
  <td>아이디</td>
  <td>이름</td>
  <td>이메일</td>
</tr>
  <tr>
    <td>${vo.num}</td>
    <td>${vo.id}</td>
    <td>${vo.name}</td>
    <td>${vo.email}</td>
  </tr>
</table>
</body>
</html>
