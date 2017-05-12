<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>

    <%--<link href="/static/css/boot.css" rel="stylesheet">--%>
    <link href="/static/css/welcome_css/bootstrap.css" rel="stylesheet">
    <%--<link href="/static/css/login_css/login.css" rel="stylesheet">--%>
    <link href="/static/css/welcome_css/templatemo_style.css"  rel="stylesheet">
    <link href="/static/css/welcome_css/colorbox.css" rel="stylesheet">
    <link href="/static/images/favicon%20(3).ico" rel="shortcut icon" type="image/x-icon" />


</head>

<body>
<div class="container">


    <c:choose>
        <c:when test="${flag}">
            <legend><h2>Добавить пользователя</h2></legend>
        </c:when>
        <c:otherwise>
            <legend><h2>Регистрация</h2></legend>
        </c:otherwise>
    </c:choose>

    <form:form method="POST" modelAttribute="userForm" action="/registration/newUser" class="form-horizontal">
        <form:input type="hidden" path="personId" id="personId"/>

        <div class="form-group">
            <label class="col-md-4 control-label" for="nickname">Никнейм</label>
            <div class="col-md-4">
                <c:choose>
                    <c:when test="${edit}">
                        <form:input type="text" path="nickname" id="nickname" class="form-control"/>
                    </c:when>
                    <c:otherwise>
                        <form:input type="text" path="nickname" id="nickname" class="form-control"/>
                        <div class="has-error">
                            <form:errors path="nickname" class="help-inline"/>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Пароль</label>
            <div class="col-md-4">
                <form:input type="password" path="password" id="password" class="form-control"/>
                <div class="has-error">
                    <form:errors path="password" class="help-inline"/>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="firstName">Имя</label>
            <div class="col-md-4">
                <form:input type="text" path="firstName" id="firstName" class="form-control"/>
                <div class="has-error">
                    <form:errors path="firstName" class="help-inline"/>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="lastName">Фамилия</label>
            <div class="col-md-4">
                <form:input type="text" path="lastName" id="lastName" class="form-control"/>
                <div class="has-error">
                    <form:errors path="lastName" class="help-inline"/>
                </div>
            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label" for="mobileNumber">Номер телефона</label>
            <div class="col-md-4">
                <form:input type="text" path="mobileNumber" id="mobileNumber" class="form-control"/>
                <div class="has-error">
                    <form:errors path="mobileNumber" class="help-inline"/>
                </div>
            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label" for="email">Электронная почта</label>
            <div class="col-md-4">
                <form:input type="text" path="email" id="email" class="form-control"/>
                <div class="has-error">
                    <form:errors path="email" class="help-inline"/>
                </div>
            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label" for="city">Выберите город</label>
            <div class="col-md-4">
                <form:select path="city" class="form-control">
                    <form:option value="NONE" label=""/>
                    <form:options items="${cities}" multiple="false" itemValue="cityId" itemLabel="cityName"/>
                    <div class="has-error">
                        <form:errors path="city" class="help-inline"/>
                    </div>
                </form:select>
            </div>
        </div>


        <sec:authorize access="hasRole('ADMIN')">
            <div class="row">

                <div class="form-group">
                    <label class="col-md-4 control-label" for="Role">Role</label>
                    <div class="col-md-4">
                        <form:select path="role" id="role" class="form-control">
                            <form:option value="NONE" label=""/>
                            <form:options items="${rollers}" multiple="false" itemValue="roleId"
                                          itemLabel="roleType"/>
                            <div class="has-error">
                                <form:errors path="role" class="help-inline"/>
                            </div>
                        </form:select>
                    </div>
                </div>
            </div>


            <div style='display:none;' id='business'>Business Name<br/>&nbsp;
                <br/>&nbsp;
                <input type='text' class='text' name='business' value size='20'/>
                <br/>
            </div>

        </sec:authorize>

        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <c:choose>
                    <c:when test="${flag}">
                        <input type="submit" value="Добавить" class="btn btn-success"/>
                        <a href="/admin" class="forgot-password" style="padding-left: 27%">Отмена</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Зарегистрироваться" class="btn btn-success"/>
                        <a href="/welcome"  style="padding-left: 27%">Отмена</a>
                    </c:otherwise>
                </c:choose>
                    <%--<a href="/welcome" class="forgot-password" style="padding-left: 27%">Отмена</a>--%>
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