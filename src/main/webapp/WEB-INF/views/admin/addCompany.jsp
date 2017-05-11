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


    <legend><h2>Добавить компанию</h2></legend>


    <form:form method="POST" modelAttribute="companyForm" action="/admin/addCompany/newCompany" class="form-horizontal">
        <form:input type="hidden" path="companyId" id="companyId"/>


        <div class="form-group">
            <label class="col-md-4 control-label" for="companyName">Имя компании</label>
            <div class="col-md-4">
                <form:input type="text" path="companyName" id="companyName" class="form-control"/>
                <div class="has-error">
                    <form:errors path="companyName" class="help-inline"/>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="phoneNumber">Телефонный номер</label>
            <div class="col-md-4">
                <form:input type="text" path="phoneNumber" id="phoneNumber" class="form-control"/>
                <div class="has-error">
                    <form:errors path="phoneNumber" class="help-inline"/>
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
    <script>

    </script>
</div>
</body>
</html>
