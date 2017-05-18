<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="navbar navbar-inner navbar-fixed-bottom">
	<p><center class="text-muted">© Netcracker Education Center 2017</center></p>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<spring:url value="/static/js/user_js/hello.js" var="coreJs" />
<spring:url value="/static/js/user_js/bootstrap.min.js" var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>


