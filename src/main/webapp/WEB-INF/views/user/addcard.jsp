<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добавить карту</title>
    <link href="/static/css/boot.css" rel="stylesheet">
    <link href="/static/css/login_css/login.css" rel="stylesheet">
    <link href="/static/css/welcome_css/colorbox.css" rel="stylesheet">
    <link href="/static/css/welcome_css/templatemo_style.css"  rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>
<script type="text/javascript">
    function validate(){
        //Считаем значения из полей name и email в переменные x и y
        var x=document.forms["form"]["idcard"].value;
        var z=document.forms["form"]["namecard"].value;

        var renum = /^[0-9]{1,20}$/;
        var rename = /^[0-9A-Za-zА-Яа-я]{1,10}$/;
        //Если поле name пустое выведем сообщение и предотвратим отправку формы
        if (x.length==0){
            document.getElementById("wNun").innerHTML="*данное поле обязательно для заполнения";
            return false;
        }

        //Если поле email пустое выведем сообщение и предотвратим отправку формы



        if (!renum.test(x)){document.getElementById("numF").innerHTML="*Номер карты - числа  до 20 знаков";
            return false;}
        if (!rename.test(z)){document.getElementById("nnameF").innerHTML="*Максимальная длина имени 10 символов";
            return false;}





    }
</script>

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
                            <form action="/user/user/addUserCard" name="form" method="post" onsubmit="return (validate())" class="form-horizontal" id="login-form" role="form" style="display: block;">
                                <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <h5><center>Введите номер карты</center></h5>
                                <div class="form-group" style="padding-left: 5%; padding-right: 5%">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <input type="text" class="form-control" id="inputCardNumber" name="idcard" placeholder="Номер карты"><span style="color:red" id="wNun"></span><span style="color:red" id="numF"></span>
                                    <c:if test="${flag}">
                                        <div class="alert alert-danger">
                                            <p>Карточка с таким ключом не найдена</p>
                                        </div>
                                    </c:if>
                                </div>
                                <h5><center>Введите название карты</center></h5>
                                <div class="form-group" style="padding-left: 5%; padding-right: 5%">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <input type="text" class="form-control" id="inputCardName" name="namecard" placeholder="Название карты"><span style="color:red" id="nnameF"></span>
                                </div>
                                </br>


                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-8 col-sm-offset-2">
                                            <div class="col-md-6">
                                                <div class="text-center">
                                                    <button onClick="return validate();" class="btn btn-green" style="width: 100%; overflow: hidden">Добавить</button>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="text-center">
                                                    <%--<a href="${urlHome}" class="btn btn-orange" style="width: 100%; overflow: hidden">Отмена</a>--%>
                                                    <a href="/user" class="btn btn-orange" style="width: 100%; overflow: hidden">Отмена</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div><!-- /.row -->
                    <div class="navbar navbar-inner  navbar-fixed-bottom">
                        <p><center  class="text-muted">© Netcracker Education Center 2017</center></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>