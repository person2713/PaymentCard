<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Registration Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
</head>

<body>
<div class="generic-container">
    <%--<%@include file="authheader.jsp" %>--%>

    <div class="well lead">User Registration Form</div>
    <form:form method="POST" modelAttribute="userForm" action="/registration/newUser" class="form-horizontal">
        <form:input type="hidden" path="personId" id="personId"/>


        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="nickname">Nickname</label>
                <div class="col-md-7">
                    <c:choose>
                        <c:when test="${edit}">
                            <form:input type="text" path="nickname" id="nickname" class="form-control input-sm"/>
                        </c:when>
                        <c:otherwise>
                            <form:input type="text" path="nickname" id="nickname" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="nickname" class="help-inline"/>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="password">Password</label>
                <div class="col-md-7">
                    <form:input type="password" path="password" id="password" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="password" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="firstName">First Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="firstName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="lastName">Last Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="lastName" id="lastName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="lastName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="mobileNumber">Mobile number</label>
                <div class="col-md-7">
                    <form:input type="text" path="mobileNumber" id="mobileNumber" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="mobileNumber" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="email">Email</label>
                <div class="col-md-7">
                    <form:input type="text" path="email" id="email" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="email" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="City">City</label>
                <div class="col-md-7">
                    <form:select path="city" items="${cities}" multiple="false" itemValue="cityId" itemLabel="cityName"
                                 class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="city" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">
                    <%--<c:choose>--%>
                    <%--<c:when test="${edit}">--%>
                    <%--<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>--%>
                    <%--</c:when>--%>
                    <%--<c:otherwise>--%>
                <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a
                    href="<c:url value='/list' />">Cancel</a>
                    <%--</c:otherwise>--%>
                    <%--</c:choose>--%>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>