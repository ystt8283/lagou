<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>List All</h2>

<table>
    <tr>
        <td>id</td>
        <td>address</td>
        <td>name</td>
        <td>phone</td>
    </tr>

    <c:forEach items="${listAll }" var="resume">
        <tr>
            <td>${resume.id}</td>
            <td>${resume.address}</td>
            <td>${resume.name}</td>
            <td>${resume.phone}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
