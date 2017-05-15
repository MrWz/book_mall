<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户信息列表</title>
</head>
<body>
<h2>用户信息列表</h2>
<c:if test="${!empty userList}">
    <c:forEach var="user" items="${userList}">
        姓名：${user.name} <br>
    </c:forEach>
</c:if>
</body>
</html>
