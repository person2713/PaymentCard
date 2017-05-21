<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Payment Card</title>

    <link href="/static/css/welcome_css/bootstrap.css" rel="stylesheet">
    <link href="/static/css/welcome_css/colorbox.css" rel="stylesheet">
    <link href="/static/css/welcome_css/templatemo_style.css" rel="stylesheet">
    <link href="/static/images/favicon%20(3).ico" rel="shortcut icon" type="image/x-icon"/>

    <script src="/static/js/welcome_js/jquery.min.js" type="text/javascript"></script>
    <script src="/static/js/welcome_js/bootstrap.min.js" type="text/javascript"></script>
    <script src="/static/js/welcome_js/stickUp.min.js" type="text/javascript"></script>
    <script src="/static/js/welcome_js/colorbox/jquery.colorbox.js" type="text/javascript"></script>
    <script src="/static/js/welcome_js/colorbox/jquery.colorbox-min.js" type="text/javascript"></script>
    <script src="/static/js/welcome_js/templatemo_script.js" type="text/javascript"></script>

    <%--api yandex--%>
    <%--<script src="https://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>--%>

    <%--google maps api--%>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>



</head>
<body style="background-color: #EDEEF0">
    <div class="templatemo-top-bar" id="templatemo-top">
        <div class="container">
            <div class="subheader">
                <div id="phone" class="pull-left">
                    <img src="/static/images/phone.png" alt="phone"/>
                    +7 999 720 80 38
                </div>
                <div id="email" class="pull-right">
                    <img src="/static/images/email.png" alt="email"/>
                    trebvit@gmail.com
                </div>
            </div>
        </div>
    </div>

    <div class="templatemo-top-menu">
        <div class="container">
            <!-- Static navbar -->
            <div class="navbar navbar-default" role="navigation">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a href="#" class="navbar-brand"><img src="/static/images/logo1.png" class="center-block" /></a>
                    </div>
                    <div class="navbar-collapse collapse" id="templatemo-nav-bar">
                        <ul class="nav navbar-nav navbar-right" style="margin-top: 30px;">
                            <li><a href="#templatemo-top">Главная</a></li>
                            <li><a href="#templatemo-about">Описание</a></li>
                            <li><a href="#templatemo-advantages">Преимущества</a></li>
                            <li><a href="#templatemo-scheme">Схемы транспорта</a></li>
                            <li><a href="#templatemo-commun">Контакты</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </div><!--/.navbar -->
        </div> <!-- /container -->
    </div>

    <div>
        <!-- Carousel -->
        <div id="templatemo-carousel" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="item active">
                    <img src="/static/images/templatemo_carousel_bg_s.jpg">
                    <div class="container">
                        <div class="carousel-caption">
                            <div class="text-center">
                                <h1>Payment Card system</h1>
                                <p>Пожалуйста, авторизуйтесь или зарегистрируйтесь.</p>
                            </div>

                            <div class="text-center">
                                <div class="col-md-8 col-md-offset-2">
                                    <div class="col-md-6">
                                        <div class="text-center">
                                            <a class="btn btn-lg btn-green" href="/login" role="button" style="width: 100%; margin-top: 20px; margin-bottom: 20px; overflow: hidden">Вход</a>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="text-center">
                                            <a class="btn btn-lg btn-orange" href="/registration" role="button" style="width: 100%; margin-top: 20px; margin-bottom: 20px; overflow: hidden">Регистрация</a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div><!-- /#templatemo-carousel -->
        </div>
    </div>


    <div id="templatemo-about" >
        <div class="container">
            <div class="row">
                <div class="templatemo-line-header" >
                    <div class="text-center">
                        <hr class="team_hr team_hr_left hr_gray"/><span class="txt_darkgrey text-center">Описание</span>
                        <hr class="team_hr team_hr_right hr_gray" />
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="text-center">
                <h3>Система безналичной оплаты проезда в общественном транспорте</h3>
            </div>
            <div class="clearfix"></div>
            <div class="row">
                <div class="col-md-6">
                    <br/>
                    <h3 class="text-center">Никакой мелочи!</h3>
                    <h5>Вам больше не придется таскать с собой тяжелый кошелек, набитый железными монетами.
                    Вам необходима всего лишь пластиковая карта.</h5>
                    <br/>
                    <h3 class="text-center">Простота использования!</h3>
                    <h5>Вам достаточно приобрести карту нашей системы в любом киоске рядом с остановкой транспорта или у водителя.<br/>
                    Достаточно приложить карту к считывателю и насладиться поездкой.<br/>
                    Считыватели установлены в каждом автобусе вашего города.</h5>
                    <br/>
                    <h3 class="text-center">Легкость обслуживания!</h3>
                    <h5>Пополнить баланс вашей карты можно в личном кабинете с помощью онлайн платежей.</h5>
                    <br/>
                    <h3 class="text-center">Безопасность!</h3>
                    <h5>В случае внештатной ситуации каждый зарегистрированный пользователь может заблокировать свою карту из личного кабинета
                    и сообщить об этом администратору. После чего баланс с заблокированной карты будет перечислен на другую зарегистрированную карту пользователя.</h5>
                </div>
                <div class="col-md-6">
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <img src="/static/images/for_about.png">
                </div>
            </div>
            <div class="clearfix"></div>

        </div><!-- /.container -->
    </div> <!-- /.templatemo-portfolio -->


    <div id="templatemo-advantages" >
        <div class="container">
            <div class="row">
                <div class="templatemo-line-header" >
                    <div class="text-center">
                        <hr class="team_hr team_hr_left hr_gray"/><span class="txt_darkgrey text-center">Преимущества</span>
                        <hr class="team_hr team_hr_right hr_gray" />
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>

            <div class="clearfix"></div>
            <div class="row">
                <div class="col-md-6">
                    <br/>
                    <h3 class="text-center">Для транспортных компаний</h3>
                    <h5>Наша система стремится к полной автоматизации городской транспортной системы,
                    а также облегчает ведение финансовой деятельности компании, что ведет к увеличению доходов.</h5>
                    <br/>
                    <h3 class="text-center">Для пользователей</h3>
                    <h5>Каждый пользователь может просматривать свою историю поездок в личном кабинете и контролировать свои расходы.</h5>
                    <br/>
                    <h3 class="text-center">Возможности</h3>
                    <h5>При оплате проезда каждой картой считываются координаты места оплаты, тем самым в будущем
                        будет составлена статистика загруженности городской транспортной системы. Что в лучшую сторону скажется<br/>
                        на трафике каждого города.
                    </h5>

                </div>
                <div class="col-md-6">
                    <div class="text-center">
                        <img src="/static/images/nuzhnoe.png">
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>

        </div><!-- /.container -->
    </div> <!-- /.templatemo-portfolio -->


    <div id="templatemo-scheme" >
        <div class="container">
            <div class="row">
                <div class="templatemo-line-header" >
                    <div class="text-center">
                        <hr class="team_hr team_hr_left hr_gray"/><span class="txt_darkgrey text-center">Схемы транспорта</span>
                        <hr class="team_hr team_hr_right hr_gray" />
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>

            <div class="clearfix"></div>
            <br/>
            <div class="text-center">
                <h4>Схемы транспорта города Воронежа</h4>
            </div>

            <div class="text-center">
                <ul class="templatemo-project-gallery" >
                    <li class="col-lg-3 col-md-3 col-sm-3 col-lg-offset-1 col-md-offset-1 col-sm-offset-1 gallery gallery-graphic" >
                        <div class="text-center">
                            <a class="colorbox" href="/static/images/tral21.jpg" data-group="gallery-graphic" class="img-responsive">
                                <div class="templatemo-project-box">

                                    <img src="/static/images/tral2-min.jpg" class="img-responsive" alt="gallery" />

                                    <div class="project-overlay">
                                        <h5>Схема<br/>движения</h5>
                                        <hr />
                                        <h5>Троллейбусов</h5>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </li>

                    <li class="col-lg-3 col-md-3 col-sm-3  gallery gallery-graphic" >
                        <div class="text-center">
                            <a class="colorbox" href="/static/images/deg_full.jpg" data-group="gallery-graphic" class="img-responsive">
                                <div class="templatemo-project-box">

                                    <img src="/static/images/deg_min.jpg" class="img-responsive" alt="gallery" />

                                    <div class="project-overlay">
                                        <h5>Деградация<br/>электротранспорта</h5>
                                        <hr />
                                        <h5>Воронежа</h5>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </li>

                    <li class="col-lg-3 col-md-3 col-sm-3  gallery gallery-graphic" >
                        <div class="text-center">
                            <a class="colorbox" href="/static/images/metro_full.jpg" data-group="gallery-graphic" class="img-responsive">
                                <div class="templatemo-project-box">

                                    <img src="/static/images/metro_min.jpg" class="img-responsive" alt="gallery" />

                                    <div class="project-overlay">
                                        <h5>План<br/>строительства</h5>
                                        <hr />
                                        <h5>метро<br/>в Воронеже</h5>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div> <!-- /.templatemo-portfolio -->


    <div id="templatemo-commun">
        <div class="container">
            <div class="row">
                <div class="templatemo-line-header head_contact">
                    <div class="text-center">
                        <hr class="team_hr team_hr_left hr_gray"/><span class="txt_darkgrey">Контакты</span>
                        <hr class="team_hr team_hr_right hr_gray"/>
                    </div>
                </div>

                <div class="col-md-8">
                    <div id="map_canvas" style="width: 600px; height: 400px"></div>
                    <div class="clearfix"></div>
                    <i>Учебный центр ВГУ NetCracker: 394018, Россия, г. Воронеж, Университетская пл., 1</i>
                </div>
                <div class="col-md-4 contact_right">
                    <h4>Для связи с нами:</h4>
                    <p><img src="/static/images/location.png" alt="icon 1" /> Россия, г. Воронеж, Университетская пл., 1</p>
                    <p><img src="/static/images/phone1.png"  alt="icon 2" /> +7 999 720 80 38</p>
                    <p><img src="/static/images/email.png" alt="icon 3" /><a class="link_orange" href="#"><span class="txt_orange">trebvit@gmail.com</span></a></p>

                </div>
            </div><!-- /.row -->
        </div><!-- /.container -->
    </div><!-- /#templatemo-contact -->

    <script type="text/javascript">
    function initialize() {
        var myLatlng = new google.maps.LatLng(51.65651645725269,39.20612392121155);

        var myOptions = {
        zoom: 14,
        center: myLatlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
        }
        var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
        var myLatlng1 = new google.maps.LatLng(51.65452972847472,39.19274635586758);
        var marker1 = new google.maps.Marker({
            position: myLatlng1,
            map: map,
            title:"Офис компании Netcracker"
        });

        var myLatlng2 = new google.maps.LatLng(51.65651645725269,39.20612392121155);
        var marker2 = new google.maps.Marker({
            position: myLatlng2,
            map: map,
            title:"Netcracker Education Center ВГУ"
        });

    }
    google.maps.event.addDomListener(window, 'load', initialize);



    </script>

    <script type="text/javascript">
        ymaps.ready(init);
        var myMap,
            myPlacemark1;
            myPlacemark2;

        function init(){
            myMap = new ymaps.Map("map", {
                center: [51.65651645725269,39.20612392121155],
                zoom: 16
            });

            myPlacemark1 = new ymaps.Placemark([51.65452972847472,39.19274635586758], {
                hintContent: 'Netcracker',
                balloonContent: 'Офис компании'
            });

            myPlacemark2 = new ymaps.Placemark([51.65651645725269,39.20612392121155], {
                hintContent: 'ВГУ',
                balloonContent: 'Netcracker Education Center'
            });

            myMap.geoObjects.add(myPlacemark1);
            myMap.geoObjects.add(myPlacemark2);
        }
    </script>

    <div class="templatemo-footer" >
        <div class="container">
            <div class="row">
                <div class="text-center">

                    <div class="footer_container">

                        <div class="height30"></div>
                        <a class="btn btn-lg btn-orange" href="#" role="button" id="btn-back-to-top" style="width: 20%">Наверх</a>
                        <div class="height30"></div>
                    </div>
                    <div class="footer_bottom_content">
                        <span id="footer-line">© Netcracker Education Center 2017</span>
                    </div>

                </div>
            </div>
        </div>
    </div>

</body>
</html>