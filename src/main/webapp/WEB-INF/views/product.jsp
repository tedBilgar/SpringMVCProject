<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 09.08.2018
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<table border="1" cellpadding="5">
    <caption><h2>List of products</h2></caption>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Weight</th>
    </tr>
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.weight}</td>
</table>
</body>
</html>
