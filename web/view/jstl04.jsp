<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="i" begin="1" end="5" step="1">
  <font size="${i}">야호~~</font><br>
</c:forEach>
</body>
</html>
