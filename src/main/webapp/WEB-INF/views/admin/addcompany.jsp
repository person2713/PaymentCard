<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add new Company Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
</head>

<body>
<div class="generic-container">
    <%--<%@include file="header.jsp" %>--%>

    <div class="well lead">User Registration Form</div>
    <form:form method="POST" modelAttribute="companyForm" action="/admin/addcompany/newCompany" class="form-horizontal">

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="companyName">Company name</label>
                <div class="col-md-7">
                    <form:input type="text" path="companyName" id="companyName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="companyName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="phoneNumber">Phone number</label>
                <div class="col-md-7">
                    <form:input type="text" path="phoneNumber" id="phoneNumber" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="phoneNumber" class="help-inline"/>
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
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a
                            href="<c:url value='/admin' />">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a
                            href="<c:url value='/admin' />">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
