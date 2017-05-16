<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">

<head>
    <title>Администратор</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="_csrf" content="6417ec49-aa65-48f9-a7e5-1da3bbff98c2">

    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <link href="http://cdn.datatables.net/buttons/1.3.1/css/buttons.bootstrap.min.css">
    <script type="text/javascript" src="http://cdn.datatables.net/buttons/1.3.1/js/buttons.bootstrap.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="http://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js"></script>
    <script type="text/javascript" src="http://cdn.datatables.net/buttons/1.3.1/js/buttons.flash.min.js"></script>
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
    <script type="text/javascript" src="http://cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/pdfmake.min.js"></script>
    <script type="text/javascript" src="http://cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/vfs_fonts.js"></script>
    <script type="text/javascript" src="http://cdn.datatables.net/buttons/1.3.1/js/buttons.html5.min.js"></script>
    <script type="text/javascript" src="http://cdn.datatables.net/buttons/1.3.1/js/buttons.print.min.js"></script>
    <script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
    <script>
        $(document).ready(function () {
                $('#myTable').DataTable({

                    "language": {
                        "url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/Russian.json"
                    }
                });

            },
            function () {
                $('table tr').click(function (event) {
                    if (event.target.type !== 'checkbox') {
                        $(':checkbox', this).trigger('click');
                    }
                });
            });
    </script>
</head>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" style="color: white;">Payment Card</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">Показать <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/admin/allUsers">Список пользователей</a></li>
                        <li><a href="/admin/allOwners">Список владельцев</a></li>
                        <li><a href="/admin/allDrivers">Список водителей</a></li>
                        <li><a href="/admin/allCards">Список карт</a></li>
                        <li><a href="/admin/allCompanies">Список компаний</a></li>
                        <li><a href="/admin/allBuses">Список автобусов</a></li>
                        <li><a href="/admin/allRoutes">Список маршрутов</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">Добавить <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/registration">Пользователя</a></li>
                        <li><a href="/admin/addOwner">Владельца</a></li>
                        <li><a href="/admin/addDriver">Водителя</a></li>
                        <li><a href="/admin/addCompany">Компанию</a></li>
                        <li><a href="/admin/addCard">Карту</a></li>
                        <li><a href="/admin/addBus">Автобус</a></li>
                        <li><a href="/admin/addRoute">Маршрут</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a><strong>${loggedinuser}</strong></a></li>
                <li><a href="/logout">Выйти</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
