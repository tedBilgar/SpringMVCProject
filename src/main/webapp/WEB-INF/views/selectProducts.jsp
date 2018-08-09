<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 09.08.2018
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>

<div>
    We select products for your wishes:
    <${select.sum} RUB<br><br>
    +-${select.selectWeight} grams<br><br>
</div>
<div>

    <form action="/product/select" method="post">
        Money cash: <input type="text" name="sum">
        Wished weight <input type="text" name="selectWeight">
        <input type="submit" value="Submit">
    </form>
    <div >
        <table border="1" cellpadding="5">
            <caption><h2>List of SELECTED products</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Weight</th>
            </tr>
            <c:forEach var="product" items="${selectProducts}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.weight}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div >
        <table border="1" cellpadding="5">
            <caption><h2>List of ALL products</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Weight</th>
            </tr>
            <c:forEach var="product" items="${allProducts}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.weight}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
