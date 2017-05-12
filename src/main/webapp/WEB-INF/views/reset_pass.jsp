<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Reset password</title>

    <link href="/static/css/welcome_css/bootstrap.css" rel="stylesheet">
    <link href="/static/css/login_css/login.css" rel="stylesheet">
    <link href="/static/css/welcome_css/templatemo_style.css"  rel="stylesheet">
    <link href="/static/css/welcome_css/colorbox.css" rel="stylesheet">
    <link href="/static/images/favicon%20(3).ico" rel="shortcut icon" type="image/x-icon" />

    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-login">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-12">
                            <h4>Восстановление пароля</h4>
                        </div>
                    </div>
                    <hr>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">

                            <form action="resetPassword" method="post" class="form-horizontal" id="login-form" role="form" style="display: block;">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                                <h5><center>Введите адрес электронной почты</center></h5>
                                <br/>
                                <div class="form-group" style="padding-left: 5%; padding-right: 5%">
                                    <input type="email" class="form-control" id="email" name="email" placeholder="Email">

                                </div>


                                <br/>

                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <div class="text-center">
                                                <input type="submit" name="login-submit" id="login-submit" tabindex="4" class=" btn btn-green" value="Восстановить">
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
</body>
</html>