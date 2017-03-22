<%--
  Created by IntelliJ IDEA.
  User: vit
  Date: 17.03.2017
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>University Enrollments</title>

    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>

</head>


<body>
<h2>List of Cities</h2>
<table>
    <tr>
        <td>NAME</td>
    </tr>
    <c:forEach items="${itiesEntities}" var="city">
        <tr>
            <td>${city.cityName}</td>

            <td><a href="<c:url value='/edit-${city.cityName}-citiesEntities' />">${city.cityName}</a></td>
            <td><a href="<c:url value='/delete-${city.cityName}-citiesEntities' />">delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="<c:url value='/new' />">Add New City</a>
</body>
</html>