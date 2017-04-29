// массив для сохранения изменений
var massChanges = [];

function deleteUser() {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");


    var mass = [];
    $("table").find("tr").each(function () {
        if ($(this).find("input").is(":checked")) {
            mass.push($(this).find("td").eq(1).html());
            $(this).remove();
        }
    });
    if(mass.length==0){
        alert("Выберите пользователя");
    }

    $.ajax({
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        url: "/admin/delete",
        data: JSON.stringify(mass), // Note it is important
        beforeSend: function (xhr) {
            // here it is
            xhr.setRequestHeader(header, token);
        },
        success: function (result) {
            console.log("SUCCESS: ", result);
            alert("success" + result);
        }
    });
}

// метод для сохранении информации о пользователе, например после редактирования
function saveChanges() {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    $("#changeForm").find("input").each(function () {
        massChanges.push(this.value);
    })
    massChanges.push($("#cities option:selected").text());
    console.log(massChanges);
    // })
    $.ajax({
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        url: "/admin/saveChanges",
        data: JSON.stringify(massChanges), // Note it is important
        beforeSend: function (xhr) {
            // here it is
            xhr.setRequestHeader(header, token);
        },
        success: function (result) {
            console.log("SUCCESS: ", result);
            alert("success" + result);
        }
    });
    switch (massChanges[8]){
        case "USER":
            getUsers();
            break;
        case "DRIVER":
            getDrivers();
            break;
        case "OWNER":
            getOwners();
            break;
    }
    alert("User edit successfully");
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
}


function edit() {
// массив для взятий информации о пользователе из таблицы
    var userInfo = [];

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

    $("#head").children().remove();
    var trHTML = '';
    trHTML += '<form id="changeForm" class="form-horizontal" role="form">' +
        '<input id="inputID" class="form-control" type="text" style="visibility:hidden"/>' +
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
        '</select>' +
        '</div>' +
        '</div>' +
        '</div>' +
        '<div class="form-group">' +
        '<label class="col-lg-3 control-label">Роль:</label>' +
        '<div class="col-lg-8">' +
        '<div class="ui-select">' +
        '<select id="rollers" class="form-control">' +
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
        '<input id="role" class="form-control" type="text" style="visibility:hidden"/>' +
        '<div class="form-group">' +
        '<label class="col-md-3 control-label"></label>' +
        '<div class="col-md-8">' +
        '<div class="row">' +
        '<div class="ofset">' +
        '<button type="button" class="btn btn-primary" onclick="saveChanges();">Сохранить</button><br>' +
        '</div>' +
        '<span></span>' +
        '<div>' +
        '<button type="button" class="btn btn-default" onclick="Cancel();">Отменить</button><br>' +
        '</div>' +
        '</div>' +
        '</div>' +
        '</div>' +
        '</form>';
    $("#head").append(trHTML);
    if (userInfo[1] == null) {
        alert("Выберите пользователя для редактирования");
        $("#head").children().remove();
    }
    else {
        getCities().done(
            getRollers().done(function () {
                document.getElementById("inputID").value = userInfo[0];
                document.getElementById("inputNick").value = userInfo[1];
                document.getElementById("inputFirstname").value = userInfo[2];
                document.getElementById("inputLastname").value = userInfo[3];
                document.getElementById("inputMobile").value = userInfo[4];
                document.getElementById("inputEmail").value = userInfo[5];
                $("#cities").val(userInfo[6]);
                $("#rollers").val(userInfo[8]);
                // $('cities option:contains(userInfo[6])').prop('selected',true);
                document.getElementById("inputPassword1").value = userInfo[7];
                document.getElementById("inputPassword2").value = userInfo[7];
                document.getElementById("role").value = userInfo[8];
                userInfo = [];
            }))
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
                        item.password + '</td><td style="display:none;">' +
                        item.role.roleType + '</td><td>' +
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

var role;
function getRollers() {
    return $.ajax({
        type: "GET",
        url: "/admin/getRollers",
        datatype: "json",
        success: function (response) {
            $.each(response, function (i, item) {
                role += '<option>' + item + '</option>';
            });
            $("#rollers").append(role);
            role = '';
        },
        error: function () {
            alert("error")
        }
    })
}


var city;
function getCities() {

    return $.ajax({
        type: "GET",
        url: "/admin/getCities",
        datatype: "json",
        success: function (response) {
            $.each(response, function (i, item) {
                city += '<option>' + item + '</option>';
            });
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
                        item.password + '</td><td style="display:none;">' +
                        item.role.roleType + '</td><td>' +
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

function Cancel() {
    $("#head").children().remove();
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
                        item.password + '</td><td style="display:none;">' +
                        item.role.roleType + '</td><td>' +
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


function getCards() {

    if ($("#tableForCards").length != 0) {
        $("tr").show();
    }
    else {
        $("#head").children().remove();
        $.ajax({
            type: "GET",
            url: "/admin/getCards",
            datatype: "json",
            success: function (response) {
                var trHTML = '';
                trHTML+=createTableHeader('Список карт', 'tableForCards') + createTableBody(response, 'tdCardName');
                $("#head").append(trHTML);
            },
            error: function () {
                alert("error")
            }
        }).done(function onload() {
                forSearch = document.getElementById('CardName');
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


function addCards() {

    $("#head").children().remove();
    $("#head").load("tableForm.jsp #cardForm");
    getAllUser();
}



var person;
function getAllUser() {
    return $.ajax({
        type: "GET",
        url: "/admin/getAllUser",
        datatype: "json",

        success: function (response) {

            console.log(response),
                $.each(response, function (i, item) {
                    person += '<option>' + item + '</option>';
                });
            console.log(person);
            $("#persons").append(person);
        },
        error: function () {
            alert("error")
        }
    })
}

var infoCard = [];
function saveCard() {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    $("#cardForm").find("input").each(function () {
        infoCard.push(this.value);
    })
    infoCard.push($("#persons option:selected").text());
    console.log(infoCard);
    // })
    $.ajax({
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        url: "/admin/addCard",
        data: JSON.stringify(infoCard), // Note it is important
        beforeSend: function (xhr) {
            // here it is
            xhr.setRequestHeader(header, token);
        },
        success: function (result) {
            console.log("SUCCESS: ", result);
            alert("success" + result);
        }
    });

    alert("Card add successfully");
    infoCard = [];

}



//функция для создания заголовка таблицы
function createTableHeader(tableName, tableId){

    var tHeader = '';
    tHeader += '<div class="row">' +
        '<div class="col-sm-3">' +
        '<h2>'+tableName+'</h2>' +
        '</div>' +
        '<div class="offset-sm-5">' +
        '<form class="navbar-form navbar-right">' +
        '<div class="row">' +
        '<div>' +
        '<input id="CardName" name="CardName" type="text" class="form-control" placeholder="Search">' +
        '</div>' +
        '<div style="padding-left:10px">' +
        '<button type="button" class="btn btn-link" onclick="searchUser();">Найти</button>' +
        '</div>' +
        '</div>' +
        '</form>' +
        '</div>' +
        '</div>' +
        '<div class="table-responsive">' +
        '<table id="'+tableId+'" class="table table-hover">' +
        '<thead ><tr id="tableHead"><th>' +
        'Название карты' + '</th><th>' +
        "Ключ" + '</th><th>' +
        "Тип" + '</th><th>' +
        "Статус" + '</th><th>' +
        // "Ник владельца" + '</th><th>' +
        '</th></tr></thead>'
    ;
    return tHeader;
}
//функция для заполнения таблицы
function createTableBody(response, tdCardName) {
    var tBody='';
    tBody+='<tbody>';
    $.each(response, function (i, item) {
        tBody += '<tr><td id="'+tdCardName+'">' +
            item.cardName + '</td><td>' +
            item.cardKey + '</td><td>' +
            item.typeCard.cardType + '</td><td>' +
            item.typeCard.status + '</td><td>' +
            // item.person.nickname + '</td><td>' +
            '<input type="checkbox" value=""/>' +
            '</td></tr>';
    });
    tBody += '</tbody>' + '</table>';
    return tBody;
}