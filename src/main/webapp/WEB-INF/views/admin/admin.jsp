<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Admin page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="_csrf" content="6417ec49-aa65-48f9-a7e5-1da3bbff98c2">


    <%--<link href="/static/css/boot.css" rel="stylesheet">--%>
    <link href="/static/css/dashboard.css" rel="stylesheet">
    <%--<link href="/static/images/favicon%20(3).ico" rel="shortcut icon" type="image/x-icon" />--%>

    <%--не работаютт кнопки с ними--%>
    <%--<script src="/static/js/jquery-3.2.1.js"></script>--%>
    <%--<script src="/static/js/tether.min.js"></script>--%>
    <%--<script src="/static/js/bootstrap.min.js"></script>--%>
    <%--<script src="/static/js/admin.js"></script>--%>

    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


    <%--<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>--%>
    <%--<link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css"/>--%>
    <%--<script type="text/javascript" src="//code.jquery.com/jquery-1.12.4.js"></script>--%>
    <%--<script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>--%>
    <%--<script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>--%>

    <%--<link rel="stylesheet" href="/static/bootstrapTable/bootstrap-table.min.css" >--%>
    <%--<script src="/static/bootstrapTable/bootstrap-table.min.js"></script>--%>
    <%--<script src="/static/bootstrapTable/bootstrap-table-ru-RU.min.js"></script>--%>

    <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">

    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-contextmenu/0.3.4/bootstrap-contextmenu.js"></script>--%>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>


    <%--<!-- Latest compiled and minified CSS -->--%>
    <%--<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>

    <%--<!-- Optional theme -->--%>
    <%--<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">--%>

    <%--<!-- Latest compiled and minified JavaScript -->--%>
    <%--<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>--%>
    <%--<script>--%>
    <%--//        getCities();--%>
    <%--//        getRollers();--%>
    <%--//        getTypeCard();--%>
    <%--//        getCompanies();--%>

    <%--//    </script>--%>
    <script>
        $(document).ready(function () {
            $("#users").DataTable();
        });
        function getUsersz() {
            $(document).ready(function ()
            {
                $('#owners').hide(); //ADD THIS
                $('#drivers').hide();
                $('#document').remove('#users_wrapper');
                $('#users').show();
            });

        }
        function getDriversz() {
            $(document).ready(function ()
            {
                $('#users_wrapper').hide(); //ADD THIS
                $('#users').hide();
                $('#document').remove('#users_wrapper');
                $('#drivers').show();
            });

        }
        function getOwnersz() {
            $(document).ready(function ()
            {

                $('#drivers').hide();
                $('#users').hide();
                $('#document').remove('#users_wrapper');
                $('#owners').show(); //ADD THIS
            });

        }
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
                <li><a><strong>${loggedinuser}</strong></a></li>
                <li><a href="/logout">Выйти</a></li>
            </ul>
        </div><!-- /.nav-collapse -->
    </div><!-- /.container -->
</div><!-- /.navbar -->
<div id="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-3 col-md-2 hidden-xs-down sidebar">

                <div class="dropdown ofset">
                    <button type="button" class="btn btn-primary btn-block" data-toggle="dropdown">Показать
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu ">
                        <li><a onclick="getUsersz();">Список пользователей</a></li>
                        <li><a onclick="getOwnersz();">Список владельцев</a></li>
                        <li><a onclick="getDriversz();">Список водителей</a></li>
                        <li><a onclick="getCards();">Список водителей</a></li>
                    </ul>
                </div>
                <div class="dropdown ofset">
                    <button class="btn btn-primary dropdown-toggle btn-block" type="button" data-toggle="dropdown">
                        Добавить
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu contmenu">
                        <button type="button" class="btn btn-link" onclick="window.location='/registration'">
                            Пользователя
                        </button>
                        <br>
                        <button type="button" class="btn btn-link" onclick="window.location='/admin/addOwner'">
                            Владельца
                        </button>
                        <br>
                        <button type="button" class="btn btn-link" onclick="window.location='/admin/addDriver'">
                            Водителя
                        </button>
                        <br>
                        <button type="button" class="btn btn-link" onclick="window.location='/admin/addCompany'">
                            Компанию
                        </button>
                        <br>
                        <button type="button" class="btn btn-link" onclick="window.location='/admin/addCard'">Карту
                        </button>
                        <%--<button type="button" class="btn btn-link" onclick="prepareAddCards();">Карту</button>--%>
                        <br>
                        <button type="button" class="btn btn-link" onclick="window.location='/admin/addBus'">Автобус
                        </button>
                        <br>
                        <button type="button" class="btn btn-link" onclick="window.location='/admin/addRoute'">Маршрут
                        </button>
                    </ul>
                </div>
                <div class="dropdown">
                    <button type="button" class="btn btn-primary ofset btn-block" onclick="deleteUser()">Удалить
                    </button>
                </div>
                <div class="dropdown">
                    <button type="button" class="btn btn-primary ofset btn-block" onclick="edit()">Редактировать
                    </button>
                </div>
            </div>

            <div id="head" class="col-sm-9 col-md-10 pt-3" style="padding-top: 60px" >
                <div>
                    <table id="users" class="table table-striped table-bordered" cellspacing="0" width="100%">
                        <thead>
                        <tr>
                            <th>Nickname</th>
                            <th>FirstName</th>
                            <th>LastName</th>
                            <th>City</th>
                            <th>MobileNumber</th>
                            <th>Email</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                    <%--с ним не работает--%>
                                    <%--<td style="display:none">${person.personId}</td>--%>
                                <td>${user.nickname}</td>
                                <td>${user.firstName}</td>
                                <td>${user.lastName}</td>
                                <td>${user.city.cityName}</td>
                                <td>${user.mobileNumber}</td>
                                <td>${user.email}</td>
                                <td><input type="checkbox" value=""/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <table id="drivers" class="table table-striped table-bordered" cellspacing="0" width="100%" style="display: none">
                        <thead>
                        <tr>
                            <th>Nickname</th>
                            <th>FirstName</th>
                            <th>LastName</th>
                            <th>City</th>
                            <th>MobileNumber</th>
                            <th>Email</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${drivers}" var="driver">
                            <tr>
                                    <%--с ним не работает--%>
                                    <%--<td style="display:none">${person.personId}</td>--%>
                                <td>${driver.person.nickname}</td>
                                <td>${driver.person.firstName}</td>
                                <td>${driver.person.lastName}</td>
                                <td>${driver.person.city.cityName}</td>
                                <td>${driver.person.mobileNumber}</td>
                                <td>${driver.person.email}</td>
                                <td><input type="checkbox" value=""/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                    <table id="Owners" class="table table-striped table-bordered" cellspacing="0" width="100%" style="display: none">
                        <thead>
                        <tr>
                            <th>Nickname</th>
                            <th>FirstName</th>
                            <th>LastName</th>
                            <th>City</th>
                            <th>MobileNumber</th>
                            <th>Email</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${owners}" var="owner">
                            <tr>
                                    <%--с ним не работает--%>
                                    <%--<td style="display:none">${person.personId}</td>--%>
                                <td>${owner.person.nickname}</td>
                                <td>${owner.person.firstName}</td>
                                <td>${owner.person.lastName}</td>
                                <td>${owner.person.city.cityName}</td>
                                <td>${owner.person.mobileNumber}</td>
                                <td>${owner.person.email}</td>
                                <td><input type="checkbox" value=""/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>


<%--<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--<title>Admin page</title>--%>
<%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
<%--<meta name="_csrf" content="${_csrf.token}"/>--%>
<%--<meta name="_csrf_header" content="${_csrf.headerName}"/>--%>
<%--<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>
<%--<meta name="description" content="">--%>
<%--<meta name="author" content="">--%>
<%--<meta name="_csrf" content="6417ec49-aa65-48f9-a7e5-1da3bbff98c2">--%>


<%--<link href="/static/css/dashboard.css" rel="stylesheet">--%>

<%--&lt;%&ndash;<script src="/static/js/jquery-3.2.1.js"></script>&ndash;%&gt;--%>
<%--&lt;%&ndash;<script src="/static/js/tether.min.js"></script>&ndash;%&gt;--%>
<%--&lt;%&ndash;<script src="/static/js/bootstrap.min.js"></script>&ndash;%&gt;--%>
<%--&lt;%&ndash;<script src="/static/js/admin.js"></script>&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;линки для контекстного меню&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;<link rel="stylesheet" href="/static/bootstrapTable/bootstrap-table.min.css" >&ndash;%&gt;--%>
<%--&lt;%&ndash;<script src="/static/bootstrapTable/bootstrap-table.min.js"></script>&ndash;%&gt;--%>
<%--&lt;%&ndash;<script src="/static/bootstrapTable/bootstrap-table-ru-RU.min.js"></script>&ndash;%&gt;--%>

<%--<link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
<%--<link href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">--%>

<%--&lt;%&ndash;<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-contextmenu/0.3.4/bootstrap-contextmenu.js"></script>&ndash;%&gt;--%>
<%--<script src="https://code.jquery.com/jquery-1.12.4.js"></script>--%>
<%--<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>--%>
<%--<script src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>--%>


<%--<script>--%>
<%--$(document).ready(function () {--%>
<%--$('#example').DataTable();--%>
<%--});--%>


<%--$(document).ready(function () {--%>
<%--$('table tr').click(function (event) {--%>
<%--if (event.target.type !== 'checkbox') {--%>
<%--$(':checkbox', this).trigger('click');--%>
<%--}--%>
<%--});--%>
<%--});--%>


<%--</script>--%>

<%--</head>--%>

<%--<body>--%>
<%--<div class="navbar navbar-fixed-top navbar-inverse">--%>
<%--<div class="container-fluid">--%>
<%--<div class="navbar-header">--%>
<%--<a class="navbar-brand" style="color: white">Payment Card</a>--%>
<%--</div>--%>
<%--<div class="collapse navbar-collapse">--%>
<%--<ul class="nav navbar-nav navbar-right">--%>
<%--<li><a><strong>${loggedinuser}</strong></a></li>--%>
<%--<li><a href="/logout">Выйти</a></li>--%>
<%--</ul>--%>
<%--</div><!-- /.nav-collapse -->--%>
<%--</div><!-- /.container -->--%>
<%--</div><!-- /.navbar -->--%>

<%--<div>--%>
<%--<table id="example" class="table table-striped table-bordered" cellspacing="0" ">--%>
<%--<thead>--%>
<%--<tr>--%>
<%--<th data-field="nickname">Ник</th>--%>
<%--<th data-field="firstName">Имя</th>--%>
<%--<th data-field="lastName">Фамилия</th>--%>
<%--<th data-field="mobilePhone">Мобильный телефон</th>--%>
<%--<th data-field="email">Электронная почта</th>--%>
<%--<th data-field="city">Город</th>--%>
<%--<th></th>--%>
<%--</tr>--%>
<%--</thead>--%>
<%--<c:forEach items="${persons}" var="user">--%>
<%--<tr>--%>
<%--<td style="display:none" >${person.personId}</td>--%>
<%--<td>${user.nickname}</td>--%>
<%--<td>${user.firstName}</td>--%>
<%--<td>${user.lastName}</td>--%>
<%--<td>${user.mobileNumber}</td>--%>
<%--<td>${user.email}</td>--%>
<%--<td>${user.city.cityName}</td>--%>
<%--<td><input type="checkbox" value=""/></td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</table>--%>
<%--</div>--%>

<%--<ul id="example2-context-menu" class="dropdown-menu">--%>
<%--<li data-item="edit"><a>Edit</a></li>--%>
<%--<li data-item="delete"><a>Delete</a></li>--%>
<%--<li data-item="action1"><a>Action Here</a></li>--%>
<%--<li data-item="action2"><a>And Action Here</a></li>--%>
<%--</ul>--%>

<%--&lt;%&ndash;<script>&ndash;%&gt;--%>
<%--&lt;%&ndash;$('#example').bootstrapTable({&ndash;%&gt;--%>
<%--&lt;%&ndash;contextMenu: '#example2-context-menu',&ndash;%&gt;--%>
<%--&lt;%&ndash;contextMenuButton: '.example2-button',&ndash;%&gt;--%>
<%--&lt;%&ndash;onContextMenuItem: function(row, $el){&ndash;%&gt;--%>
<%--&lt;%&ndash;if($el.data("item") == "edit"){&ndash;%&gt;--%>
<%--&lt;%&ndash;alert("Edit: " + row.nickname);&ndash;%&gt;--%>
<%--&lt;%&ndash;} else if($el.data("item") == "delete"){&ndash;%&gt;--%>
<%--&lt;%&ndash;alert("Edit: " + row.nickname);&ndash;%&gt;--%>
<%--&lt;%&ndash;} else if($el.data("item") == "action1"){&ndash;%&gt;--%>
<%--&lt;%&ndash;alert("Edit: " + row.nickname);&ndash;%&gt;--%>
<%--&lt;%&ndash;} else if($el.data("item") == "action2"){&ndash;%&gt;--%>
<%--&lt;%&ndash;alert("Edit: " + row.nickname);&ndash;%&gt;--%>
<%--&lt;%&ndash;}&ndash;%&gt;--%>
<%--&lt;%&ndash;}&ndash;%&gt;--%>
<%--&lt;%&ndash;});&ndash;%&gt;--%>
<%--&lt;%&ndash;</script>&ndash;%&gt;--%>
<%--</body>--%>
<%--</html>--%>

