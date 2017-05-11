<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="_csrf" content="6417ec49-aa65-48f9-a7e5-1da3bbff98c2">


    <link href="/static/css/boot.css" rel="stylesheet">
    <link href="/static/css/dashboard.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/static/css/user_css/daterangepicker.css"/>

    <script src="/static/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/static/js/user_js/moment.js"></script>
    <script type="text/javascript" src="/static/js/user_js/daterangepicker.js"></script>
    <script type="text/javascript" src="/static/js/user_js/user.js"></script>
    <script>
        getCardsForAlex();
    </script>
</head>
<body>
<div class="navbar navbar-fixed-top navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" style="color: white">Payment Card</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a><strong>${user.nickname}</strong></a></li>
                <li><a href="/logout">Выйти</a></li>
            </ul>
        </div><!-- /.nav-collapse -->
    </div><!-- /.container -->
</div><!-- /.navbar -->
<div id="content" class="container-fluid" style="padding-top: 15px">
    <div class="row">
        <div class="col-sm-3 col-md-2 hidden-xs-down">

            <div class="dropdown">
                <button type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#modalAddCard">
                    Добавить карту
                </button>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="modalAddCard" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1"
                 aria-hidden="true">
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
                                        <input type="cardNumber" class="form-control" id="inputCardNumber"
                                               placeholder="Номер карты">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputCardName" class="col-sm-3 control-label">Имя карты</label>
                                    <div class="col-sm-8">
                                        <input type="cardName" class="form-control" id="inputCardName"
                                               placeholder="Имя карты">
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


            <div class="dropdown ofset">
                <button type="button" class="btn btn-primary btn-block" data-toggle="dropdown">Выбрать карту
                    <span class="caret"></span></button>
                <ul class="dropdown-menu " id="dropList">
                    <c:forEach items="${user.cards}" var="card">
                        <li><a onclick="getCardInfo(xyu);">${card.cardId}</a></li>
                    </c:forEach>
                </ul>
            </div>

            <div class="dropdown">
                <button type="button" class="btn btn-primary btn-block" data-toggle="modal"
                        data-target="#modalAddBalance">Пополнить баланс
                </button>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="modalAddBalance" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
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
                <button type="button" class="btn btn-primary btn-block" data-toggle="modal"
                        data-target="#confirmDelete">Заблокировать карту
                </button>
            </div>

            <!-- Небольшое модальное окно -->

            <div id="confirmDelete" class="modal fade" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button class="close" type="button" data-dismiss="modal">×</button>
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
                <button id="config-demo" class="btn btn-primary btn-block">История</button>
            </div>


        </div>
        <div class="col-xs-12 col-sm-9">
            <div class="row">
                <div class="col-4 col-sm-4 col-lg-4">
                    <div class="row">
                        <h2>Карта: </h2>
                        <h2 id="cardName">XYU</h2>
                    </div>
                </div>
                <div class="col-4 col-sm-4 col-lg-4">
                    <div class="row">
                        <h2 >Баланс: руб.</h2>
                        <h2 id="balance">XYU</h2>
                    </div>
                </div>
                <%--<div class="col-4 col-sm-4 col-lg-4">--%>
                    <%--<div class="row">--%>
                        <%--<h2>Поездок доступно: </h2>--%>
                        <%--<h2>XYU</h2>--%>
                    <%--</div>--%>
                <%--</div>--%>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">





    function getCardInfo(item) {
        console.log(item);
//        $('#cardName').val(item.cardName)
//        });
    }
    ;
</script>


<script type="text/javascript">
    $(document).ready(function () {
        $('.configurator input, .configurator select').change(function () {
            updateConfig();
        });

        updateConfig();

        function updateConfig() {
            var options = {};

            options.ranges = {
                'Сегодня': [moment(), moment()],
                'Вчера': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                'За неделю': [moment().subtract(6, 'days'), moment()],
                'За 30 дней': [moment().subtract(29, 'days'), moment()],
                'За этот месяц': [moment().startOf('month'), moment().endOf('month')],
                'За прошлый месяц': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
            };

            $('#config-text').val("$('#demo').daterangepicker(" + JSON.stringify(options, null, '    ') + ", function(start, end, label) {\n  console.log(\"New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')\");\n});");
            $('#config-demo').daterangepicker(options, function (start, end, label) {
                console.log('New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')');
            });

        }
    });
</script>


<div class="navbar navbar-inner  navbar-fixed-bottom">
    <p>
    <center class="text-muted">© NetCracker Education Center 2017</center>
    </p>
</div>

</body>
</html>