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
                <form:input type="text" path="routeNumber" id="routeNumber" name="routeNumber" class="form-control"/>
                <span style="color:red" id="routeNumber1"></span>
                <div class="has-error">
                    <span style="color:red">
                        <form:errors path="routeNumber" class="help-inline"/>
                    </span>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="routePrice">Стоимость проезда</label>
            <div class="col-md-4">
                <form:input type="text" path="routePrice" id="routePrice" name="routePrice" class="form-control"/>
                <span style="color:red" id="routePrice1"></span>
                <div class="has-error">
                    <span style="color:red">
                        <form:errors path="routePrice" class="help-inline"/>
                    </span>
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
                        <span style="color:red">
                            <form:errors path="companyId" class="help-inline"/>
                        </span>
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
                                <a href="/admin/allRoutes" class="btn btn-orange" style="width: 100%">Отмена</a>
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
                                <a href="/admin" class="btn btn-orange" style="width: 100%">Отмена</a>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
    <%--<div class="navbar navbar-inner  navbar-fixed-bottom">--%>
        <%--<p>--%>
        <%--<center class="text-muted">© Netcracker Education Center 2017</center>--%>
        <%--</p>--%>
    <%--</div>--%>

    <script type="text/javascript">
        function validate() {
            var routeNumber = document.forms["form"]["routeNumber"].value;
            var routePrice = document.forms["form"]["routePrice"].value;
            var regexBalance = /(^[0-9]+$)/;
            var regexNumber = /^[0-9]{1}[0-9а-я]{1,2}([а-я]{0,1})?$/;
            //Если длина имени компании равно 0
            if (routeNumber.length == 0) {
                document.getElementById("routeNumber1").innerHTML = "*Номер маршрута должен быть обязательно заполнен";
                return false;
            }
            if (routeNumber.length > 50) {
                document.getElementById("routeNumber1").innerHTML = "*Номер маршрута не должно превыщать более 50 символов";
                return false;
            }
            if (!regexBalance.test(routePrice)) {
                document.getElementById("routePrice1").innerHTML = "*Неверный формат баланса, введите баланс в формате 1000";
                return false;
            }
            if (!regexNumber.test(routeNumber)) {
                document.getElementById("routeNumber1").innerHTML = "*Неверный формат номера маршрута, введите номер в формате 25а";
                return false;
            }
        }
    </script>
</div>
</body>
</html>