<%--
  Created by IntelliJ IDEA.
  User: Nick
  Date: 12.03.2017
  Time: 8:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>4team</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/welcome.css" />" >

</head>
<body>
<h1>Welcome to project 4team</h1>
<a href="<c:url value="/login" />">Login</a>
<a href="<c:url value="/registration" />">Registrationr</a>
</body>
</html>

