<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Добавить карту</title>
    <link href="/static/css/boot.css" rel="stylesheet">
    <link href="/static/css/login_css/login.css" rel="stylesheet">
    <link href="/static/css/welcome_css/colorbox.css" rel="stylesheet">
    <link href="/static/css/welcome_css/templatemo_style.css"  rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>
<spring:url value="http://localhost:9000/user" var="urlHome" />

<body style="background-color: #EDEEF0">
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-login">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-12">
                            <h4>Добавление карты</h4>
                        </div>
                    </div>
                    <hr>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form action="/user/user/addUserCard" method="post" class="form-horizontal" id="login-form" role="form" style="display: block;">
                                <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <h5><center>Введите номер карты</center></h5>
                                <div class="form-group" style="padding-left: 5%; padding-right: 5%">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <input type="text" class="form-control" id="inputCardNumber" name="idcard" placeholder="Номер карты">
                                </div>
                                <h5><center>Введите название карты</center></h5>
                                <div class="form-group" style="padding-left: 5%; padding-right: 5%">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <input type="text" class="form-control" id="inputCardName" name="namecard" placeholder="Название карты">
                                </div>
                                </br>


                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <div class="text-center">
                                                <button class="btn btn-green">Добавить</button>
                                                <a href="${urlHome}" class="btn btn-orange">Отмена</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div><!-- /.row -->
                    <div class="navbar navbar-inner  navbar-fixed-bottom">
                        <p><center  class="text-muted">© NetCracker Education Center 2017</center></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>