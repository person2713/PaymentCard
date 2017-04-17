// массив для сохранения изменений
var massChanges = [];

function deleteUser() {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");


    var mass = [];
    $("table").find("tr").each(function () {
        if ($(this).find("input").is(":checked")) {
            mass.push($(this).find("td").eq(0).html());
            $(this).remove();
        }
    });
    $.ajax({
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        url: "/admin/delete",
        // headers : {
        //     'Accept' : 'application/json',
        //     'Content-Type' : 'application/json'
        // },
        data: JSON.stringify(mass), // Note it is important
        beforeSend: function (xhr) {
            // here it is
            xhr.setRequestHeader(header, token);
        },
        success: function (result) {
            console.log("SUCCESS: ", result);
            alert("success" + result);
        }
//                                ,
//                                error: function (result) {
//                                    console.log("ERROR: ", result);
//                                    alert("Error" + result);
//                                }
    });
}




function saveChanges() {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $("#changeForm").ready(function () {

        $("#changeForm").find("input").each(function () {
            massChanges.push(this.value);
        })
        massChanges.push($( "#cities option:selected" ).text());
        console.log(massChanges);
    })
    $.ajax({
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        url: "/admin/saveChanges",
        // headers : {
        //     'Accept' : 'application/json',
        //     'Content-Type' : 'application/json'
        // },
        data: JSON.stringify(massChanges), // Note it is important
        beforeSend: function (xhr) {
            // here it is
            xhr.setRequestHeader(header, token);
        },
        success: function (result) {
            console.log("SUCCESS: ", result);
            alert("success" + result);
        }
//                                ,
//                                error: function (result) {
//                                    console.log("ERROR: ", result);
//                                    alert("Error" + result);
//                                }
    });
    massChanges = [];
}

// переменная для поиска
var forSearch;


function searchUser() {
    // var a = [];
    var count1 = 0;
    var count2 = 1;
    $("table").find("tr").each(function (i) {
        count1++;
        if (i > 0) {
            // a.push(this);
            if ($(this).find("#tdNick").html() != forSearch.value) {
                $(this).hide();
                count2++;
            }
        }

    });
    if (count1 == count2) {
        alert("Результаты не найдены")
        if ($("#tableForUser").length != 0) {
            getUsers();
        }
        if ($("#tableForOwners").length != 0) {
            getOwners();
        }
        if ($("#tableForDrivers").length != 0) {
            getDrivers();
        }

    }

    // console.log(count1);
    // console.log(count2);

    // console.log(a);
    // $("table").find("td").each(function () {
    //     userInfo.push(this.innerHTML);
    //
    // })
    // console.log(userInfo);

    // console.log(userInfo);
    // console.log(userInfo[0]);
    // console.log($("#inputNick").value);
    // console.log(document.getElementById("inputNick").value);
}


function editUser() {
// массив для взятий информации о пользователе из таблицы
    var userInfo = [];

    // $("table").find("tr").each(function () {
    //
    //     if($(this).is(":visible")){
    //         alert("success");
    //         console.log("SUCCESS")
    //     }
    // })
    var count = 0;
    // здесь надо передать одно значение, то есть один ряд с инфой о пользователе иначе кинуть alert
    $("table").find("tr").each(function () {
        if ($(this).find("input").is(":checked")) {
            count++;
        }
    });
    if (count <= 1) {
        $("table").find("tr").each(function () {
            if ($(this).find("input").is(":checked")) {
                $(this).find("td").each(function () {
                    userInfo.push(this.innerHTML);
                })
                return false;
            }
            count = 0;
        });
    }
    else {
        alert("Выбрано больше одного значения");
        if ($("#tableForUser").length != 0) {
            getUsers();
            count = 0;
            return;
        }
        if ($("#tableForOwners").length != 0) {
            getOwners();
            count = 0;
            return;
        }
        if ($("#tableForDrivers").length != 0) {
            getDrivers();
            count = 0;
            return;
        }
    }
    console.log(userInfo);
    // alert("SUCCESS");
    getCities();
    console.log(listCities);

    $("#head").children().remove();
    var trHTML = '';
    trHTML += '<form id="changeForm" class="form-horizontal" role="form">' +
        '<input id="inputID" class="form-control" type="text" style="visibility:hidden">' +
        '<div class="form-group">' +
        '<label class="col-lg-3 control-label">Ник:</label>' +
        '<div class="col-lg-8">' +
        '<input id="inputNick" class="form-control" type="text">' +
        '</div>' +
        '</div>' +
        '<div class="form-group">' +
        '<label class="col-lg-3 control-label">Имя:</label>' +
        '<div class="col-lg-8">' +
        '<input id="inputFirstname" class="form-control" type="text">' +
        '</div>' +
        '</div>' +
        '<div class="form-group">' +
        '<label class="col-lg-3 control-label">Фамилия:</label>' +
        '<div class="col-lg-8">' +
        '<input id="inputLastname" class="form-control" type="text" >' +
        '</div>' +
        '</div>' +
        '<div class="form-group">' +
        '<label class="col-lg-3 control-label">Мобильный телефон:</label>' +
        '<div class="col-lg-8">' +
        '<input id="inputMobile"class="form-control" type="text">' +
        '</div>' +
        '</div>' +
        '<div class="form-group">' +
        '<label class="col-lg-3 control-label">Электронная почта:</label>' +
        '<div class="col-lg-8">' +
        '<input id="inputEmail" class="form-control" type="text">' +
        '</div>' +
        '</div>' +
        '<div class="form-group">' +
        '<label class="col-lg-3 control-label">Город:</label>' +
        '<div class="col-lg-8">' +
        '<div class="ui-select">' +
        '<select id="cities" class="form-control">' +
        // '<option value="Hawaii">(GMT-10:00) Hawaii</option>' +
        // '<option value="Alaska">(GMT-09:00) Alaska</option>' +
        // '<option value="Pacific Time (US &amp; Canada)">(GMT-08:00) Pacific Time (US &amp; Canada)</option>' +
        // '<option value="Arizona">(GMT-07:00) Arizona</option>' +
        // '<option value="Mountain Time (US &amp; Canada)">(GMT-07:00) Mountain Time (US &amp; Canada)</option>' +
        // '<option value="Central Time (US &amp; Canada)" selected="selected">(GMT-06:00) Central Time (US &amp; Canada)</option>' +
        // '<option value="Eastern Time (US &amp; Canada)">(GMT-05:00) Eastern Time (US &amp; Canada)</option>' +
        // '<option value="Indiana (East)">(GMT-05:00) Indiana (East)</option>' +
        '</select>' +
        '</div>' +
        '</div>' +
        '</div>' +
        '<div class="form-group">' +
        '<label class="col-md-3 control-label">Пароль:</label>' +
        '<div class="col-md-8">' +
        '<input id="inputPassword1" class="form-control" type="password">' +
        '</div>' +
        '</div>' +
        '<div class="form-group">' +
        '<label class="col-md-3 control-label">Подтвердите пароль:</label>' +
        '<div class="col-md-8">' +
        '<input id="inputPassword2" class="form-control" type="password">' +
        '</div>' +
        '</div>' +
        '<div class="form-group">' +
        '<label class="col-md-3 control-label"></label>' +
        '<div class="col-md-8">' +
        // '<input type="button" class="btn btn-primary" onclick="saveChanges();" value="Save Changes">'
        '<button type="button" class="btn btn-primary" onclick="saveChanges();">Сохранить</button><br>' +
        '<span></span>' +
        '<input type="reset" class="btn btn-default" value="Cancel">' +
        '</div>' +
        '</div>' +
        '</form>';
    $("#head").append(trHTML);
    if (userInfo[1] == null) {
        alert("Выберите пользователя для редактирования");
        $("#head").children().remove();
    }
    else {
        //Записываем индекс
        // massChanges.push(userInfo[0]);
        // console.log(massChanges);
        document.getElementById("inputID").value = userInfo[0];
        document.getElementById("inputNick").value = userInfo[1];
        document.getElementById("inputFirstname").value = userInfo[2];
        document.getElementById("inputLastname").value = userInfo[3];
        document.getElementById("inputMobile").value = userInfo[4];
        document.getElementById("inputEmail").value = userInfo[5];
        document.getElementById("cities").value = userInfo[6];
        document.getElementById("inputPassword1").value = userInfo[7];
        document.getElementById("inputPassword2").value = userInfo[7];

        userInfo = [];
    }
}

function getUsers() {
    if ($("#tableForUser").length != 0) {
        $("tr").show();
    }
    else {
        $("#head").children().remove();
        $.ajax({
            type: "GET",
            url: "/admin/getUsers",
            datatype: "json",
            success: function (response) {
                var trHTML = '';
                trHTML += '<div class="row">' +
                    '<div class="col-sm-3">' +
                    '<h2>Водители</h2>' +
                    '</div>' +
                    '<div class="offset-sm-5">' +
                    '<form class="navbar-form navbar-right">' +
                    '<div class="row">' +
                    '<div>' +
                    '<input id="inNick" name="inNick" type="text" class="form-control" placeholder="Search">' +
                    '</div>' +
                    '<div style="padding-left:10px">' +
                    '<button type="button" class="btn btn-link" onclick="searchUser();">Найти</button>' +
                    '</div>' +
                    '</div>' +
                    '</form>' +
                    '</div>' +
                    '</div>' +
                    '<div class="table-responsive">' +
                    '<table id="tableForUser" class="table table-hover">' +
                    '<thead ><tr id="tableHead"><th data-field="nickname">' +
                    'Ник' + '</th><th data-field="firstName">' +
                    "Имя" + '</th><th data-field="lastName">' +
                    "Фамилия" + '</th><th data-field="mobilePhone">' +
                    "Мобильный телефон" + '</th><th data-field="email">' +
                    "Электронная почта" + '</th><th data-field="city">' +
                    "Город" + '</th><th>' +
                    '</th></tr></thead><tbody>'
                ;
                $.each(response, function (i, item) {
                    trHTML += '<tr><td style="display:none">' +
                        item.personId + '</td><td id="tdNick">' +
                        item.nickname + '</td><td>' +
                        item.firstName + '</td><td>' +
                        item.lastName + '</td><td>' +
                        item.mobileNumber + '</td><td>' +
                        item.email + '</td><td>' +
                        item.city.cityName + '</td><td style="display:none;">' +
                        item.password + '</td><td>' +
                        '<input type="checkbox" value=""/>' +
                        '</td></tr>';
                });
                trHTML += '</tbody>' + '</table>';
                $("#head").append(trHTML);
            },
            error: function () {
                alert("error")
            }
        }).done(function onload() {
                forSearch = document.getElementById('inNick');
            },
            function () {
                $('table tr').click(function (event) {
                    if (event.target.type !== 'checkbox') {
                        $(':checkbox', this).trigger('click');
                    }
                });
            }
        )
    }
}

var listCities = [];
var city;
function getCities() {

    $.ajax({
        type: "GET",
        url: "/admin/getCities",
        datatype: "json",
        success: function (response) {
            $.each(response, function (i, item) {
                listCities.push(item);
            });
            $.each(listCities, function (i, item) {

                city += '<option>' + item + '</option>';
            })
            $("#cities").append(city);
        },
        error: function () {
            alert("error")
        }
    })
}

function getOwners() {

    if ($("#tableForOwners").length != 0) {
        $("tr").show();
    }
    else {
        $("#head").children().remove();
        $.ajax({
            type: "GET",
            url: "/admin/getOwners",
            datatype: "json",
            success: function (response) {
                var trHTML = '';
                trHTML += '<div class="row">' +
                    '<div class="col-sm-3">' +
                    '<h2>Владельцы</h2>' +
                    '</div>' +
                    '<div class="offset-sm-5">' +
                    '<form class="navbar-form navbar-right">' +
                    '<div class="row">' +
                    '<div>' +
                    '<input id="inNick" name="inNick" type="text" class="form-control" placeholder="Search">' +
                    '</div>' +
                    '<div style="padding-left:10px">' +
                    '<button type="button" class="btn btn-link" onclick="searchUser();">Найти</button>' +
                    '</div>' +
                    '</div>' +
                    '</form>' +
                    '</div>' +
                    '</div>' +
                    '<div class="table-responsive">' +
                    '<table id="tableForOwners" class="table table-hover">' +
                    '<thead ><tr id="tableHead"><th data-field="nickname">' +
                    'Ник' + '</th><th data-field="firstName">' +
                    "Имя" + '</th><th data-field="lastName">' +
                    "Фамилия" + '</th><th data-field="mobilePhone">' +
                    "Мобильный телефон" + '</th><th data-field="email">' +
                    "Электронная почта" + '</th><th data-field="city">' +
                    "Город" + '</th><th>' +
                    '</th></tr></thead><tbody>'
                ;

                $.each(response, function (i, item) {
                    trHTML += '<tr><td style="display:none">' +
                        item.personId + '</td><td id="tdNick">' +
                        item.nickname + '</td><td>' +
                        item.firstName + '</td><td>' +
                        item.lastName + '</td><td>' +
                        item.mobileNumber + '</td><td>' +
                        item.email + '</td><td>' +
                        item.city.cityName + '</td><td style="display:none;">' +
                        item.password + '</td><td>' +
                        '<input type="checkbox" value=""/>' +
                        '</td></tr>';
                });
                trHTML += '</tbody>' + '</table>';
                $("#head").append(trHTML);
            },
            error: function () {
                alert("error")
            }
        }).done(function onload() {
                forSearch = document.getElementById('inNick');
            },
            function () {
                $('table tr').click(function (event) {
                    if (event.target.type !== 'checkbox') {
                        $(':checkbox', this).trigger('click');
                    }
                });
            }
        )
    }
}

function getDrivers() {

    if ($("#tableForDrivers").length != 0) {
        $("tr").show();
    }
    else {
        $("#head").children().remove();
        $.ajax({
            type: "GET",
            url: "/admin/getDrivers",
            datatype: "json",
            success: function (response) {
                var trHTML = '';
                trHTML += '<div class="row">' +
                    '<div class="col-sm-3">' +
                    '<h2>Водители</h2>' +
                    '</div>' +
                    '<div class="offset-sm-5">' +
                    '<form class="navbar-form navbar-right">' +
                    '<div class="row">' +
                    '<div>' +
                    '<input id="inNick" name="inNick" type="text" class="form-control" placeholder="Search">' +
                    '</div>' +
                    '<div style="padding-left:10px">' +
                    '<button type="button" class="btn btn-link" onclick="searchUser();">Найти</button>' +
                    '</div>' +
                    '</div>' +
                    '</form>' +
                    '</div>' +
                    '</div>' +
                    '<div class="table-responsive">' +
                    '<table id="tableForDrivers" class="table table-hover">' +
                    '<thead ><tr id="tableHead"><th data-field="nickname">' +
                    'Ник' + '</th><th data-field="firstName">' +
                    "Имя" + '</th><th data-field="lastName">' +
                    "Фамилия" + '</th><th data-field="mobilePhone">' +
                    "Мобильный телефон" + '</th><th data-field="email">' +
                    "Электронная почта" + '</th><th data-field="city">' +
                    "Город" + '</th><th>' +
                    '</th></tr></thead><tbody>'
                ;

                $.each(response, function (i, item) {
                    trHTML += '<tr><td style="display:none">' +
                        item.personId + '</td><td id="tdNick">' +
                        item.nickname + '</td><td>' +
                        item.firstName + '</td><td>' +
                        item.lastName + '</td><td>' +
                        item.mobileNumber + '</td><td>' +
                        item.email + '</td><td>' +
                        item.city.cityName + '</td><td style="display:none;">' +
                        item.password + '</td><td>' +
                        '<input type="checkbox" value=""/>' +
                        '</td></tr>';
                });
                trHTML += '</tbody>' + '</table>';
                $("#head").append(trHTML);
            },
            error: function () {
                alert("error")
            }
        }).done(function onload() {
                forSearch = document.getElementById('inNick');
            },
            function () {
                $('table tr').click(function (event) {
                    if (event.target.type !== 'checkbox') {
                        $(':checkbox', this).trigger('click');
                    }
                });
            }
        )
    }
}




