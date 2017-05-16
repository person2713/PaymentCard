<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Simple markers</title>
    <link href="/static/css/welcome_css/bootstrap.css" rel="stylesheet">
    <link href="/static/css/welcome_css/colorbox.css" rel="stylesheet">
    <link href="/static/css/welcome_css/templatemo_style.css"  rel="stylesheet">
    <style>
        html,body,#map-canvas {
            margin-left: auto;
            margin-right: auto;
        }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBBavO2qpOK7q-FSXHh201v4gT-9PlCcGk&callback=3.exp"></script>
    <script>
        function initialize() {

            var markerLat, markerLong;
            markerLat = [
            <c:forEach var="s" items="${events}">
            <c:out value="${s.latitude}"/>,
            </c:forEach>
            ];
            markerLong = [
            <c:forEach var="s" items="${events}">
            <c:out value="${s.longitude}"/>,
            </c:forEach>
            ];

            var myLatlng = new google.maps.LatLng(51.663223, 39.227202);
            var mapOptions = {
                zoom : 14,
                center : myLatlng
            }
            var map = new google.maps.Map(document.getElementById('map-canvas'),
                mapOptions);


            for (i = 0; i < markerLat.length; i++) {
                marker = new google.maps.Marker({
                    position: new google.maps.LatLng(markerLat[i], markerLong[i]),
                    map: map
                })

                marker.setMap(map);

            }
        }
        google.maps.event.addDomListener(window, 'load', initialize);
    </script>
</head>
<spring:url value="http://localhost:9000/user" var="urlHome" />

<body style="background-color: #EDEEF0">
    <jsp:include page="header.jsp" />
    <div class="container"></div>
        <div class="row">
            <div class="col-md-12">
                <div class="text-center">
                    <div id="map-canvas" style="width: 700px; height: 450px" ></div>
                    <br>
                    <a class="btn btn-orange" href="${urlHome}"><span style="color: white">На главную</span></a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>