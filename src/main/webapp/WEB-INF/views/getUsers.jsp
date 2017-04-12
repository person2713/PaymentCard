<%--
  Created by IntelliJ IDEA.
  User: Nick
  Date: 11.04.2017
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading"><span class="lead">List of Users </span></div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Nickname</th>
            <%--<th>Password</th>--%>
            <th>First name</th>
            <th>Last name</th>
            <th>city name</th>
            <th>mobile number</th>
            <th>email</th>
            <th>role</th>
            <%--<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">--%>
            <%--<th width="100"></th>--%>
            <%--</sec:authorize>--%>
            <%--<sec:authorize access="hasRole('ADMIN')">--%>
            <%--<th width="100"></th>--%>
            <%--</sec:authorize>--%>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${persons}" var="persons">
            <tr>
                <td>${persons.personId}</td>
                <td>${persons.nickname}</td>
                    <%--<td>${persons.password}</td>--%>
                <td>${persons.firstName}</td>
                <td>${persons.lastName}</td>
                <td>${persons.city.getCityName()}</td>
                <td>${persons.mobileNumber}</td>
                <td>${persons.email}</td>
                <td>${persons.role.roleType}</td>
                    <%--<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">--%>
                    <%--<td><a href="<c:url value='/edit-user-${user.ssoId}' />" class="btn btn-success custom-width">edit</a></td>--%>
                    <%--</sec:authorize>--%>
                    <%--<sec:authorize access="hasRole('ADMIN')">--%>
                    <%--<td><a href="<c:url value='/delete-user-${user.ssoId}' />" class="btn btn-danger custom-width">delete</a></td>--%>
                    <%--</sec:authorize>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
