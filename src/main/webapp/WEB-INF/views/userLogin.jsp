<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: s_user05
  Date: 14.08.2018
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<form:form action="/customLogin" modelAttribute="user" method="post">
    <p>
        <label for="username">Username</label>
        <form:input type="text" id="username" name="username" path="username"/>
    </p>
    <p>
        <label for="password">Password</label>
        <form:input type="password" id="password" name="password" path="password"/>
    </p>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <button type="submit">Log in</button>
</form:form>
</body>
</html>
