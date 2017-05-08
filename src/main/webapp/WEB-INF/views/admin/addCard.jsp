<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>

    <link href="/static/css/boot.css" rel="stylesheet">


</head>

<body>
<div class="container">


    <legend><h2>Добавить карточку</h2></legend>


    <form:form method="POST" modelAttribute="cardForm" action="/admin/addCard/newCard" class="form-horizontal">
        <form:input type="hidden" path="cardId" id="cardId"/>


        <div class="form-group">
            <label class="col-md-4 control-label" for="cardName">Имя карты</label>
            <div class="col-md-4">
                <form:input type="text" path="cardName" id="cardName" class="form-control"/>
                <div class="has-error">
                    <form:errors path="cardName" class="help-inline"/>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="cardKey">Ключ карты</label>
            <div class="col-md-4">
                <form:input type="text" path="cardKey" id="cardKey" class="form-control"/>
                <div class="has-error">
                    <form:errors path="cardKey" class="help-inline"/>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="personId">Выберите пользователя</label>
            <div class="col-md-4">
                <form:select path="personId" items="${persons}" multiple="false" itemValue="personId" itemLabel="nickname"
                             class="form-control"/>
                <div class="has-error">
                    <form:errors path="personId" class="help-inline"/>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <input type="submit" value="Добавить" class="btn btn-success"/>
                <a href="/admin" class="forgot-password" style="padding-left: 27%">Отмена</a>
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