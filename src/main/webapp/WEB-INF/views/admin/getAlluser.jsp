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
    <title>Users List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body class="prokrutka">
<div class="generic-container">
    <%--<%@include file="authheader.jsp" %>--%>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Users </span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Id</th>
                <th>Nickname</th>
                <%--<th>Password</th>--%>
                <th>First name</th>
                <th>Last name</th>
                <th>city name</th>
                <th>mobile number</th>
                <th>email</th>
                <th>role</th>
                <%--<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">--%>
                    <%--<th width="100"></th>--%>
                <%--</sec:authorize>--%>
                <%--<sec:authorize access="hasRole('ADMIN')">--%>
                    <%--<th width="100"></th>--%>
                <%--</sec:authorize>--%>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${persons}" var="persons">
                <tr>
                    <td>${persons.personId}</td>
                    <td>${persons.nickname}</td>
                    <%--<td>${persons.password}</td>--%>
                    <td>${persons.firstName}</td>
                    <td>${persons.lastName}</td>
                    <td>${persons.city.getCityName()}</td>
                    <td>${persons.mobileNumber}</td>
                    <td>${persons.email}</td>
                    <td>${persons.role.roleType}</td>
                <%--<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">--%>
                        <%--<td><a href="<c:url value='/edit-user-${user.ssoId}' />" class="btn btn-success custom-width">edit</a></td>--%>
                    <%--</sec:authorize>--%>
                    <%--<sec:authorize access="hasRole('ADMIN')">--%>
                        <%--<td><a href="<c:url value='/delete-user-${user.ssoId}' />" class="btn btn-danger custom-width">delete</a></td>--%>
                    <%--</sec:authorize>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%--<sec:authorize access="hasRole('ADMIN')">--%>
        <%--<div class="well">--%>
            <%--<a href="<c:url value='/newuser' />">Add New User</a>--%>
        <%--</div>--%>
    <%--</sec:authorize>--%>
</div>
</body>
</html>