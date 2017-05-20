<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Изменить пользователя</title>

    <link href="/static/css/boot.css" rel="stylesheet">
    <link href="/static/css/welcome_css/colorbox.css" rel="stylesheet">
    <link href="/static/css/welcome_css/templatemo_style.css"  rel="stylesheet">

</head>
<script type="text/javascript">
    function validate(){
        //Считаем значения из полей name и email в переменные x и y
        var x=document.forms["form"]["firstName"].value;
        var z=document.forms["form"]["lastName"].value;
        var y=document.forms["form"]["mobileNumber"].value;
        var re = /^(\+7)?\d{10}$/;
        var rename = /^[0-9A-Za-zА-Яа-я]{1,15}$/;
        //Если поле name пустое выведем сообщение и предотвратим отправку формы
        if (x.length==0){
            document.getElementById("firstNameF").innerHTML="*данное поле обязательно для заполнения";
            return false;
        }
        if (z.length==0){
            document.getElementById("lastNameF").innerHTML="*данное поле обязательно для заполнения";
            return false;
        }
        //Если поле email пустое выведем сообщение и предотвратим отправку формы
        if (!rename.test(x)){document.getElementById("err1").innerHTML="*Максимально 15 символов, буквы и цифры";
            return false;}
        if (!rename.test(z)){document.getElementById("err2").innerHTML="*Максимально 15 символов, буквы и цифры";
            return false;}



        if (!re.test(y)){document.getElementById("mobileNumberF").innerHTML="*Номер телефона введен не верно, введите в формате +7XXXXXXXXXX";
            return false;}





    }
    </script>
<body style="background-color: #EDEEF0">

    <div class="container">

        <legend><h2>Изменить пользователя</h2></legend>
        <spring:url value="/user/info" var="userActionUrl" />
        <form:form name="form" method="POST" modelAttribute="person" onsubmit="return (validate())" action="${userActionUrl}" class="form-horizontal">
            <form:hidden path="personId" />



            <div class="form-group">
                <label class="col-md-4 control-label" for="firstName">Имя</label>
                <div class="col-md-4">
                    <form:input type="text" path="firstName" id="firstName" class="form-control"/><span style="color:red" id="firstNameF"></span><span style="color:red" id="err1"></span>
                    <div class="has-error">
                        <form:errors path="firstName" class="help-inline"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="lastName">Фамилия</label>
                <div class="col-md-4">
                    <form:input type="text" path="lastName" id="lastName" class="form-control"/><span style="color:red" id="lastNameF"></span><span style="color:red" id="err2"></span>
                    <div class="has-error">
                        <form:errors path="lastName" class="help-inline"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="mobileNumber">Телефон</label>
                <div class="col-md-4">
                    <form:input type="text" path="mobileNumber" id="mobileNumber" class="form-control"/><span style="color:red" id="mobileNumberF"></span>
                    <div class="has-error">
                        <form:errors path="mobileNumber" class="help-inline"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label"></label>
                <div class="col-md-2">
                    <div class="text-center">
                        <input type="submit" value="Изменить" class="btn btn-success" onClick="return validate();" style="width: 100%"/>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="text-center">
                        <a href="/user" class="btn btn-orange" style="width: 100%">На главную</a>
                    </div>
                </div>
            </div>

        </form:form>
        <div class="navbar navbar-inner  navbar-fixed-bottom">
            <p>
            <center class="text-muted">© Netcracker Education Center 2017</center>
            </p>
        </div>
    </div>

</body>
</html>
