<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome page</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/reg.css' />" rel="stylesheet"/>

</head>
<body>
    <div class="container">
        <div class="header clearfix">
            <nav>
                <ul class="nav nav-pills pull-xs-right">
                    <li class="nav-item active"></li>
                    <li class="nav-item"></li>
                    <li class="nav-item"></li>
                </ul>
            </nav>
            <h3 class="text-muted"></h3>
        </div>

        <div class="jumbotron">
            <h1 class="display-3">${greeting}</h1>
            <p class="lead">Пожалуйста, авторизуйтесь или зарегистрируйтесь.</p>
            <p>
            <div class="btn-group">
                <a href="/login" class="btn btn-primary center-block">Войти</a>
                <a href="/registration" class="btn btn-primary center-block">Зарегистрироваться</a>
            </div>
            </p>
        </div>


        <div class="navbar navbar-inner navbar-fixed-bottom">
            <p><center  class="text-muted">© NetCracker Education Center 2017</center></p>
        </div>
    </div>
</body>
</html>