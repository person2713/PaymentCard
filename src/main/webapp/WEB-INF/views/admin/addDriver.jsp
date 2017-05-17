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
            <title>Редактировать водителя</title>
        </c:when>
        <c:otherwise>
            <title>Добавить водителя</title>
        </c:otherwise>
    </c:choose>
    <link href="/static/css/boot.css" rel="stylesheet">
    <link href="/static/css/welcome_css/colorbox.css" rel="stylesheet">
    <link href="/static/css/welcome_css/templatemo_style.css"  rel="stylesheet">


</head>

<body>
<div class="container">

    <c:choose>
        <c:when test="${edit}">
            <legend><h2>Редактировать вадителя</h2></legend>
            <spring:url value="/admin/allDrivers/editDriver" var="userActionUrl"/>
        </c:when>
        <c:otherwise>
            <legend><h2>Добавить владельца</h2></legend>
            <spring:url value="/admin/addDriver/newDriver" var="userActionUrl"/>
        </c:otherwise>
    </c:choose>

    <form:form method="POST" modelAttribute="driverForm" action="${userActionUrl}" class="form-horizontal">
        <form:input type="hidden" path="driverId" id="driverId"/>

        <form:input type="hidden" path="person.personId" id="person.personId"/>

        <div class="form-group">
            <label class="col-md-4 control-label" for="person.nickname">Никнейм</label>
            <div class="col-md-4">
                <form:input type="text" path="person.nickname" id="person.nickname" class="form-control"/>
                <div class="has-error">
                    <form:errors path="person.nickname" class="help-inline"/>
                </div>
            </div>
        </div>

        <c:choose>
            <c:when test="${edit}">
                <div class="form-group" style="display: none">
                    <label class="col-md-4 control-label" for="person.password">Пароль</label>
                    <div class="col-md-4">
                        <form:input type="password" path="person.password" id="person.password" class="form-control"/>
                        <div class="has-error">
                            <form:errors path="person.password" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="person.password">Пароль</label>
                    <div class="col-md-4">
                        <form:input type="password" path="person.password" id="person.password" class="form-control"/>
                        <div class="has-error">
                            <form:errors path="person.password" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>

        <div class="form-group">
            <label class="col-md-4 control-label" for="person.firstName">Имя</label>
            <div class="col-md-4">
                <form:input type="text" path="person.firstName" id="person.firstName" class="form-control"/>
                <div class="has-error">
                    <form:errors path="person.firstName" class="help-inline"/>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="person.lastName">Фамилия</label>
            <div class="col-md-4">
                <form:input type="text" path="person.lastName" id="person.lastName" class="form-control"/>
                <div class="has-error">
                    <form:errors path="person.lastName" class="help-inline"/>
                </div>
            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label" for="person.mobileNumber">Номер телефона</label>
            <div class="col-md-4">
                <form:input type="text" path="person.mobileNumber" id="person.mobileNumber" class="form-control"/>
                <div class="has-error">
                    <form:errors path="person.mobileNumber" class="help-inline"/>
                </div>
            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label" for="person.email">Электронная почта</label>
            <div class="col-md-4">
                <form:input type="text" path="person.email" id="person.email" class="form-control"/>
                <div class="has-error">
                    <form:errors path="person.email" class="help-inline"/>
                </div>
            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label" for="person.city">Выберите город</label>
            <div class="col-md-4">
                <form:select path="person.city" class="form-control">
                    <%--<form:option value="NONE" label=""/>--%>
                    <form:options items="${cities}" multiple="false" itemValue="cityId" itemLabel="cityName"/>
                    <div class="has-error">
                        <form:errors path="person.city" class="help-inline"/>
                    </div>
                </form:select>
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
                        <div class="col-md-6">
                            <div class="text-center">
                                <input type="submit" value="Редактировать" class="btn btn-success" style="width: 100%"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="text-center">
                                <a href="/admin/allDrivers" class="forgot-password" style="width: 100%">Отмена</a>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="col-md-6">
                            <div class="text-center">
                                <input type="submit" value="Добавить" class="btn btn-success" style="width: 100%"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="text-center">
                                <a href="/admin/allDrivers" class="btn btn-orange" style="width: 100%">Отмена</a>
                            </div>
                        </div>
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
