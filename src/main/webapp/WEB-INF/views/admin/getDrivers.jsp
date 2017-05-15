<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="header.jsp"/>
<head>
</head>
<body>
<div id="content">
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
            <th>Действия</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${drivers}" var="driver">
            <tr>
                <td>${driver.person.personId}</td>
                <td>${driver.person.nickname}</td>
                <td>${driver.person.firstName}</td>
                <td>${driver.person.lastName}</td>
                <td>${driver.person.city.cityName}</td>
                <td>${driver.person.mobileNumber}</td>
                <td>${driver.person.email}</td>
                <%--<td><input type="checkbox" value=""/></td>--%>
                <td>
                    <spring:url value="/admin/allDrivers/${driver.driverId}/delete" var="deleteUrl"/>
                    <spring:url value="/admin/allDrivers/${driver.driverId}/edit" var="editUrl"/>

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