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

    <title>Payment Card</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/static/css/dashboard.css" rel="stylesheet">
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>--%>
    <script src="${pageContext.request.contextPath}/static/css/jquery-3.2.1.js"></script>

    <script src="${pageContext.request.contextPath}/static/css/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/static/css/admin.js"></script>
    <script src="${pageContext.request.contextPath}/static/css/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/css/bootstrap-table-contextmenu.js"></script>
    <script src="${pageContext.request.contextPath}/static/css/bootstrapTable/bootstrap-table.js"></script>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${pageContext.request.contextPath}/static/css/ie10-viewport-bug-workaround.js"></script>


    <style>
        .dropdown-menu{position:absolute;top:100%;left:0;z-index:1000;display:none;float:left;min-width:160px;padding:5px 0;margin:2px 0 0;font-size:14px;text-align:left;list-style:none;background-color:#fff;-webkit-background-clip:padding-box;background-clip:padding-box;border:1px solid #ccc;border:1px solid rgba(0,0,0,.15);border-radius:4px;-webkit-box-shadow:0 6px 12px rgba(0,0,0,.175);box-shadow:0 6px 12px rgba(0,0,0,.175)}
        .dropdown-menu>li>a{display:block;padding:3px 20px;clear:both;font-weight:400;line-height:1.42857143;color:#333;white-space:nowrap}
        /*.dropdown-menu>li>a:focus,*/
        /*.dropdown-menu>li>a:hover{color:#262626;text-decoration:none;background-color:#f5f5f5}*/
        /*.dropdown-menu>.active>a,*/
        /*.dropdown-menu>.active>a:focus,*/
        /*.dropdown-menu>.active>a:hover{color:#fff;text-decoration:none;background-color:#337ab7;outline:0}*/
        .dropdown-menu a {
            cursor: pointer;
        }
        .dropdown-menu .divider {
            height: 1px;
            margin: 8px 0;
            overflow: hidden;
            background-color: #ebebeb;
        }
        .dropdown-menu > li > a {
            position: relative;
            padding: 3px 30px;
        }
        .dropdown-menu > li > a .glyphicon {
            position: absolute;
            top: 4px;
            left: 7px;
        }
        .dropdown-menu li > a:hover,
        .dropdown-menu li > a:focus,
        .dropdown-submenu:hover > a,
        .dropdown-submenu:focus > a {
            color: #333;
            background-color: #eee;
            background-image: -webkit-linear-gradient(top, #eee 0%, #eee 100%);
            background-image:      -o-linear-gradient(top, #eee 0%, #eee 100%);
            background-image: -webkit-gradient(linear, left top, left bottom, from(#eee), to(#eee));
            background-image:         linear-gradient(to bottom, #eee 0%, #eee 100%);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffeeeeee', endColorstr='#ffeeeeee', GradientType=0);
            background-repeat: repeat-x;
        }
        .dropdown-menu > .active > a,
        .dropdown-menu > .active > a:hover,
        .dropdown-menu > .active > a:focus {
            color: #333;
            background-color: #eee;
            background-image: -webkit-linear-gradient(top, #eee 0%, #eee 100%);
            background-image:      -o-linear-gradient(top, #eee 0%, #eee 100%);
            background-image: -webkit-gradient(linear, left top, left bottom, from(#eee), to(#eee));
            background-image:         linear-gradient(to bottom, #eee 0%, #eee 100%);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffeeeeee', endColorstr='#ffeeeeee', GradientType=0);
            background-repeat: repeat-x;
        }

        .ofset {
            padding-left: 30px;
            padding-right: 30px;
        }


        .dropdown {
            padding-top: 5px;
            padding-bottom: 5px;
            padding-left: 10px;
            padding-right: 10px;
        }


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



        <ul id="context-menu" class="dropdown-menu">
            <li data-item="edit"><a>Edit</a></li>
            <li data-item="delete"><a>Delete</a></li>
            <li data-item="action1"><a>Action Here</a></li>
            <li data-item="action2"><a>And Action Here</a></li>
        </ul>

        <script>
            $(function () {
                $("#dataTable").bootstrapTable({
                    rowStyle: "rowStyle",
                    contextMenu: '#context-menu',
                    contextMenuTrigger: 'right',
                    onClickRow: function(row, $el){
                        $("#dataTable").find(".success").removeClass('success');
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
            });

            // Special row styling
            var striped = 1;
            var stripeClass = '';
            function rowStyle(row, index) {
                striped++;
                if(striped % 2 == 0){
                    stripeClass = 'striped';
                }
                else{
                    stripeClass = '';
                }

                return {
                    classes: stripeClass
                };
            }

        </script>
    </div>
    <div id="footer">

    </div>
</div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

</body>
</html>