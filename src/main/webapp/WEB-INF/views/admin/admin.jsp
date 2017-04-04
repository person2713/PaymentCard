<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin page</title>
</head>
<body>
	Dear <strong>${user}</strong>, Welcome to Admin Page. <br>
	<a href="<c:url value="/admin/getAlluser"/> ">getAlluser</a> <br>
	<a href="<c:url value="/admin/getAllcompany"/> ">getAllcompany</a> <br>
	<a href="<c:url value="/admin/addcompany"/> ">AddCompany</a> <br>
	<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>