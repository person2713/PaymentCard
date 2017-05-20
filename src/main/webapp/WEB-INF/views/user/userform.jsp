<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="ru">
<head>
	<link href="/static/css/welcome_css/colorbox.css" rel="stylesheet">
	<link href="/static/css/welcome_css/templatemo_style.css"  rel="stylesheet">
</head>

<body style="background-color: #EDEEF0">
	<jsp:include page="header.jsp" />

	<div class="container">

		<spring:url value="/user/user" var="userActionUrl" />
		<form:form class="form-horizontal" method="post" modelAttribute="card" action="${userActionUrl}">

			<form:hidden path="cardId" />
			<h1>Переименовать карту</h1>
			<br />
			<p><big>Введите новое название</big></p>

			<spring:bind path="cardName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<div class="col-sm-3">
						<form:input path="cardName" type="text" class="form-control " id="cardName" placeholder="Имя карты" />
						<span style="color:red">
							<form:errors path="cardName" class="control-label" />
						</span>
					</div>
				</div>
			</spring:bind>

			<button type="submit" class="btn btn-green"><span style="color: white">Переименовать</span></button>
			<a class="btn btn-orange" href="/user"><span style="color: white">На главную</span></a>

		</form:form>

	</div>

</body>
</html>