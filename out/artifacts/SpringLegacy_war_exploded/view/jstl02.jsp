<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="cnt" value ="7"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${cnt%2==0}">
    짝수입니다.
</c:if>
<c:if test="${cnt%2!=0}">
    홀수입니다.
</c:if>
</body>
</html>
