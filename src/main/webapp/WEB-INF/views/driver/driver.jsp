<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Driver page</title>
</head>
<body>
	Dear <strong>${user}</strong>, Welcome to driver Page.
	<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>