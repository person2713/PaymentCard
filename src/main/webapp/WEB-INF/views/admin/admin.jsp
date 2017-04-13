<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- saved from url=(0054)https://v4-alpha.getbootstrap.com/examples/dashboard/# -->
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://v4-alpha.getbootstrap.com/favicon.ico">

    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/bootstraptheme-min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/static/css/dashboard.css" rel="stylesheet">
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
                        <ul class="dropdown-menu">
                            <script type="text/javascript">
                                function doAjaxPost() {

                                    $.ajax({
                                        type: "GET",
                                        url: "/admin/getlAllUsers",
                                        datatype: "json",
                                        success: function (response) {


                                            var trHTML = '';
                                            $.each(response, function (i, item) {
                                                trHTML += '<tr><td>' +
                                                    item.nickname + '</td><td>' +
                                                    item.firstName + '</td><td>' +
                                                    item.lastName + '</td><td>' +
                                                    item.mobileNumber + '</td><td>' +
                                                    item.email + '</td><td>'+
                                                    item.city.cityName + '</td><td>' +
                                                    item.role.roleType + '</td><td>' +
                                                    '<input type="checkbox" value=""/>'
                                                    '</td></tr>';
                                            });
                                            $("#dataTable").append(trHTML);
                                        },
                                        error: function () {
                                            alert("error")
                                        }
                                    });
                                        }
                            </script>
                            <li><input type="button" value="GO!" onclick="doAjaxPost();"/></li>
                            <li><a href="#">Список владельцев</a></li>


                            <li><a href="#">Список водителей</a></li>
                            <li><a href="#">Список компаний</a></li>
                            <li><a href="#">Список карт</a></li>
                            <li><a href="#">Список машин</a></li>
                        </ul>
                    </div>


                    <div class="dropdown ofset">
                        <button class="btn btn-primary dropdown-toggle btn-block" type="button" data-toggle="dropdown">
                            Добавить
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu ">
                            <li><a href="#">Пользователя</a></li>
                            <li><a href="#">Компанию</a></li>
                            <li><a href="#">Карту</a></li>
                            <li><a href="#">Машину</a></li>
                        </ul>
                    </div>

                    <div class="dropdown ofset">
                        <button class="btn btn-primary dropdown-toggle btn-block" type="button" data-toggle="dropdown">
                            Удалить
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                            <li><a href="#">Пользователя</a></li>
                            <li><a href="#">Компанию</a></li>
                            <li><a href="#">Карту</a></li>
                            <li><a href="#">Машину</a></li>
                        </ul>
                    </div>

                    <div>
                        <input type="button" value="Delete" onclick="doAjaxPost();"/>
                    </div>

                    <script type="text/javascript">
                        function doGetJson() {

                            var obj=new Object();
                            obj.sm=startMonth;
                            obj.sd=startDay;
                            obj.em=endMonth;
                            obj.ed=endDay;

                            var jsonDate= JSON.stringify(obj);

                            $.ajax({
                                type: 'POST',
                                dataType: 'json',
                                url:"/admin/getJson",
                                data:jsonDate,

                                success: function(response) {//upto this line from my browser debugger it works
                                    if (response == jsonDate)
                                    {
                                        alert("success and json passed");
                                    } else {
                                        alert("not success"+response);
                                    }
                                },
                                error:function(xhr, errorType, exception) {

                                    alert("inside error function 1(xhr)"+JSON.stringify(xhr));
                                    alert("inside error function 2(errorType)"+errorType);
                                    alert("inside error function 3(exception)"+exception);
                                }
                            });
                        }
                    </script>
                    <li><input type="button" value="GO!" onclick="doGetJson();"/></li>
                    <li><a href="#">Список владельцев</a></li>
                </div>

            </div>
        </div>


        <div class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
            <h2>Section title</h2>
            <div class="table-responsive">
                <table id="dataTable" class="table table-striped">
                    <thead>
                    <tr>
                        <th>Nickname</th>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>mobile number</th>
                        <th>email</th>
                        <th>city</th>
                        <th>role</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>


    </div>
    <div id="footer">

    </div>
</div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<%--<script src="/static/css/jquery-3.1.1.slim.min.js"--%>
<%--integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"--%>
<%--crossorigin="anonymous"></script>--%>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="/static/css/tether.min.js"
        integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
        crossorigin="anonymous"></script>
<script src="/static/css/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/static/css/ie10-viewport-bug-workaround.js"></script>


</body>
</html>