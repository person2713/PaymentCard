<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome page</title>
    <%--<link href="/static/css/boot.css" rel="stylesheet">--%>

    <link href="/static/css/welcome_css/bootstrap.css" rel="stylesheet">
    <link href="/static/css/welcome_css/colorbox.css" rel="stylesheet">
    <link href="/static/css/welcome_css/templatemo_style.css"  rel="stylesheet">
   <%-- <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>--%>

    <script src="js/welcome_js/jquery.min.js" type="text/javascript"></script>
    <script src="js/welcome_js/bootstrap.min.js"  type="text/javascript"></script>
    <script src="js/welcome_js/stickUp.min.js"  type="text/javascript"></script>
    <script src="js/welcome_js/jquery.colorbox-min.js"  type="text/javascript"></script>
    <script src="js/welcome_js/templatemo_script.js"  type="text/javascript"></script>

</head>
<body>
<div class="templatemo-top-bar" id="templatemo-top">
    <div class="container">
        <div class="subheader">
            <div id="phone" class="pull-left">
                <img src="/static/images/phone.png" alt="phone"/>
                +7 999 720 80 38
            </div>
            <div id="email" class="pull-right">
                <img src="/static/images/email.png" alt="email"/>
                citycard-pay@yandex.ru
            </div>
        </div>
    </div>
</div>


<div>
    <!-- Carousel -->
    <div id="templatemo-carousel" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <div class="item active">
                <img src="/static/images/templatemo_carousel_bg_s.jpg">
                <div class="container">
                    <div class="carousel-caption">
                        <h1>${greeting}</h1>
                        <p>Пожалуйста, авторизуйтесь или зарегистрируйтесь.</p>
                        <p><a class="btn btn-lg btn-green" href="/login" role="button" style="margin: 20px;">Вход</a>
                            <a class="btn btn-lg btn-orange" href="/registration" role="button">Регистрация</a></p>
                    </div>
                </div>
            </div>
        </div><!-- /#templatemo-carousel -->
    </div>
</div>

<div class="navbar navbar-inner  navbar-fixed-bottom">
    <p><center  class="text-muted"><big>© NetCracker Education Center 2017</big></center></p>
</div>
</body>
</html>