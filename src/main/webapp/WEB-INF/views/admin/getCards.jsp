<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="header.jsp"/>
<head>
</head>
<body style="background-color: #EDEEF0">
<div id="content">
    <table id="myTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>№</th>
            <th>Название карты</th>
            <th>Ключ</th>
            <th>Баланс</th>
            <th>Тип карты</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cards}" var="card">
            <tr>
                <td>${card.cardId}</td>
                <td>${card.cardName}</td>
                <td>${card.cardKey}</td>
                <td>${card.cardBalance.balance}</td>
                <td>${card.typeCard.status}</td>
                <%--<td><input type="checkbox" value=""/></td>--%>
                <td>
                    <spring:url value="/admin/allCards/${card.cardId}/delete" var="deleteUrl"/>
                    <spring:url value="/admin/allCards/${card.cardId}/edit" var="editUrl"/>

                    <button class="btn btn-primary"
                            onclick="location.href='${editUrl}'">Редактировать
                    </button>
                    <button class="btn btn-danger"
                            onclick="location.href='${deleteUrl}'">Удалить
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
