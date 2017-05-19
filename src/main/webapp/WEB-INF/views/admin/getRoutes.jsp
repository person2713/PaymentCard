<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <link href="/static/css/welcome_css/colorbox.css" rel="stylesheet">
    <link href="/static/css/welcome_css/templatemo_style.css"  rel="stylesheet">
</head>
<body style="background-color: #EDEEF0">
<jsp:include page="header.jsp"/>
<div id="content">
    <h2>Список маршрутов</h2>
    <table id="myTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>№</th>
            <th>Номер маршрута</th>
            <th>Стоимость проезда</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${routes}" var="route">
            <tr>
                <td>${route.routeId}</td>
                <td>${route.routeNumber}</td>
                <td>${route.routePrice}</td>
                    <%--<td><input type="checkbox" value=""/></td>--%>
                <td>
                    <spring:url value="/admin/allRoutes/${route.routeId}/delete" var="deleteUrl"/>
                    <spring:url value="/admin/allRoutes/${route.routeId}/edit" var="editUrl"/>

                    <button class="btn btn-mapbtn"
                            onclick="location.href='${editUrl}'"><span style="color: white">Редактировать</span>
                    </button>
                    <button class="btn btn-cardblock"
                            onclick="location.href='${deleteUrl}'"><span style="color: white">Удалить</span>
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
