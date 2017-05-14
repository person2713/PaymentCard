<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="header.jsp"/>
<head>
</head>

<body>

<div id="content">
    <div class="container-fluid">
        <table id="myTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Никнейм</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Город</th>
                <th>Мобильный телефон</th>
                <th>Почта</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                        <%--с ним не работает--%>
                        <%--<td style="display:none">${person.personId}</td>--%>
                    <td>${user.nickname}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.city.cityName}</td>
                    <td>${user.mobileNumber}</td>
                    <td>${user.email}</td>
                    <td><input type="checkbox" value=""/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>