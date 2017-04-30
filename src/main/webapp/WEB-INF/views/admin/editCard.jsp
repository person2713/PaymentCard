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
                        <label class="control-label">Название карты:</label>
                        <div>
                            <input id="cardName" class="form-control" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Ключ:</label>
                        <div>
                            <input id="cardKey" class="form-control" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Тип:</label>
                        <div>
                            <div class="ui-select">
                                <select id="cardType" class="form-control">
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Статус:</label>
                        <div>
                            <div class="ui-select">
                                <select id="cardStatus" class="form-control">
                                </select>
                            </div>
                        </div>
                    </div>
                    <input id="role" class="form-control" type="text" style="visibility:hidden">
                    <div class="form-group">
                        <label class="control-label"></label>
                        <div>
                            <div class="row">
                                <div class="ofset">
                                    <button type="button" class="btn btn-primary" onclick="saveChangesForCards();">Сохранить
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
//        console.log(userInfo);
            getTypeCard().done(function () {
                document.getElementById("inputID").value = userInfo[0];
                document.getElementById("cardName").value = userInfo[1];
                document.getElementById("cardKey").value = userInfo[2];
                document.getElementById("cardType").value = userInfo[3];
                document.getElementById("cardStatus").value = userInfo[4];

                userInfo = [];
            })
    })


    var cardsStatus = [];
    var cardStatus='';
    var cardType='';
    function getTypeCard() {

        return $.ajax({
            type: "GET",
            url: "/admin/getTypeCard",
            datatype: "json",
            success: function (response) {
                $.each(response, function (i, item) {
                    cardStatus += '<option>' + item.status + '</option>';
                    cardType += '<option>' + item.cardType + '</option>';
                    cardsStatus.push(item);
                });
                document.getElementById("cardType").insertAdjacentHTML('beforeend', cardType);
                document.getElementById("cardStatus").insertAdjacentHTML('beforeend', cardStatus);

            },
            error: function () {
                alert("error")
            }
        })
    }

    // массив для сохранения изменений
    var massChanges = [];
    // переменная для класса card
//    var card = {
//        "cardId" : 0,
//        "cardName" : '',
//        "person" : null,
//        "cardKey" : '',
//        "typeCard" : '',
//        "cardBalance" : null,
//        "balanceHists" : null,
//        "events" : null
//    }
    // метод для сохранении информации о пользователе, например после редактирования
    function saveChangesForCards() {
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");

        $("#changeForm").find('.form-control').each(function () {
            massChanges.push($(this).val());
        })

        console.log(massChanges);


        $.ajax({
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            url: "/admin/saveChangesForCards",
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
        alert("Card edit successfully");
        massChanges = [];
        window.location = "http://localhost:8081/admin"
    }
</script>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

</body>
</html>