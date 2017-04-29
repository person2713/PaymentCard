<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login page</title>
	<%--<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"/>--%>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
	<link href="<c:url value='/static/css/reg.css' />" rel="stylesheet"/>
	<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>

<body>
<div class="container">
	<div class="row">

		<div class="col-md-offset-3 col-md-6">

			<form action="${loginUrl}" method="post" class="form-horizontal">
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
				<span class="heading">Авторизация</span>
				<div class="form-group">


					<i class="fa fa-user"></i></label>
					<input type="text" class="form-control" id="nickName" name="nickName" placeholder="Имя пользователя" required>


				</div>
				<div class="form-group">

					<i class="fa fa-lock"></i></label>
					<input type="password" class="form-control" id="password" name="password" placeholder="Пароль" required>


				</div>
				<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />


				<div class="form-group">


					<button type="submit" class="btn btn-default">Вход</button>
				</div>
			</form>
		</div>

	</div><!-- /.row -->
	<div class="navbar navbar-inner  navbar-fixed-bottom">
		<p><center  class="text-muted">© NetCracker Education Center 2017</center></p>
	</div>

</div><!-- /.container -->

</body>
</html>
