<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Изменить пользователя</title>

    <link href="/static/css/boot.css" rel="stylesheet">
    <link href="/static/css/welcome_css/colorbox.css" rel="stylesheet">
    <link href="/static/css/welcome_css/templatemo_style.css"  rel="stylesheet">

</head>
<spring:url value="http://localhost:9000/user" var="urlHome" />
<body style="background-color: #EDEEF0">

    <div class="container">

        <legend><h2>Изменить пользователя</h2></legend>
        <spring:url value="/user/info" var="userActionUrl" />
        <form:form method="POST" modelAttribute="person" action="${userActionUrl}" class="form-horizontal">
            <form:hidden path="personId" />



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
                <label class="col-md-4 control-label" for="mobileNumber">Телефон</label>
                <div class="col-md-4">
                    <form:input type="text" path="mobileNumber" id="mobileNumber" class="form-control"/>
                    <div class="has-error">
                        <form:errors path="mobileNumber" class="help-inline"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label"></label>
                <div class="col-md-2">
                    <div class="text-center">
                        <input type="submit" value="Изменить" class="btn btn-success" style="width: 100%"/>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="text-center">
                        <a href="${urlHome}" class="btn btn-orange" style="width: 100%">На главную</a>
                    </div>
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
