<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Reset password</title>
    <link href="/static/images/favicon%20(3).ico" rel="shortcut icon" type="image/x-icon" />
</head>

<body>
<div id="mainWrapper">

    <c:url  value="/resetPass"/>
    <form action="/resetPassword/${email}" method="get" class="form-horizontal">


        <input type="text" class="form-control" id="email" name="email" placeholder="Enter Email" required>


        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <div class="form-actions">
            <input type="submit"
                   class="btn btn-block btn-primary btn-default" value="Email">
        </div>
    </form>
</div>


</body>
</html>