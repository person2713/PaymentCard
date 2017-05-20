<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:choose>
        <c:when test="${edit}">
            <title>Редактировать карту</title>
        </c:when>
        <c:otherwise>
            <title>Добавить карту</title>
        </c:otherwise>
    </c:choose>


    <link href="/static/css/boot.css" rel="stylesheet">
    <link href="/static/css/welcome_css/colorbox.css" rel="stylesheet">
    <link href="/static/css/welcome_css/templatemo_style.css" rel="stylesheet">


</head>


<script type="text/javascript">
    function validate() {
        //Считаем значения из полей name и email в переменные x и y
        var cardName = document.forms["form"]["cardName"].value;
//        var regex = /^[А-Я]{1}[0-9]{3}[А-Я]{2}$/;
        //Если длина имени карточки больше 30 символов
        if (cardName.length > 30) {
            document.getElementById("cardName1").innerHTML = "*Имя карты не должно содержать более 30 символов";
            return false;
        }
//        //Если номер автобуса введен в неверном формате
//        if (!regex.test(cardName)) {
//            document.getElementById("busNumber1").innerHTML = "*Номер автобуса введен не в верном формате. Введите в следующем формате А123ИР";
//            return false;
//        }


    }
</script>

<body style="background-color: #EDEEF0">
<div class="container">


    <c:choose>
        <c:when test="${edit}">
            <legend><h2>Редактировать карту</h2></legend>
            <spring:url value="/admin/allCards/editCard" var="userActionUrl"/>
        </c:when>
        <c:otherwise>
            <legend><h2>Добавить карту</h2></legend>
            <spring:url value="/admin/addCard/newCard" var="userActionUrl"/>
        </c:otherwise>
    </c:choose>

    <form:form name="form" method="POST"  modelAttribute="cardForm" onsubmit="return (validate())" action="${userActionUrl}" class="form-horizontal">
        <form:input type="hidden" path="cardId" id="cardId"/>



        <c:choose>
            <c:when test="${edit}">
                <form:input type="hidden" path="cardBalance.balanceId" id="cardBalance.balanceId"/>
            </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>

        <div class="form-group">
            <label class="col-md-4 control-label" for="cardName">Имя карты</label>
            <div class="col-md-4">
                <form:input type="text" path="cardName" id="cardName" class="form-control"/>
                <span style="color:red" id="cardName1"></span>
                <div class="has-error">
                    <span style="color:red">
                        <form:errors path="cardName" class="help-inline"/>
                    </span>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="cardKey">Ключ карты</label>
            <div class="col-md-4">
                <form:input type="text" path="cardKey" id="cardKey" class="form-control"/>
                <div class="has-error">
                    <span style="color:red">
                        <form:errors path="cardKey" class="help-inline"/>
                    </span>
                </div>
            </div>
        </div>



        <c:choose>
            <c:when test="${edit}">
                <div class="form-group">
                    <label class="col-md-4 control-label" for="cardBalance.balance">Баланс</label>
                    <div class="col-md-4">
                        <form:input type="text" path="cardBalance.balance" id="cardBalance.balance" class="form-control"/>
                        <div class="has-error">
                            <span style="color:red">
                                <form:errors path="cardBalance.balance" class="help-inline"/>
                            </span>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${edit}">
                <div class="form-group" style="display:none;">
                    <label class="col-md-4 control-label" for="personId">Выберите пользователя</label>
                    <div class="col-md-4">
                        <form:select path="personId" class="form-control">
                            <%--<form:option value="NONE" label=""/>--%>
                            <form:options items="${persons}" multiple="false" itemValue="personId"
                                          itemLabel="nickname"/>
                            <div class="has-error">
                                <span style="color:red">
                                    <form:errors path="personId" class="help-inline"/>
                                </span>
                            </div>
                        </form:select>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="personId">Выберите пользователя</label>
                    <div class="col-md-4">
                        <form:select path="personId" class="form-control">
                            <%--<form:option value="NONE" label=""/>--%>
                            <form:options items="${persons}" multiple="false" itemValue="personId"
                                          itemLabel="nickname"/>
                            <div class="has-error">
                                <span style="color:red">
                                    <form:errors path="personId" class="help-inline"/>
                                </span>
                            </div>
                        </form:select>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
            
        <c:choose>
            <c:when test="${edit}">
                <div class="form-group">
                    <label class="col-md-4 control-label" for="typeCard">Статус карточки</label>
                    <div class="col-md-4">
                        <form:select path="typeCard" class="form-control">
                            <%--<form:option value="NONE" label=""/>--%>
                            <form:options items="${typeCard}" multiple="false" itemValue="typeId" itemLabel="status"/>
                            <div class="has-error">
                                <span style="color:red">
                                    <form:errors path="typeCard" class="help-inline"/>
                                </span>
                            </div>
                        </form:select>
                    </div>
                </div>
            </c:when>
            <c:otherwise>

            </c:otherwise>
        </c:choose>


        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <c:choose>
                    <c:when test="${edit}">
                        <div class="col-md-6">
                            <div class="text-center">
                                <input type="submit" value="Редактировать" class="btn btn-success" onClick="return validate();" style="width: 100%"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="text-center">
                                <a href="/admin/allCards" class="btn btn-orange" style="width: 100%">Отмена</a>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="col-md-6">
                            <div class="text-center">
                                <input type="submit" value="Добавить" class="btn btn-success" onClick="return validate();" style="width: 100%"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="text-center">
                                <a href="/admin" class="btn btn-orange" style="width: 100%">Отмена</a>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
    <div class="navbar navbar-inner  navbar-fixed-bottom">
        <p>
        <center class="text-muted">© Netcracker Education Center 2017</center>
        </p>
    </div>
</div>
</body>
</html>