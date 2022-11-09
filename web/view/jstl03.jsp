<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="cnt" value ="7"/>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
  <c:when test="${cnt%2==0}">
    짝수입니다.
  </c:when>
  <c:when test="${cnt%2!=0}">
    홀수입니다.
  </c:when>
  <c:otherwise>
    일치하는 when 절이 없는 경우에 실행된다.
  </c:otherwise>
</c:choose>
</body>
</html>
