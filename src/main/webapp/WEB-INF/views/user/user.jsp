<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User page</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
		  integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">

	<link href="/static/css/dashboard.css" rel="stylesheet">
	<link href="/static/css/daterangepicker.css" rel="stylesheet"/>

	<script src="/static/js/jquery-3.2.1.js"></script>
	<script src="/static/js/tether.min.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
	<script src="/static/js/admin.js"></script>


	<script src="//code.jquery.com/jquery.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
	<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.0/js/bootstrap-datepicker.min.js"></script>
	<script src="https://cdn.rawgit.com/twbs/bootstrap/v4-dev/dist/js/bootstrap.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>--%>


	<%--<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>--%>
	<%--<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>&ndash;%&gt;
	<script type="text/javascript" src="moment.js"></script>
	<script type="text/javascript" src="daterangepicker.js"></script>
	<script src="js/jquery.dateRangePicker.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/css/moment.js"></script>--%>


</head>
<body>
	<div id="header">
		<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
			<a class="navbar-brand" href="#">PaymentCard</a>
			<div class="collapse navbar-collapse">
				<ul class="navbar-nav ml-auto">
					<li><a href="#"><strong>${user}</strong></a></li>
					<li class="nav-item">
						<a href="/logout">Выйти</a>
					</li>
				</ul>
			</div>
		</nav>
	</div>




<div id="content" class="container-fluid">
	<div class="row">
		<div class="col-sm-3 col-md-2 hidden-xs-down sidebar">

			<div class="dropdown">
			<button type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#modalAddCard">Добавить карту</button>
			</div>

			<!-- Modal -->
			<div class="modal fade" id="modalAddCard" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span></button>
							<h4 class="modal-title" id="myModalLabel1">Добавить карту</h4>
						</div>
						<div class="modal-body">
							<form class="form-horizontal">
								<div class="form-group">
									<label for="inputCardNumber" class="col-sm-3 control-label">Номер карты</label>
									<div class="col-sm-8">
										<input type="cardNumber" class="form-control" id="inputCardNumber" placeholder="Номер карты">
									</div>
								</div>
								<div class="form-group">
									<label for="inputCardName" class="col-sm-3 control-label">Имя карты</label>
									<div class="col-sm-8">
										<input type="cardName" class="form-control" id="inputCardName" placeholder="Имя карты">
									</div>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
							<button type="button" class="btn btn-primary">Привязать</button>
						</div>
					</div>
				</div>
			</div>



			<div  class="dropdown ofset">
				<button type="button" class="btn btn-primary btn-block" data-toggle="dropdown">Выбрать карту
					<span class="caret"></span></button>
				<ul class="dropdown-menu ">
					<li><a href="#">карта 1</a></li>
					<li><a href="#">карта 2</a></li>
					<li><a href="#">карта 3</a></li>
				</ul>
			</div>

			<div class="dropdown">
			<button type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#modalAddBalance">Пополнить баланс</button>
			</div>

			<!-- Modal -->
			<div class="modal fade" id="modalAddBalance" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabe2">Введите необходимую сумму</h4>
						</div>
						<div class="modal-body">
							<form class="form-inline">
								<div class="form-group">
									<div class="col-lg-10">
										<div class="input-group">
											<div class="input-group-addon">&#8381</div>
											<input type="text" class="form-control" id="addBalance" placeholder="Сумма">
											<div class="input-group-addon">.00</div>
											<span class="input-group-btn">
                                            <button class="btn btn-primary">Пополнить баланс</button>
                                          </span>
										</div>
									</div>

								</div>

							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>

						</div>

					</div>
				</div>
			</div>



			<div class="dropdown">
			<button type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#confirmDelete">Заблокировать карту</button>
			</div>

			<!-- Небольшое модальное окно -->

			<div id="confirmDelete" class="modal fade" tabindex="-1">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header"><button class="close" type="button" data-dismiss="modal">×</button>
							<h4 class="modal-title">Подтвердить блокировку</h4>
						</div>
						<div class="modal-body">Вы точно хотите заблокировать данную карту?</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
							<button type="submit" class="btn btn-warning">Заблокировать</button>
						</div>
					</div>
				</div>
			</div>


			<div class="dropdown">
			<button class="btn btn-primary btn-block" id="config-demo">История</button>
			</div>

			<div class="dropdown">
			<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
				Запуск демо
			</button>
			</div>

			<!-- Модаль -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							<h4 class="modal-title" id="myModalLabel">Название модали</h4>
						</div>
						<div class="modal-body">
							...
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
							<button type="button" class="btn btn-primary">Сохранить изменения</button>
						</div>
					</div>
				</div>
			</div>

	

		</div>
		<div id="head" class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
			<div class="row">
				<div class="col-4 col-sm-4 col-lg-4">
					<h2>Карта: </h2>
				</div>
				<div class="col-4 col-sm-4 col-lg-4">
					<h2>Баланс:  руб.</h2>
				</div>
				<div class="col-4 col-sm-4 col-lg-4">
					<h2>Поездок доступно: </h2>
				</div>
		</div>



				<%--<table class="table table-hover">
                    <thead>
                    <tr>
                        <th>карты + ${nickname}</th>
                    </tr>
                    </thead>
                    <tbody>
                    &lt;%&ndash;<c:forEach items="${cards}" var="cards">
                        <tr>
                            <td>${cards.cardId}</td>
                        </tr>
                    </c:forEach>&ndash;%&gt;
                    </tbody>
                </table>
--%>


		</div><!--/span-->
	</div>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        updateConfig();
        function updateConfig() {
            var options = {};
            options.showDropdowns = true;
            options.autoApply = true;
            options.ranges = {
                'Today': [moment(), moment()],
                'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                'Last 7 Days': [moment().subtract(6, 'days'), moment()],
                'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                'This Month': [moment().startOf('month'), moment().endOf('month')],
                'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
            };
            $('#config-text').val("$('#demo').daterangepicker(" + JSON.stringify(options, null, '    ') + ", function(start, end, label) {\n  console.log(\"New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')\");\n});");
            $('#config-demo').daterangepicker(options, function(start, end, label) { console.log('New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')'); });
        }
    });
</script>

<div class="navbar navbar-inner  navbar-fixed-bottom">
	<p><center  class="text-muted">© NetCracker Education Center 2017</center></p>
</div>

</body>
</html>