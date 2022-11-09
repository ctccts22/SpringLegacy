<%--
  Created by IntelliJ IDEA.
  User: gyunolee
  Date: 2022/11/02
  Time: 8:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <title>Title</title>
  <title>Title</title>
</head>
<body>
login view
<form action="/memberInsert.do" method="post">
  <table class="table table-bordered">
    <tr>
      <td>아이디</td>
      <td><input type="text" name="id"/></td>
    </tr>
    <tr>
      <td>패스워드</td>
      <td><input type="password" name="pass"/></td>
      <td></td>
    </tr>
    <tr>
      <td>이름</td>
      <td><input type="text" name="name"/></td>
      <td></td>
    </tr>
    <tr>
      <td>나이</td>
      <td><input type="text" name="age"/></td>
      <td></td>
    </tr>
    <tr>
      <td>이메일</td>
      <td><input type="text" name="email"/></td>
      <td></td>
    </tr>
    <tr>
      <td>전화번호</td>
      <td><input type="text" name="phone"/></td>
      <td></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="가입" class="btn btn-primary"/>
        <input type="reset" value="취소" class="btn btn-warning"/>
      </td>
    </tr>
  </table>
</form>
</body>
</html>
