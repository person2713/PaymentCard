<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="header.jsp" />

<div class="container">


    <h1>Update User</h1>

    <br />

    <spring:url value="/user/money" var="userActionUrl" />

    <form:form class="form-horizontal" method="post" modelAttribute="card" action="${userActionUrl}">

        <form:hidden path="cardId" />


        <spring:bind path="cardBalance.balance">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Name</label>
                <div class="col-sm-10">
                    <form:input path="cardBalance.balance" type="text" class="form-control " id="cardBalance.balance" placeholder="Баланс" />
                    <form:errors path="cardBalance.balance" class="control-label" />
                </div>
            </div>
        </spring:bind>









        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn-lg btn-primary pull-right">Update</button>
            </div>
        </div>
    </form:form>

</div>


</body>
</html>