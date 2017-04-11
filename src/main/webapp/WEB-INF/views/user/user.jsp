<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User page</title>
</head>
<body>
	Dear <strong>${user}</strong>, Welcome to user Page.
	User Name: <b>${user}</b>
	<a href="<c:url value="/logout" />">Logout</a>





	<div class="generic-container">

		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading"><span class="lead">List of Users </span></div>
			<table class="table table-hover">
				<thead>
				<tr>
					<th>CardId</th>





				</tr>
				</thead>
				<tbody>
				<c:forEach items="${blockCards}" var="card">
					<tr>
						<td>${card.cardId}</td>
					</tr>
				</c:forEach>

				</tbody>
			</table>
		</div>

	</div>


</body>
</html>