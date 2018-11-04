<%--
  Created by IntelliJ IDEA.
  User: chenlin
  Date: 2018.9.21
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/GetParmServlet" method="get">
    用户名：<input type="text" name="username"/>
    <input type="submit">
</form>
</body>
</html>
