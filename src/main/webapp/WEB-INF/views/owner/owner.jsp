<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Owner page</title>
</head>
<body>
	Dear <strong>${user}</strong>, Welcome to owner Page.
	<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>