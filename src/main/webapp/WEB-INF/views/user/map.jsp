<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Simple markers</title>
    <style>
        html,body,#map-canvas {
            height: 100%;
            margin: 0px;
            padding: 0px
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
                zoom : 12,
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
<body>
<div id="map-canvas"></div>
</body>
</html>