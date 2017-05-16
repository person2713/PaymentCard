<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

        <form:form method="POST" modelAttribute="" action="" class="form-horizontal">
            <form:input type="hidden" path="" id=""/>


            <div class="form-group">
                <label class="col-md-4 control-label" for="first_name">Имя</label>
                <div class="col-md-4">
                    <form:input type="text" path="first_name" id="first_name" class="form-control"/>
                    <div class="has-error">
                        <form:errors path="first_name" class="help-inline"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="first_name">Фамилия</label>
                <div class="col-md-4">
                    <form:input type="text" path="last_name" id="last_name" class="form-control"/>
                    <div class="has-error">
                        <form:errors path="last_name" class="help-inline"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="mobile">Телефон</label>
                <div class="col-md-4">
                    <form:input type="text" path="mobile" id="mobile" class="form-control"/>
                    <div class="has-error">
                        <form:errors path="mobile" class="help-inline"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Email</label>
                <div class="col-md-4">
                    <form:input type="email" path="email" id="email" class="form-control"/>
                    <div class="has-error">
                        <form:errors path="email" class="help-inline"/>
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
            <center class="text-muted">© NetCracker Education Center 2017</center>
            </p>
        </div>
    </div>

</body>
</html>
