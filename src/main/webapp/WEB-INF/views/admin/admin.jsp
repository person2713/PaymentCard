<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <link rel="icon" href="https://v4-alpha.getbootstrap.com/favicon.ico">

    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/static/css/dashboard.css" rel="stylesheet">
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>--%>

    <style>
        .ofset {
            padding-left: 30px;
            padding-right: 30px;
        }
    </style>
    <style>
        .dropdown {
            padding-top: 5px;
            padding-bottom: 5px;
            padding-left: 10px;
            padding-right: 10px;
        }
    </style>
    <style>
        .contmenu {
            /*padding-top: 5px;*/
            /*padding-bottom: 5px;*/
            padding-left: 5px;
            padding-right: 5px;
        }
    </style>
</head>

<body>
<div id="wrapper">
    <div id="header">
        <div class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
            <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse"
                    data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="https://v4-alpha.getbootstrap.com/examples/dashboard/#">PaymentCard</a>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="#">User</a></li>
                    <li><a href="#">Выйти</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div id="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">

                    <div class="dropdown ofset">
                        <button class="btn btn-primary dropdown-toggle btn-block" type="button" data-toggle="dropdown">
                            Показать
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu contmenu">
                            <button type="button" class="btn btn-link" onclick="getUsers();">Список пользователей</button>
                            <button type="button" class="btn btn-link" onclick="getOwners();">Список владельцев</button>
                            <button type="button" class="btn btn-link" onclick="getDrivers();">Список водителей</button>
                        </ul>
                    </div>


                    <div class="dropdown ofset">
                        <button class="btn btn-primary dropdown-toggle btn-block" type="button" data-toggle="dropdown">
                            Добавить
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu contmenu">
                            <button type="button" class="btn btn-link" onclick="getUser();">Пользователя</button><br/>
                            <button type="button" class="btn btn-link" onclick="getUser();">Компанию</button><br/>
                            <button type="button" class="btn btn-link" onclick="getUser();">Карту</button><br/>
                            <button type="button" class="btn btn-link" onclick="getUser();">Машину</button><br/>
                        </ul>
                    </div>
                    <div class="dropdown">
                    <button type="button" class="btn btn-primary ofset btn-block" onclick="deleteUser()">Удалить</button>
                    </div>
            </div>

            </div>
        </div>


        <div id="head" class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">

        </div>


        <%--контекстное меню для таблиц--%>

        <script>
            $('#dataTable').bootstrapTable({
                contextMenu: '#example3-context-menu',
                contextMenuTrigger: 'both',
                onClickRow: function(row, $el){
                    $('#dataTable').find('.success').removeClass('success');
                    $el.addClass('success');
                },
                onContextMenuItem: function(row, $el){
                    if($el.data("item") == "edit"){
                        alert("Edit: " + row.itemid + ' ' + row.name + ' ' + row.price);
                    } else if($el.data("item") == "delete"){
                        alert("Delete: " + row.itemid + ' ' + row.name + ' ' + row.price);
                    } else if($el.data("item") == "action1"){
                        alert("Action1: " + row.itemid + ' ' + row.name + ' ' + row.price);
                    } else if($el.data("item") == "action2"){
                        alert("Action2: " + row.itemid + ' ' + row.name + ' ' + row.price);
                    }
                }
            });
        </script>
        <ul id="example3-context-menu" class="dropdown-menu">
            <li data-item="edit"><a>Edit</a></li>
            <li data-item="delete"><a>Delete</a></li>
            <li data-item="action1"><a>Action Here</a></li>
            <li data-item="action2"><a>And Action Here</a></li>
        </ul>

    </div>
    <div id="footer">

    </div>
</div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/static/css/jquery-3.2.1.js"></script>

<%--<script src="/static/css/jquery-3.1.1.slim.min.js"--%>
<%--integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"--%>
<%--crossorigin="anonymous"></script>--%>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="/static/css/tether.min.js"
        integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
        crossorigin="anonymous"></script>
<script src="/static/css/admin.js"></script>
<script src="/static/css/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/static/css/ie10-viewport-bug-workaround.js"></script>


</body>
</html>