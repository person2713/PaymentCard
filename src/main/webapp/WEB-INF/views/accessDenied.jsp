<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Доступ запрещен</title>
	<link href="/static/images/favicon%20(3).ico" rel="shortcut icon" type="image/x-icon" />

</head>
<body style="background-color: #EDEEF0">
	Извините <strong>${user}</strong>, Вы не авторизованы для просмотра этой страницы.
	<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>