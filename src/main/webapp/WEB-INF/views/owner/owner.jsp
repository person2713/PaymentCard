<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User page</title>

	<link href="/static/css/boot.css" rel="stylesheet">
	<link href="/static/css/dashboard.css" rel="stylesheet">
	<link href="/daterangepicker.scss" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script src="/static/js/user_js/daterangepicker.js"></script>
	<script src="/static/js/user_js/moment.js"></script>

</head>
<body>
	<div class="navbar navbar-fixed-top navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">

				<a class="navbar-brand" style="color: white">Payment Card</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a><strong>${loggedinuser}</strong></a></li>
					<li><a href="/logout">Выйти</a></li>
				</ul>
			</div><!-- /.nav-collapse -->
		</div><!-- /.container -->
	</div><!-- /.navbar -->
	<div id="content" class="container-fluid" style="padding-top: 15px">
		<div class="row">
			<div class="col-sm-3 col-md-2 hidden-xs-down">

				<div class="dropdown">
					<button type="button" class="btn btn-primary btn-block">Водители в компании</button>
				</div>


				<div class="dropdown">
					<button type="button" class="btn btn-primary btn-block">Транспорт компании</button>
				</div>
			</div>
			<div class="col-md-10 col-sm-9">
				<div class="row">
					<div class="col-6 col-sm-6 col-lg-6">
						<h2>Баланс компании: овердохрена руб.</h2>
					</div>
					<div class="col-6 col-sm-6 col-lg-6">
						<h2>Прибыль за неделю:  руб.</h2>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="navbar navbar-inner  navbar-fixed-bottom">
		<p><center  class="text-muted">© NetCracker Education Center 2017</center></p>
	</div>

</body>
</html>