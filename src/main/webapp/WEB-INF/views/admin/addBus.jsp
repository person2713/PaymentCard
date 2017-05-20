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
            <title>Редактировать автобус</title>
        </c:when>
        <c:otherwise>
            <title>Добавить автобус</title>
        </c:otherwise>
    </c:choose>
    <link href="/static/css/boot.css" rel="stylesheet">
    <link href="/static/css/welcome_css/colorbox.css" rel="stylesheet">
    <link href="/static/css/welcome_css/templatemo_style.css" rel="stylesheet">


</head>

<script type="text/javascript">
    function validate() {
        //Считаем значения из полей name и email в переменные x и y
        var busNumber = document.forms["form"]["busNumber"].value;
        var regex = /^[А-Я]{1}[0-9]{3}[А-Я]{2}$/;
        //Если поле name пустое выведем сообщение и предотвратим отправку формы
        if (busNumber.length == 0) {
            document.getElementById("busNumber1").innerHTML = "*Данное поле обязательно для заполнения";
            return false;
        }
        //Если длина вводимых значений больше 6 символов
        if (busNumber.length > 6) {
            document.getElementById("busNumber1").innerHTML = "*Номер автобуса должен состоять из 6 символов";
            return false;
        }
        //Если номер автобуса введен в неверном формате
        if (!regex.test(busNumber)) {
            document.getElementById("busNumber1").innerHTML = "*Номер автобуса введен в нeверном формате. Введите в следующем формате А123ИР";
            return false;
        }


    }
</script>

<body style="background-color: #EDEEF0">
<div class="container">

    <c:choose>
        <c:when test="${edit}">
            <legend><h2>Редактировать автобус</h2></legend>
            <spring:url value="/admin/allBuses/editBus" var="userActionUrl"/>
        </c:when>
        <c:otherwise>
            <legend><h2>Добавить автобус</h2></legend>
            <spring:url value="/admin/addBus/newBus" var="userActionUrl"/>
        </c:otherwise>
    </c:choose>

    <form:form name="form" method="POST" modelAttribute="busForm" onsubmit="return (validate())" action="${userActionUrl}" class="form-horizontal">
        <form:input type="hidden" path="busId" id="busId"/>


        <div class="form-group">
            <label class="col-md-4 control-label" for="busNumber">Номер автобуса</label>
            <div class="col-md-4">
                <form:input type="text" path="busNumber" id="busNumber" name="busNumber" class="form-control"/>
                <span style="color:red" id="busNumber1"></span>
                <div class="has-error">
                    <span style="color:red">
                        <form:errors path="busNumber" class="help-inline"/>
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
                                <input type="submit" value="Редактировать" class="btn btn-success" onClick="return validate();" style="width: 100%"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="text-center">
                                <a href="/admin/allBuses" class="btn btn-orange" style="width: 100%">Отмена</a>
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
    </form:form>
    <div class="navbar navbar-inner  navbar-fixed-bottom">
        <p>
        <center class="text-muted">© Netcracker Education Center 2017</center>
        </p>
    </div>
</div>
</body>
</html>