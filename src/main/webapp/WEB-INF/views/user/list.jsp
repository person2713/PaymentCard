<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="ru">

<head>
	<%--<link href="/static/css/welcome_css/bootstrap.css" rel="stylesheet">--%>
	<link href="/static/css/welcome_css/colorbox.css" rel="stylesheet">
	<link href="/static/css/welcome_css/templatemo_style.css"  rel="stylesheet">
</head>

<body>
<jsp:include page="header.jsp" />

	<div class="container">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1>Все карты</h1>

		<div class="row">
			<div class="col-md-11">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Номер карты</th>
							<th>Имя карты</th>
							<th>Статус</th>
							<th>Баланс</th>
							<th>Действие</th>
						</tr>
					</thead>

					<c:forEach var="card" items="${card}">
						<tr>
							<td>${card.cardId}</td>
							<td>${card.cardName}</td>
							<td>${card.typeCard.status}</td>
							<td>${card.cardBalance.balance}</td>
							<td>
								<spring:url value="/user/user/${card.cardId}" var="userUrl" />
								<spring:url value="/user/user/${card.cardId}/block" var="deleteUrl" />
								<spring:url value="/user/user/${card.cardId}/update" var="updateUrl" />
								<spring:url value="/user/user/${card.cardId}/money" var="moneyUrl" />
                                <spring:url value="/user/user/${card.cardId}/map" var="mapUrl" />

								<button class="btn btn-infa" onclick="location.href='${userUrl}'"><span style="color: white">История</span></button>
								<button class="btn btn-change" onclick="location.href='${updateUrl}'"><span style="color: white">Изменить</span></button>
                                <button class="btn btn-mapbtn" onclick="location.href='${mapUrl}'"><span style="color: white">На карте</span></button>
								<button class="btn btn-addbalace" onclick="location.href='${moneyUrl}'"><span style="color: white">Пополнить баланс</span></button>
								<button class="btn btn-cardblock" onclick="location.href='${deleteUrl}'"><span style="color: white">Заблокировать</span></button></td>
              				</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>