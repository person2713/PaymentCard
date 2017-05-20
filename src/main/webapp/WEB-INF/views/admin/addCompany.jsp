<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:choose>
        <c:when test="${edit}">
            <title>Редактировать компанию</title>
        </c:when>
        <c:otherwise>
            <title>Добавить компанию</title>
        </c:otherwise>
    </c:choose>

    <link href="/static/css/boot.css" rel="stylesheet">
    <link href="/static/css/welcome_css/colorbox.css" rel="stylesheet">
    <link href="/static/css/welcome_css/templatemo_style.css"  rel="stylesheet">


</head>

<script type="text/javascript">
    function validate() {
        var companyName = document.forms["form"]["companyName"].value;
        var compBalance = document.forms["form"]["compBalance"].value;
        var phoneNumber = document.forms["form"]["phoneNumber"].value;
        var regexBalance = /(^[0-9]+$)/;
        var regexPhone = /^[+]{1}[0-9]{1}[(]{1}[0-9]{3}[)]{1}[0-9]{7}$/;
        //Если длина имени компании равно 0
        if (companyName.length = 0) {
            document.getElementById("companyName1").innerHTML = "*Имя компании должно быть обязательно заполнено";
            return false;
        }
        if (companyName.length > 150) {
            document.getElementById("companyName1").innerHTML = "*Имя компании не должно превыщать более 150 символов";
            return false;
        }
        //Если баланс введен в неверном формате
        if (!regexBalance.test(compBalance)) {
            document.getElementById("compBalance1").innerHTML = "*Неверный формат баланса, введите баланс в формате 1000";
            return false;
        }
        //Если номер телефона введен в неверном формате
        if (!regexBalance.test(phoneNumber)) {
            document.getElementById("compBalance1").innerHTML = "*Неверный формат телефона, введите телефон в формате +7(XXX)XXXXXXX";
            return false;
        }
    }
</script>

<body style="background-color: #EDEEF0">
<div class="container">

    <c:choose>
        <c:when test="${edit}">
            <legend><h2>Редактировать компанию</h2></legend>
            <spring:url value="/admin/allCompanies/editCompany" var="userActionUrl"/>
        </c:when>
        <c:otherwise>
            <legend><h2>Добавить компанию</h2></legend>
            <spring:url value="/admin/addCompany/newCompany" var="userActionUrl"/>
        </c:otherwise>
    </c:choose>

    <form:form name="form" method="POST" modelAttribute="companyForm" onsubmit="return (validate())" action="${userActionUrl}" class="form-horizontal">
        <form:input type="hidden" path="companyId" id="companyId"/>

        <div class="form-group">
            <label class="col-md-4 control-label" for="companyName">Имя компании</label>
            <div class="col-md-4">
                <form:input type="text" path="companyName" id="companyName" class="form-control"/>
                <span style="color:red" id="companyName1"></span>
                <div class="has-error">
                    <span style="color:red">
                        <form:errors path="companyName" class="help-inline"/>
                    </span>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="phoneNumber">Телефонный номер</label>
            <div class="col-md-4">
                <form:input type="text" path="phoneNumber" id="phoneNumber" class="form-control"/>
                <span style="color:red" id="phoneNumber1"></span>
                <div class="has-error">
                    <span style="color:red">
                        <form:errors path="phoneNumber" class="help-inline"/>
                    </span>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="compBalance">Баланс компании</label>
            <div class="col-md-4">
                <form:input type="text" path="compBalance" id="compBalance" class="form-control"/>
                <span style="color:red" id="compBalance1"></span>
                <div class="has-error">
                    <span style="color:red">
                        <form:errors path="compBalance" class="help-inline"/>
                    </span>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="city">Выберите город</label>
            <div class="col-md-4">
                <form:select path="city" class="form-control">
                    <%--<form:option value="NONE" label=""/>--%>
                    <form:options items="${cities}" multiple="false" itemValue="cityId" itemLabel="cityName"/>
                <div class="has-error">
                    <span style="color:red">
                        <form:errors path="city" class="help-inline"/>
                    </span>
                </div>
                </form:select>
            </div>
        </div>


        <%--<div class="form-group">--%>
            <%--<label class="col-md-4 control-label" for="buses">Выберите автобусы</label>--%>
            <%--<div class="col-md-4">--%>
                <%--<form:select path="buses" class="form-control">--%>
                    <%--<form:option value="NONE" label=""/>--%>
                    <%--<form:options items="${buses}" multiple="true" itemValue="busId" itemLabel="busNumber"/>--%>
                    <%--<div class="has-error">--%>
                        <%--<form:errors path="buses" class="help-inline"/>--%>
                    <%--</div>--%>
                <%--</form:select>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="form-group">--%>
            <%--<label class="col-md-4 control-label" for="drivers">Выберите водителей</label>--%>
            <%--<div class="col-md-4">--%>
                <%--<form:select path="drivers" class="form-control">--%>
                    <%--<form:option value="NONE" label=""/>--%>
                    <%--<form:options items="${drivers}" multiple="true" itemValue="driverId" itemLabel="person.nickname"/>--%>
                    <%--<div class="has-error">--%>
                        <%--<form:errors path="drivers" class="help-inline"/>--%>
                    <%--</div>--%>
                <%--</form:select>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="form-group">--%>
            <%--<label class="col-md-4 control-label" for="routes">Выберите маршруты</label>--%>
            <%--<div class="col-md-4">--%>
                <%--<form:select path="routes" class="form-control">--%>
                    <%--<form:option value="NONE" label=""/>--%>
                    <%--<form:options items="${routes}" multiple="true" itemValue="routeId" itemLabel="routeNumber"/>--%>
                    <%--<div class="has-error">--%>
                        <%--<form:errors path="routes" class="help-inline"/>--%>
                    <%--</div>--%>
                <%--</form:select>--%>
            <%--</div>--%>
        <%--</div>--%>


        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <c:choose>
                    <c:when test="${edit}">
                        <div class="col-md-6">
                            <div class="text-center">
                                <input type="submit" value="Редактировать"  class="btn btn-success" onClick="return validate();" style="width: 100%"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="text-center">
                                <a href="/admin/allCompanies" class="btn btn-orange" style="width: 100%">Отмена</a>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="col-md-6">
                            <div class="text-center">
                                <input type="submit" value="Добавить" class="btn btn-success" onClick="return validate();" style="width: 100%"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="text-center">
                                <a href="/admin" class="btn btn-orange" style="width: 100%">Отмена</a>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

        <%--<div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Редактировать" class="btn btn-success"/>
                        <a href="/admin/allCompanies" class="forgot-password" style="padding-left: 27%">Отмена</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Добавить" class="btn btn-success"/>
                        <a href="/admin/allCompanies" class="forgot-password" style="padding-left: 27%">Отмена</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>--%>
    </form:form>

    <div class="navbar navbar-inner  navbar-fixed-bottom">
        <p>
        <center class="text-muted">© Netcracker Education Center 2017</center>
        </p>
    </div>
</div>
</body>
</html>
