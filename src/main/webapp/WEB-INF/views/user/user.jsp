<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User page</title>
</head>
<body>
<%@include file="../header.jsp" %>

<div class="generic-container">

	<div class="panel panel-default">
		<!-- Default panel contents -->
		<div class="panel-heading"><span class="lead">List of Users </span></div>
		<table class="table table-hover">
			<thead>
			<tr>
				<th>CardId</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Balance</th>
				<th>BalanceHist</th>
				<th>Events</th>




			</tr>
			</thead>
			<tbody>
			<c:forEach items="${cards}" var="card">
				<tr>
					<td>${card.cardId}</td>
				</tr>
			</c:forEach>
			<td>${person.firstName}</td>
			<td>${person.lastName}</td>
			<td>${balance.balance}</td>
			<c:forEach items="${balanceHist}" var="bh">
				<tr>
					<td>${bh.changes}</td>
				</tr>
			</c:forEach>
			<c:forEach items="${events}" var="e">
				<tr>
					<td>${e.bus}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

</div>


</body>
</html>>