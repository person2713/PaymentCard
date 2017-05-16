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
    <div class="container-fluid">
        <table id="myTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>№</th>
                <th>Никнейм</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Город</th>
                <th>Мобильный телефон</th>
                <th>Почта</th>
                <th>Действие</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.personId}</td>
                    <td>${user.nickname}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.city.cityName}</td>
                    <td>${user.mobileNumber}</td>
                    <td>${user.email}</td>
                        <%--<td><input type="checkbox" value=""/></td>--%>
                    <td>
                        <spring:url value="/admin/allUsers/${user.personId}/delete" var="deleteUrl"/>
                        <spring:url value="/admin/allUsers/${user.personId}/edit" var="editUrl"/>

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
</div>

</body>
</html>