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

<body style="background-color: #EDEEF0">
<div class="container">

    <c:choose>
        <c:when test="${edit}">
            <legend><h2>Редактировать водителя</h2></legend>
            <spring:url value="/admin/allDrivers/editDriver" var="userActionUrl"/>
        </c:when>
        <c:otherwise>
            <legend><h2>Добавить водителя</h2></legend>
            <spring:url value="/admin/addDriver/newDriver" var="userActionUrl"/>
        </c:otherwise>
    </c:choose>

    <form:form name="form" method="POST" modelAttribute="driverForm" onsubmit="return (validate())" action="${userActionUrl}" class="form-horizontal">
        <form:input type="hidden" path="driverId" id="driverId"/>

        <form:input type="hidden" path="person.personId" id="person.personId"/>

        <div class="form-group">
            <label class="col-md-4 control-label" for="person.nickname">Никнейм</label>
            <div class="col-md-4">
                <form:input type="text" path="person.nickname" id="person.nickname" name="person.nickname" class="form-control"/>
                <span style="color:red" id="person.nickname1"></span>
                <div class="has-error">
                    <span style="color:red">
                        <form:errors path="person.nickname" class="help-inline"/>
                    </span>
                </div>
            </div>
        </div>

        <c:choose>
            <c:when test="${edit}">
                <div class="form-group" style="display: none">
                    <label class="col-md-4 control-label" for="person.password">Пароль</label>
                    <div class="col-md-4">
                        <form:input type="password" path="person.password" id="person.password" name="person.password" class="form-control"/>
                        <span style="color:red" id="person.password1"></span>
                        <div class="has-error">
                            <span style="color:red">
                                <form:errors path="person.password" class="help-inline"/>
                            </span>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="person.password">Пароль</label>
                    <div class="col-md-4">
                        <form:input type="password" path="person.password" id="person.password" name="person.password" class="form-control"/>
                        <span style="color:red" id="person.password1"></span>
                        <div class="has-error">
                            <span style="color:red">
                                <form:errors path="person.password" class="help-inline"/>
                            </span>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>

        <div class="form-group">
            <label class="col-md-4 control-label" for="person.firstName">Имя</label>
            <div class="col-md-4">
                <form:input type="text" path="person.firstName" id="person.firstName" name="person.firstName" class="form-control"/>
                <span style="color:red" id="person.firstName1"></span>
                <div class="has-error">
                    <span style="color:red">
                        <form:errors path="person.firstName" class="help-inline"/>
                    </span>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="person.lastName">Фамилия</label>
            <div class="col-md-4">
                <form:input type="text" path="person.lastName" id="person.lastName" name="person.lastName" class="form-control"/>
                <span style="color:red" id="person.lastName1"></span>
                <div class="has-error">
                    <span style="color:red">
                        <form:errors path="person.lastName" class="help-inline"/>
                    </span>
                </div>
            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label" for="person.mobileNumber">Номер телефона</label>
            <div class="col-md-4">
                <form:input type="text" path="person.mobileNumber" id="person.mobileNumber" name="person.mobileNumber" class="form-control"/>
                <span style="color:red" id="person.mobileNumber1"></span>
                <div class="has-error">
                    <span style="color:red">
                        <form:errors path="person.mobileNumber" class="help-inline"/>
                    </span>
                </div>
            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label" for="person.email">Электронная почта</label>
            <div class="col-md-4">
                <form:input type="text" path="person.email" id="person.email" name="person.email" class="form-control"/>
                <span style="color:red" id="person.email1"></span>
                <div class="has-error">
                    <span style="color:red">
                        <form:errors path="person.email" class="help-inline"/>
                    </span>
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
                        <span style="color:red">
                            <form:errors path="person.city" class="help-inline"/>
                        </span>
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
                                <a href="/admin/allDrivers" class="btn btn-orange" style="width: 100%">Отмена</a>
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

    <%--<div class="navbar navbar-inner  navbar-fixed-bottom">--%>
        <%--<p>--%>
        <%--<center class="text-muted">© Netcracker Education Center 2017</center>--%>
        <%--</p>--%>
    <%--</div>--%>
    <script type="text/javascript">
        function validate() {
            var personNickname = document.forms["form"]["person.nickname"].value;
            var personPassword = document.forms["form"]["person.password"].value;
            var personFirstName = document.forms["form"]["person.firstName"].value;
            var personLastName = document.forms["form"]["person.lastName"].value;
            var personMobile = document.forms["form"]["person.mobileNumber"].value;
            var personEmail = document.forms["form"]["person.email"].value;
            var regexEmail = /^(?!.*@.*@.*$)(?!.*@.*\-\-.*\..*$)(?!.*@.*\-\..*$)(?!.*@.*\-$)(.*@.+(\..{1,11})?)$/;
            var regexPhone = /^(\+7)?\d{10}$/;

            if (personNickname.length == 0) {
                document.getElementById("person.nickname1").innerHTML = "*Поле никнейм должно быть обязательно заполнено";
                return false;
            }
            if (personNickname.length > 30) {
                document.getElementById("person.nickname1").innerHTML = "*Значение никнейма не должно превыщать более 30 символов";
                return false;
            }
            if (personPassword.length == 0) {
                document.getElementById("person.password1").innerHTML = "*Пароль должен быть обязательно заполнен";
                return false;
            }
            if (personPassword.length > 100) {
                document.getElementById("person.password1").innerHTML = "*Значение пароля не должно превыщать более 100 символов";
                return false;
            }
            if (personFirstName.length == 0) {
                document.getElementById("person.firstName1").innerHTML = "*Имя пользователя должно быть обязательно заполнено";
                return false;
            }
            if (personFirstName.length > 100) {
                document.getElementById("person.firstName1").innerHTML = "*Значение имени не должно превыщать более 30 символов";
                return false;
            }
            if (personLastName.length == 0) {
                document.getElementById("person.lastName1").innerHTML = "*Фамилия пользователя должна быть обязательно заполнена";
                return false;
            }
            if (personLastName.length > 100) {
                document.getElementById("person.lastName1").innerHTML = "*Значение фамилии не должно превыщать более 30 символов";
                return false;
            }
            if (personEmail.length == 0) {
                document.getElementById("person.email1").innerHTML = "*Поле email должно быть обязательно заполнено";
                return false;
            }
            if (personEmail.length > 30) {
                document.getElementById("person.email1").innerHTML = "*Значение email не должно превыщать более 30 символов";
                return false;
            }
            if (personMobile.length > 30) {
                document.getElementById("person.mobileNumber1").innerHTML = "*Значение mobile не должно превыщать более 30 символов";
                return false;
            }
            if(personMobile.length > 0 && personMobile.length < 30) {
                if (!regexPhone.test(personMobile)) {
                    document.getElementById("person.mobileNumber1").innerHTML = "*Номер телефона введен не верно, введите в формате +7XXXXXXXXXX";
                    return false;
                }
            }
            if (!regexEmail.test(personEmail)) {
                document.getElementById("person.email1").innerHTML = "*Неверный формат почты, введите почту в формате SomeEmail@google.com";
                return false;
            }
        }
    </script>
</div>
</body>
</html>
