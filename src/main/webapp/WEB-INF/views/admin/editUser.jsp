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
    <div class="container">
        <div class="row">
            <div style="margin: 0 auto;">
                <form id="changeForm" class="form-horizontal" role="form">
                    <input id="inputID" class="form-control" type="text" style="visibility:hidden">
                    <div class="form-group">
                        <label class="control-label">Ник:</label>
                        <div>
                            <input id="inputNick" class="form-control" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Имя:</label>
                        <div>
                            <input id="inputFirstname" class="form-control" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Фамилия:</label>
                        <div>
                            <input id="inputLastname" class="form-control" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Мобильный телефон:</label>
                        <div>
                            <input id="inputMobile" class="form-control" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Электронная почта:</label>
                        <div>
                            <input id="inputEmail" class="form-control" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Город:</label>
                        <div>
                            <div class="ui-select">
                                <select id="cities" class="form-control">
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Роль:</label>
                        <div>
                            <div class="ui-select">
                                <select id="rollers" class="form-control">
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Пароль:</label>
                        <div>
                            <input id="inputPassword1" class="form-control" type="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Подтвердите пароль:</label>
                        <div>
                            <input id="inputPassword2" class="form-control" type="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label"></label>
                        <div>
                            <div class="row">
                                <div class="ofset">
                                    <button type="button" class="btn btn-primary" onclick="saveChangesForUsers();">
                                        Сохранить
                                    </button>
                                    <br>
                                </div>
                                <span></span>
                                <div>
                                    <button type="button" class="btn btn-default" onclick="Cancel();">Отменить
                                    </button>
                                    <br>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</div>

<script>
    $(document).ready(function () {
        var userInfo = JSON.parse(window.localStorage.getItem("userInfo"));
        getCities().done(
            getRollers().done(function () {
                document.getElementById("inputID").value = userInfo[0];
                document.getElementById("inputNick").value = userInfo[1];
                document.getElementById("inputFirstname").value = userInfo[2];
                document.getElementById("inputLastname").value = userInfo[3];
                document.getElementById("inputMobile").value = userInfo[4];
                document.getElementById("inputEmail").value = userInfo[5];
                document.getElementById("cities").value = userInfo[6];
                document.getElementById("rollers").value = userInfo[8];
//                $("#cities").val(rowInfo[6]);
//                $("#rollers").val(rowInfo[8]);
                // $('cities option:contains(rowInfo[6])').prop('selected',true);
                document.getElementById("inputPassword1").value = userInfo[7];
                document.getElementById("inputPassword2").value = userInfo[7];
                userInfo = [];
            }))
    })


    var cities = [];
    var city = '';
    function getCities() {

        return $.ajax({
            type: "GET",
            url: "/admin/getCities",
            datatype: "json",
            success: function (response) {
                $.each(response, function (i, item) {
//                    city += '<option>' + item.cityName + '</option>';
                    city += '<option>' + item + '</option>';
                    cities.push(item);
                });
//                console.log(city);
                $("#cities").append(city);
            },
            error: function () {
                alert("error")
            }
        })
    }


    var rollers = [];
    var role = '';
    function getRollers() {
        return $.ajax({
            type: "GET",
            url: "/admin/getRollers",
            datatype: "json",
            success: function (response) {
                $.each(response, function (i, item) {
                    role += '<option>' + item.roleType + '</option>';
                    rollers.push(item);
                });
                $("#rollers").append(role);
                role = '';
            },
            error: function () {
                alert("error")
            }
        })
    }

    // массив для сохранения изменений
    var massChanges = [];

    // метод для сохранении информации о пользователе, например после редактирования
    function saveChangesForUsers() {
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");


        var fieldPass1 = $("#inputPassword1").val();
        var fieldPass2 = $("#inputPassword2").val();
        if(fieldPass1!=fieldPass2){
            alert("Пароли не совпадают!");
            return;
        }
        $("#changeForm").find('.form-control').each(function () {
            massChanges.push($(this).val());
        })

        console.log(massChanges);
        // })
        $.ajax({
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            url: "/admin/saveChangesForUsers",
            data: JSON.stringify(massChanges), // Note it is important
            beforeSend: function (xhr) {
                // here it is
                xhr.setRequestHeader(header, token);
            },
            success: function (result) {
                console.log("SUCCESS: ", result);
                alert("success" + result);
            }
        });
//        switch (massChanges[8]) {
//            case "USER":
//                getUsers();
//                break;
//            case "DRIVER":
//                getDrivers();
//                break;
//            case "OWNER":
//                getOwners();
//                break;
//        }
        alert("User edit successfully");
        massChanges = [];
        window.location = "http://localhost:8081/admin"
    }

    function Cancel() {
        window.location = "http://localhost:8081/admin"
    }
</script>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

</body>
</html>