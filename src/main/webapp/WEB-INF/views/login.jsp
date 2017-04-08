<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>

		<title>Login page</title>

	</head>

	<body>

						<c:url var="loginUrl" value="/login" />
						<form action="${loginUrl}" method="post" class="form-horizontal">
							<c:if test="${param.error != null}">

									<p>Invalid username and password.</p>

							</c:if>
							<c:if test="${param.logout != null}">

									<p>You have been logged out successfully.</p>

							</c:if>

								<input type="text" class="form-control" id="username" name="ssoId" placeholder="Enter Username" required>


								<input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>

							<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
								

								<input type="submit"
									class="btn btn-block btn-primary btn-default" value="Log in">

						</form>


	</body>
</html>