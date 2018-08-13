<%--
  Created by IntelliJ IDEA.
  User: s_user05
  Date: 13.08.2018
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="/processLogin" method="post">
        <h2>Please sign in</h2>
        <input type="text"  name="username" placeholder="username">
        <input type="password" name="password" placeholder="Password">
        <button type="submit">Войти</button>
    </form>
</body>
</html>
