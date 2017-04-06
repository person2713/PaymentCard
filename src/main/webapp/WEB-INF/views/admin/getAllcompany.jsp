<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>--%>

<html>

<style>
    .prokrutka{
        overflow: auto;
    }
</style>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Company list</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body class="prokrutka">
<div class="generic-container">
    <%--<%@include file="authheader.jsp" %>--%>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of company </span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Id</th>
                <th>CompanyName</th>
                <th>Phone number</th>
                <th>City name</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${companies}" var="companies">
                <tr>
                    <td>${companies.companyId}</td>
                    <td>${companies.companyName}</td>
                    <td>${companies.phoneNumber}</td>
                    <td>${companies.getCityName()}</td>
                    <td><a href="<c:url value='/edit-company-${companies.companyName}' />" class="btn btn-success custom-width">edit</a></td>
                    <%--<td><a href="<c:url value='/delete-user-${user.ssoId}' />" class="btn btn-danger custom-width">delete</a></td>--%>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    </div>
</body>
</html>