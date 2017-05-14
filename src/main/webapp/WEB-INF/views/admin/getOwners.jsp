<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:forEach items="${owners}" var="owner">
            <tr>
                    <%--с ним не работает--%>
                    <%--<td style="display:none">${person.personId}</td>--%>
                <td>${owner.person.nickname}</td>
                <td>${owner.person.firstName}</td>
                <td>${owner.person.lastName}</td>
                <td>${owner.person.city.cityName}</td>
                <td>${owner.person.mobileNumber}</td>
                <td>${owner.person.email}</td>
                <td><input type="checkbox" value=""/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>