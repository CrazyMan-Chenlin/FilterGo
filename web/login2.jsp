<%--
  Created by IntelliJ IDEA.
  User: chenlin
  Date: 2018.10.9
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginPage</title>
</head>
<body>
<font color="red">${msg}</font>
<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
    用户名：<input type="text" name="username"/><br>
    密码:<input type="text" name="password"/><br>
    <input type="submit">
</form>
</body>
</html>
