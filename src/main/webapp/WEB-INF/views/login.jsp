<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Авторизация</title>
	<link href="/static/css/welcome_css/bootstrap.css" rel="stylesheet">
	<link href="/static/css/login_css/login.css" rel="stylesheet">
	<link href="/static/css/welcome_css/templatemo_style.css"  rel="stylesheet">
	<link href="/static/css/welcome_css/colorbox.css" rel="stylesheet">
	<link href="/static/images/favicon%20(3).ico" rel="shortcut icon" type="image/x-icon" />

</head>

<body style="background-color: #EDEEF0">
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-login">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-12">
							<h4>Авторизация</h4>
						</div>
					</div>
					<hr>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-12">
							<form action="${loginUrl}" method="post" class="form-horizontal" id="login-form" role="form" style="display: block;">
								<c:if test="${flag}">
									<div class="alert alert-danger">
										<p>Invalid username and password.</p>
									</div>
								</c:if>
								<c:if test="${param.logout != null}">
									<div class="alert alert-success">
										<p>You have been logged out successfully.</p>
									</div>
								</c:if>
								<br>
								<div class="form-group" style="padding-left: 5%; padding-right: 5%">
									<input type="text" class="form-control input-sm" id="nickName" name="nickName" placeholder="Имя пользователя" style="padding-left: 10px; padding-right: 10px">
								</div>
								<div class="form-group" style="padding-left: 5%; padding-right: 5%">
									<input type="password" class="form-control input-sm" id="password" name="password" placeholder="Пароль" style="padding-left: 10px; padding-right: 10px">
								</div>

								<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />

								<div class="form-group">
									<div class="row">
										<div class="col-sm-8 col-sm-offset-2">
											<div class="col-md-6">
												<div class="text-center">
													<button class="btn btn-green" style="width: 100%; overflow: hidden">Вход</button>
												</div>
											</div>
											<div class="col-md-6">
												<div class="text-center">
													<a href="/" class="btn btn-orange" style="width: 100%; overflow: hidden">На главную</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-lg-12">
											<div class="text-center">
												<a href="/reset_pass" class="forgot-password">Забыли пароль?</a>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div><!-- /.row -->

				</div>
			</div>
		</div>
	</div>
</div>
<div class="navbar navbar-inner  navbar-fixed-bottom">
	<p><center class="text-muted"><big>© Netcracker Education Center 2017</big></center></p>
</div>
</body>
</html>