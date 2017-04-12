<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome page</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
</head>
    <body>
        <div class="generic-container">
            <div class="well lead">${greeting} </div>
            <div class="row">
                <a href="<c:url value="/login" />">Sign in</a>
            </div>
            <div class="row">
                <div class="form-actions">
                <a href="<c:url value="/registration" />">Sign up</a>
                </div>
            </div>
        </div>
    </body>
</html>