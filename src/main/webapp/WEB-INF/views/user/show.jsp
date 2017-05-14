<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <link href="http://cdn.datatables.net/buttons/1.3.1/css/buttons.bootstrap.min.css">
    <link href="/static/css/welcome_css/colorbox.css" rel="stylesheet">
    <link href="/static/css/welcome_css/templatemo_style.css"  rel="stylesheet">
    <link href="/static/images/favicon%20(3).ico" rel="shortcut icon" type="image/x-icon" />

    <script type="text/javascript" src="http://cdn.datatables.net/buttons/1.3.1/js/buttons.bootstrap.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="http://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js"></script>
    <script type="text/javascript" src="http://cdn.datatables.net/buttons/1.3.1/js/buttons.flash.min.js"></script>
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
    <script type="text/javascript" src="http://cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/pdfmake.min.js"></script>
    <script type="text/javascript" src="http://cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/vfs_fonts.js"></script>
    <script type="text/javascript" src="http://cdn.datatables.net/buttons/1.3.1/js/buttons.html5.min.js"></script>
    <script type="text/javascript" src="http://cdn.datatables.net/buttons/1.3.1/js/buttons.print.min.js"></script>
    <script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
 </head>
<body>
<jsp:include page="header.jsp" />
<table id="myTable">
    <thead>
        <tr>
            <th>Номер изменения</th>
            <th>Карта</th>
            <th>Баланс</th>
            <th>Время</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${card.balanceHists}" var="balanceHists">
        <tr>
            <td>${balanceHists.balanceHistId}</td>
            <td>${balanceHists.cardId}</td>
            <td>${balanceHists.changes}</td>
            <td>${balanceHists.dateEvent}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script>
    $(document).ready(function () {
        $('#myTable').DataTable({
            "processing": true,
            "pageLength": 5,
            "dom": 'Bfrtip',
            buttons: [

                        'copy',
                        'excel',
                        'csv',
                        'pdf',
                        'print'
                    ],
            "language": {
                "url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/Russian.json"
            }
        });
    });
</script>
</body>
</html>