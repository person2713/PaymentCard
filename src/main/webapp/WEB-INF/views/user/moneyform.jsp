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
<script type="text/javascript">
    function validate(){
        //Считаем значения из полей name и email в переменные x и y
        var inputMoney = document.forms["form"]["cardBalance.balance"].value;
        var check = /^[0-9]{5}$/;
        //Если поле name пустое выведем сообщение и предотвратим отправку формы
        if (inputMoney.length==0){
            document.getElementById("err1").innerHTML="*данное поле обязательно для заполнения";
            return false;
        }
        if (inputMoney<0){
            document.getElementById("err3").innerHTML="*введите неотрицательное число";
            return false;
        }
        //Если поле email пустое выведем сообщение и предотвратим отправку формы
        if (check.test(inputMoney)){document.getElementById("err2").innerHTML="*Максимальная сумма пополнения - 9999, введите целое число";
            return false;}
       }
</script>


<body style="background-color: #EDEEF0">
    <jsp:include page="header.jsp" />

    <div class="container">

        <spring:url value="/user/money" var="userActionUrl" />

        <form:form name="form" class="form-horizontal" method="post" onsubmit="return (validate())" modelAttribute="card" action="${userActionUrl}">

            <form:hidden path="cardId" />

            <h1>Пополнить баланс</h1>
            <br />
            <p><big>Введите необходимую сумму</big></p>
            <spring:bind path="cardBalance.balance">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="col-sm-3">
                        <form:input path="cardBalance.balance" type="text" class="form-control" name="cardBalance.balance" id="cardBalance.balance" placeholder="Сумма" value="100"/><span style="color:red" id="err1"></span><span style="color:red" id="err2"></span><span style="color:red" id="err3"></span>
                        <form:errors path="cardBalance.balance" class="control-label" />
                    </div>
                </div>
            </spring:bind>
            <button type="submit" onClick="return validate();" class="btn btn-green"><span style="color: white">Пополнить</span></button>
            <a class="btn btn-orange" href="/user"><span style="color: white">На главную</span></a>
        </form:form>
    </div>

    <jsp:include page="footer.jsp" />
</body>
</html>