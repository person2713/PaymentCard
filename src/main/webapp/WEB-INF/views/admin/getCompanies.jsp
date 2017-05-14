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
            <th>Название компании</th>
            <th>Телефонный номер</th>
            <th>Баланс</th>
            <th>Город</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${companies}" var="company">
            <tr>
                    <%--с ним не работает--%>
                    <%--<td style="display:none">${person.personId}</td>--%>
                <td>${company.companyName}</td>
                <td>${company.phoneNumber}</td>
                <td>${company.compBalance}</td>
                <td>${company.city.cityName}</td>
                <td><input type="checkbox" value=""/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>