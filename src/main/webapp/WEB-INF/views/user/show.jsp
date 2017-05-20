<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="ru">

<head>

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
    <script src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/pdfmake.min.js"></script>
    <script src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/vfs_fonts.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.html5.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.print.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.colVis.min.js"></script>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
    <link href="https://cdn.datatables.net/buttons/1.3.1/css/buttons.bootstrap.min.css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

    <link href="/static/css/welcome_css/bootstrap.css" rel="stylesheet">
    <link href="/static/css/welcome_css/colorbox.css" rel="stylesheet">
    <link href="/static/css/welcome_css/templatemo_style.css"  rel="stylesheet">

</head>

<body style="background-color: #EDEEF0">
<jsp:include page="header.jsp" />
<div class="text-center">
    <h4>Карта: ${card.cardName}</h4>
</div>
<table id="myTable"   class="table table-hover table-bordered table" cellspacing="0" width="100%">
    <thead>
        <tr>
            <th>Номер транзакции <i class="fa fa-fw fa-sort"></i></th>
            <th>Маршрут <i class="fa fa-fw fa-sort"></i></th>
            <%--<th>Баланс <i class="fa fa-fw fa-sort"></i></th>--%>
            <th>Время <i class="fa fa-fw fa-sort"></i></th>
            <th>На карте <i class="fa fa-fw fa-sort"></i></th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${card.events}" var="events">
    <%--<c:forEach items="${card.events}" var="events">--%>
        <tr>
            <td>${events.eventId}</td>
            <%--<td>${events.busId}</td>--%>
            <td>${events.busId}</td>
            <td>${events.paymentTime}</td>
            <td>
                <spring:url value="/user/user/${events.eventId}/mapone" var="mapUrl" />
                <button class="btn btn-mapbtn" onclick="location.href='${mapUrl}'"><span style="color: white">На карте</span></button></td>
        </tr>
    </c:forEach>
    <%--</c:forEach>--%>
    </tbody>
</table>
<script>
    $(document).ready(function() {
        var table = $('#myTable').DataTable( {
            "processing": true,
            dom:
            "<'row'<'col-sm-3'l><'col-sm-6 text-center'B><'col-sm-3'f>>" +
            "<'row'<'col-sm-12'tr>>" +
            "<'row'<'col-sm-5'i><'col-sm-7'p>>",

            buttons: [ 'copy', 'excel', 'pdf','csv','print', 'colvis' ],
            "language": {
                "url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/Russian.json"}
        } );

        table.buttons().container()
            .appendTo( '#example_wrapper .col-sm-6:eq(0)' );
    } );



</script>
</body>
</html>