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


    <!-- 4.0.0-alpha.6/css/bootstrap.min.css-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">

    <link href="/static/css/dashboard.css" rel="stylesheet">

    <script src="/static/js/jquery-3.2.1.js"></script>
    <script src="/static/js/tether.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="/static/js/admin.js"></script>
    <%--линки для контекстного меню--%>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>

</head>

<body>
<div id="header">
    <nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
        <a class="navbar-brand" href="#">PaymentCard</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a href="/logout">Выйти</a>
                </li>
            </ul>
        </div>
    </nav>
</div>
<div id="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-3 col-md-2 hidden-xs-down sidebar">

                <div class="dropdown ofset">
                    <button class="btn btn-primary dropdown-toggle btn-block" type="button" data-toggle="dropdown"
                            aria-expanded="false">
                        Показать
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu contmenu">
                        <button type="button" class="btn btn-link" onclick="getUsers();">Список пользователей</button>
                        <button type="button" class="btn btn-link" onclick="getOwners();">Список владельцев</button>
                        <button type="button" class="btn btn-link" onclick="getDrivers();">Список водителей</button>
                        <button type="button" class="btn btn-link" onclick="getCards();">Список карт</button>
                    </ul>
                </div>


                <div class="dropdown ofset">
                    <button class="btn btn-primary dropdown-toggle btn-block" type="button" data-toggle="dropdown">
                        Добавить
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu contmenu">
                        <button type="button" class="btn btn-link" onclick="getUsers();">Пользователя</button>
                        <br>
                        <button type="button" class="btn btn-link" onclick="getUser();">Компанию</button>
                        <br>
                        <button type="button" class="btn btn-link" onclick="addCards();">Карту</button>
                        <br>
                        <button type="button" class="btn btn-link" onclick="getUser();">Машину</button>
                        <br>
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

            <div id="head" class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
            </div>
        </div>
    </div>
</div>



<ul id="context-menu" class="dropdown-menu">
    <li data-item="edit"><a>Edit</a></li>
    <li data-item="delete"><a>Delete</a></li>
    <li data-item="action1"><a>Action Here</a></li>
    <li data-item="action2"><a>And Action Here</a></li>
</ul>
<%--<footer class="footer">--%>
    <%--<div class="container">--%>
        <%--<p class="text-center">© NetCracker Education Center 2017</p>--%>
    <%--</div>--%>
<%--</footer>--%>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

</body>
</html>



