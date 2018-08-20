<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 11.08.2018
  Time: 0:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products managment</title>
</head>
<body>
<style>
    .horizontal-line {
        width: 1000px;
        border: 1px solid green;
        height: 0
    }
    </style>
    <h1>Product List</h1>
    <!-- FOR EXAMPLE-->
    <div>
        <sec:authorize access="isAuthenticated()">AUTH</sec:authorize>
        <sec:authorize access="isAnonymous()">NOT AUTH</sec:authorize>
    </div>
    <!-- -->

<table>
        <table border="1" cellpadding="5">
            <caption><h2>List of ALL products</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Weight</th>
                <sec:authorize access="hasAuthority('ADMIN')" ><th>Update</th></sec:authorize>
                <sec:authorize access="hasAuthority('ADMIN')" ><th>Delete</th></sec:authorize>
            </tr>
            <c:forEach var="product" items="${listOfProducts}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.weight}</td>
                    <sec:authorize access="hasAuthority('ADMIN')"><td><a href="<c:url value='/update/${product.id}'/>">Update</a></td></sec:authorize>
                    <sec:authorize access="hasAuthority('ADMIN')"><td><a href="<c:url value='/delete/${product.id}'/>">Delete</a></td></sec:authorize>
                </tr>
            </c:forEach>
        </table>
    </table>
    <br><br>
    <div class="horizontal-line"></div>
    <table>
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
    </table>
<br><br>
<div class="horizontal-line"></div>
<div>
    <sec:authorize access="hasAuthority('ADMIN')">
        <div>
            <h1>Product adding</h1>
            <form:form action="/add" modelAttribute="product">
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
                <form:input path="name"/>
                <br><br>
                <form:label path="price">
                    <spring:message text="Price"/>
                </form:label>
                <form:input path="price"/>
                <br><br>
                <form:label path="weight">
                    <spring:message text="Weight"/>
                </form:label>
                <form:input path="weight"/>
                <br><br>

                <input type="submit" value="submit">
            </form:form>
        </div>
    </sec:authorize>
    <div class="horizontal-line"></div>
    <div>
        <h1>Select Products</h1>
        <form:form action="/select" modelAttribute="select">
            <form:label path="sum">
                <spring:message text="Sum"/>
            </form:label>
            <form:input path="sum"/>
            <br><br>
            <form:label path="selectWeight">
                <spring:message text="Weight"/>
            </form:label>
            <form:input path="selectWeight"/>
            <br><br>

            <input type="submit" value="submit">
        </form:form>
    </div>
</div>
</body>
</html>
