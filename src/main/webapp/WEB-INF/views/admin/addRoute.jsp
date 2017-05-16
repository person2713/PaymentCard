<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <c:choose>
        <c:when test="${edit}">
            <title>Редактировать маршрут</title>
        </c:when>
        <c:otherwise>
            <title>Добавить маршрут</title>
        </c:otherwise>
    </c:choose>


    <link href="/static/css/boot.css" rel="stylesheet">
    <link href="/static/css/welcome_css/colorbox.css" rel="stylesheet">
    <link href="/static/css/welcome_css/templatemo_style.css"  rel="stylesheet">


</head>

<body style="background-color: #EDEEF0">
<div class="container">

    <c:choose>
        <c:when test="${edit}">
            <legend><h2>Редактировать маршрут</h2></legend>
            <spring:url value="/admin/allRoutes/editRoute" var="userActionUrl"/>
        </c:when>
        <c:otherwise>
            <legend><h2>Добавить маршрут</h2></legend>
            <spring:url value="/admin/addRoute/newRoute" var="userActionUrl"/>
        </c:otherwise>
    </c:choose>

    <form:form method="POST" modelAttribute="routeForm" action="${userActionUrl}" class="form-horizontal">
        <form:input type="hidden" path="routeId" id="routeId"/>

        <div class="form-group">
            <label class="col-md-4 control-label" for="routeNumber">Номер маршрута</label>
            <div class="col-md-4">
                <form:input type="text" path="routeNumber" id="routeNumber" class="form-control"/>
                <div class="has-error">
                    <form:errors path="routeNumber" class="help-inline"/>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="routePrice">Стоимость проезда</label>
            <div class="col-md-4">
                <form:input type="text" path="routePrice" id="routePrice" class="form-control"/>
                <div class="has-error">
                    <form:errors path="routePrice" class="help-inline"/>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="companyId">Выберите компанию</label>
            <div class="col-md-4">
                <form:select path="companyId" class="form-control">
                    <%--<form:option value="NONE" label=""/>--%>
                    <form:options items="${companies}" multiple="false" itemValue="companyId" itemLabel="companyName"/>
                    <div class="has-error">
                        <form:errors path="companyId" class="help-inline"/>
                    </div>
                </form:select>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Редактировать" class="btn btn-success"/>
                        <a href="/admin/allRoutes" class="forgot-password" style="padding-left: 27%">Отмена</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Добавить" class="btn btn-success"/>
                        <a href="/admin/allRoutes" class="forgot-password" style="padding-left: 27%">Отмена</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
    <div class="navbar navbar-inner  navbar-fixed-bottom">
        <p>
        <center class="text-muted">© NetCracker Education Center 2017</center>
        </p>
    </div>
</div>
</body>
</html>