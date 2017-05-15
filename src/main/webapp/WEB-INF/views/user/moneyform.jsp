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
<body>
    <jsp:include page="header.jsp" />

    <div class="container">

        <spring:url value="/user/money" var="userActionUrl" />

        <form:form class="form-horizontal" method="post" modelAttribute="card" action="${userActionUrl}">

            <form:hidden path="cardId" />

            <h1>Пополнить баланс</h1>
            <br />
            <p><big>Введите необходимую сумму</big></p>
            <spring:bind path="cardBalance.balance">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="col-sm-3">
                        <form:input path="cardBalance.balance" type="text" class="form-control" id="cardBalance.balance" placeholder="Сумма" value="100"/>
                        <form:errors path="cardBalance.balance" class="control-label" />
                    </div>
                </div>
            </spring:bind>
            <button type="submit" class="btn btn-green"><span style="color: white">Пополнить</span></button>
        </form:form>
    </div>

    <jsp:include page="footer.jsp" />
</body>
</html>