<%@ page import="com.glowsoft.spring_test.model.MemberDAO" %>
<%@ page import="com.glowsoft.spring_test.model.MemberVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
//  ArrayList<MemberVO> list=(ArrayList<MemberVO>)request.getAttribute("list");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Title</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
    function deleteFn(num) {
      location.href="/memberDelete.do?num="+num;
    }
</script>
</head>
[MVC03 예제-Controller+View(JSTL+EL)]
<body>
<table class="table table-bordered">
<tr>
<td>번호</td>
<td>아이디</td>
<td>비밀번호</td>
<td>이름</td>
<td>나이</td>
<td>이메일</td>
<td>전화번호</td>
<td>삭제</td>
</tr>
<%--<% for(MemberVO vo : list ) { %>--%>
    <c:forEach var="vo" items="${list}">
    <tr>
<%--      <td><%=vo.getNum()%></td>--%>
    <td>${vo.num}</td>
<%--      <td><a href="/memberContent.do?num=<%=vo.getNum()%>"><%=vo.getId()%></a></td>--%>
    <td><a href="/memberContent.do?num=${vo.num}">${vo.id}</a></td>
<%--      <td><%=vo.getPass()%></td>--%>
    <td>${vo.pass}</td>
<%--      <td><%=vo.getName()%></td>--%>
    <td>${vo.name}</td>
<%--      <td><%=vo.getAge()%></td>--%>
    <td>${vo.age}</td>
<%--      <td><%=vo.getEmail()%></td>--%>
    <td>${vo.email}</td>
<%--      <td><%=vo.getPhone()%></td>--%>
    <td>${vo.phone}</td>
<%--      <td><input type = "button" value="삭제" class="btn btn-warning" onclick="deleteFn(<%=vo.getNum()%>)"></td>--%>
    <td><input type = "button" value="삭제" class="btn btn-warning" onclick="deleteFn(${vo.num})"></td>
    </tr>
    </c:forEach>
<%-- <% } %>--%>
  <tr>
    <td colspan="8" align="right"><input value="회원가입" type="button" class="btn btn-primary" onclick="location.href='/member/memberRegister.jsp'"/></td>
  </tr>
</table>
</body>
</html>
