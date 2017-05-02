// массив для сохранения объектов приходяших в json'e
var arrayObject = Array();

// при заходе на страницу админа сразу подгружаем коллекцию городов
// массив городов
var cities = Array();
// переменная которая будет цепляться к форме для выпадающего списка
var city = '';
// функция получения городов, загружается после захода на страницу админа
function getCities() {

    return $.ajax({
        type: "GET",
        url: "/admin/getCities",
        datatype: "json",
        success: function (response) {
            $.each(response, function (i, item) {
                city += '<option>' + item.cityName + '</option>';
                cities.push(item);
            });
        },
        error: function () {
            alert("error")
        }
    })
}

// при заходе на страницу админа сразу подгружаем коллекцию ролей
// массив ролей
var rollers = Array();
// переменная которая будет цепляться к форме для выпадающего списка
var role = '';
// функция получения ролей, загружается после захода на страницу админа
function getRollers() {
    return $.ajax({
        type: "GET",
        url: "/admin/getRollers",
        datatype: "json",
        success: function (response) {
            $.each(response, function (i, item) {
                role += '<option>' + item.roleType + '</option>';
                rollers.push(item);
            });
        },
        error: function () {
            alert("error")
        }
    })
}
// при заходе на страницу админа сразу подгружаем коллекцию типовКарт
// массив ролей
var typeCard = Array();
// переменная которая будет цепляться к форме для выпадающего списка
var cardStatus = '';
// переменная которая будет цепляться к форме для выпадающего списка
var cardType = '';
// функция получения типовКарт, загружается после захода на страницу админа
function getTypeCard() {

    return $.ajax({
        type: "GET",
        url: "/admin/getTypeCard",
        datatype: "json",
        success: function (response) {
            $.each(response, function (i, item) {
                typeCard.push(item);
                cardStatus += '<option>' + item.status + '</option>';
                cardType += '<option>' + item.cardType + '</option>';
            });
        },
        error: function () {
            alert("error")
        }
    })
}
//функция для удаления пользователей
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
    if (mass.length == 0) {
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

// переменная для поиска
var forSearch = '';

//функция для поиска
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

//функция для получения обычных пользователей
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
                // console.log(response);
                $.each(response, function (i, item) {
                    arrayObject.push(item);
                    // console.log(item);
                })

                var trHTML = '';
                trHTML += createTableHeader('Пользователи') + createTableBody(response, 'Пользователи');
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


//функция для получения владельцев
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
                trHTML += createTableHeader('Владельцы') + createTableBody(response, 'Владельцы');
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


//функция для получения водителей
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
                trHTML += createTableHeader('Водители') + createTableBody(response, 'Водители');
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

//функция для получения карт
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
                trHTML += createTableHeader('Список карт') + createTableBody(response, 'Список карт');
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


function prepareAddCards() {

    $("#head").children().remove();
}


var person = '';
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
function createTableHeader(tableName) {

    var tHeader = '';
    switch (tableName) {
        case 'Пользователи':
            tHeader = createTableHeaderForUsers('Пользователи', 'tableForUser');
            break;
        case 'Водители':
            tHeader = createTableHeaderForUsers('Водители', 'tableForDrivers');
            break;
        case 'Владельцы':
            tHeader = createTableHeaderForUsers('Владельцы', 'tableForOwners');
            break;
        case 'Список карт':
            tHeader = createTableHeaderForCards('Список карт', 'tableForCards');
            break;
    }
    return tHeader;
}
//функция для заполнения таблицы
function createTableBody(response, tableName) {
    var tBody = '';
    switch (tableName) {
        case 'Пользователи':
        case 'Водители':
        case 'Владельцы':
            tBody = createTableBodyForUsers(response, 'tdNick');
            break;
        case 'Список карт':
            tBody = createTableBodyForCards(response, 'tdCardName');
            break;
    }
    // console.log(tBody);
    return tBody;
}

//функция для создания заголовка таблицы для пользователей, владельцов, водителей
function createTableHeaderForUsers(tableName, tableId) {

    var tHeader = '';
    tHeader += '<div class="row">' +
        '<div class="col-sm-3">' +
        '<h2 id="tableName">' + tableName + '</h2>' +
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
        '<table id="' + tableId + '" class="table table-hover">' +
        '<thead ><tr id="tableHead"><th data-field="nickname">' +
        'Ник' + '</th><th data-field="firstName">' +
        "Имя" + '</th><th data-field="lastName">' +
        "Фамилия" + '</th><th data-field="mobilePhone">' +
        "Мобильный телефон" + '</th><th data-field="email">' +
        "Электронная почта" + '</th><th data-field="city">' +
        "Город" + '</th><th>' +
        '</th></tr></thead>'
    ;
    return tHeader;
}
//функция для создания тела таблицы для пользователей, владельцов, водителей
function createTableBodyForUsers(response, tdNick) {

    var tBody = '';
    tBody += '<tbody>';
    $.each(response, function (i, item) {
        tBody += '<tr><td style="display:none">' +
            item.personId + '</td><td id="' + tdNick + '">' +
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
    tBody += '</tbody>' + '</table>';
    return tBody;
}

//функция для создания заголовка таблицы для карт
function createTableHeaderForCards(tableName, tableId) {

    var tHeader = '';
    tHeader += '<div class="row">' +
        '<div class="col-sm-3">' +
        '<h2 id="tableName">' + tableName + '</h2>' +
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
        '<table id="' + tableId + '" class="table table-hover">' +
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

//функция для создания тела таблицы для карт
function createTableBodyForCards(response, tdCardName) {
    var tBody = '';
    tBody += '<tbody>';
    $.each(response, function (i, item) {
        tBody += '<tr><td style="display:none">' +
            item.cardId + '<td id="' + tdCardName + '">' +
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

//функция для создания формы для редактирования пользователя
function createFormForEditUser() {
    $("#head").children().remove();
    var tForm = '';
    tForm += '<form id="changeForm" class="form-horizontal" role="form">' +
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
        '<div class="form-group">' +
        '<label class="col-md-3 control-label"></label>' +
        '<div class="col-md-8">' +
        '<div class="row">' +
        '<div class="ofset">' +
        '<button type="button" class="btn btn-primary" onclick="saveChangesForUsers();">Сохранить</button><br>' +
        '</div>' +
        '<span></span>' +
        '<div>' +
        '<button type="button" class="btn btn-default" onclick="Cancel();">Отменить</button><br>' +
        '</div>' +
        '</div>' +
        '</div>' +
        '</div>' +
        '</form>';
    document.getElementById("head").insertAdjacentHTML('beforeend', tForm);
    document.getElementById("cities").insertAdjacentHTML('beforeend', city);
    document.getElementById("rollers").insertAdjacentHTML('beforeend', role);
    document.getElementById("inputID").value = rowInfo[0];
    document.getElementById("inputNick").value = rowInfo[1];
    document.getElementById("inputFirstname").value = rowInfo[2];
    document.getElementById("inputLastname").value = rowInfo[3];
    document.getElementById("inputMobile").value = rowInfo[4];
    document.getElementById("inputEmail").value = rowInfo[5];
    document.getElementById("cities").value = rowInfo[6];
    document.getElementById("rollers").value = rowInfo[8];
    document.getElementById("inputPassword1").value = rowInfo[7];
    document.getElementById("inputPassword2").value = rowInfo[7];
    rowInfo = [];
    return;
}


//функция для создания формы для редактирования карты
function createFormForEditCard() {
    $("#head").children().remove();
    var tForm = '';
    tForm += '<form id="changeForm" class="form-horizontal" role="form">' +
        '<input id="inputID" class="form-control" type="text" style="visibility:hidden">' +
        '<div class="form-group">' +
        '<label class="control-label">Название карты:</label>' +
        '<div>' +
        '<input id="cardName" class="form-control" type="text">' +
        '</div>' +
        '</div>' +
        '<div class="form-group">' +
        '<label class="control-label">Ключ:</label>' +
        '<div>' +
        '<input id="cardKey" class="form-control" type="text">' +
        '</div>' +
        '</div>' +
        '<div class="form-group">' +
        '<label class="control-label">Тип:</label>' +
        '<div>' +
        '<div class="ui-select">' +
        '<select id="cardType" class="form-control">' +
        '</select>' +
        '</div>' +
        '</div>' +
        '</div>' +
        '<div class="form-group">' +
        '<label class="control-label">Статус:</label>' +
        '<div>' +
        '<div class="ui-select">' +
        '<select id="cardStatus" class="form-control">' +
        '</select>' +
        '</div>' +
        '</div>' +
        '</div>' +
        '<input id="role" class="form-control" type="text" style="visibility:hidden">' +
        '<div class="form-group">' +
        '<label class="control-label"></label>' +
        '<div>' +
        '<div class="row">' +
        '<div class="ofset">' +
        '<button type="button" class="btn btn-primary" onclick="saveChangesForCards();">Сохранить</button>' +
        '<br>' +
        '</div>' +
        '<span></span>' +
        '<div>' +
        '<button type="button" class="btn btn-default" onclick="Cancel();">Отменить </button>' +
        '<br>' +
        '</div>' +
        '</div>' +
        '</div>' +
        '</div>' +
        '</form>';
    document.getElementById("head").insertAdjacentHTML('beforeend', tForm);
    document.getElementById("cardType").insertAdjacentHTML('beforeend', cardType);
    document.getElementById("cardStatus").insertAdjacentHTML('beforeend', cardStatus);
    document.getElementById("inputID").value = rowInfo[0];
    document.getElementById("cardName").value = rowInfo[1];
    document.getElementById("cardKey").value = rowInfo[2];
    document.getElementById("cardType").value = rowInfo[3];
    document.getElementById("cardStatus").value = rowInfo[4];
    rowInfo = [];

    return;
}


// функция для создания и заполнения формы
function createFormForEdit() {
    switch (document.getElementById("tableName").innerHTML) {

        case 'Пользователи':
        case 'Владельцы':
        case 'Водители':
            createFormForEditUser();

            break;
        case 'Список карт':
            createFormForEditCard();

            break;
    }
}


// массив для взятий информации о объекте из таблицы
var rowInfo = [];
function edit() {
    var count = 0;
    // здесь надо передать одно значение, то есть один ряд с инфой о пользователе иначе кинуть alert
    $("table").find("tr").each(function () {
        if ($(this).find("input").is(":checked")) {
            count++;
        }
    });
    if (count == 1) { // если выделено одно поле
        $("table").find("tr").each(function () {
            if ($(this).find("input").is(":checked")) {
                $(this).find("td").each(function () {
                    rowInfo.push(this.innerHTML);
                })
                console.log(rowInfo);
                return;
            }
            count = 0;
        });
    }
    else if (count == 0) { // если выделено 0 поля
        alert("Выберите поле для редактирования")
        return;
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
        if ($("#tableForCards").length != 0) {
            getCards();
            count = 0;
            return;
        }
    }
    createFormForEdit();

}


// массив для сохранения изменений
var massChanges = Array();

// метод для сохранении информации о пользователе, например после редактирования
function saveChangesForUsers() {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");


    var fieldPass1 = $("#inputPassword1").val();
    var fieldPass2 = $("#inputPassword2").val();
    if (fieldPass1 != fieldPass2) {
        alert("Пароли не совпадают!");
        return;
    }
    $("#changeForm").find('.form-control').each(function () {
        massChanges.push($(this).val());
    })

    console.log(massChanges);
    var entity;
    for (var i = 0; i < arrayObject.length; i++) {
        if ((arrayObject[i].personId == massChanges[0])) {
            console.log(arrayObject[i]);
            arrayObject[i].nickname = massChanges[1];
            arrayObject[i].firstName = massChanges[2];
            arrayObject[i].lastName = massChanges[3];
            arrayObject[i].mobileNumber = massChanges[4];
            arrayObject[i].email = massChanges[5];
            for (var j = 0; j < cities.length; j++) {
                if (cities[j].cityName == massChanges[6]){
                    arrayObject[i].city = cities[j];
                    break;
                }
            }
            arrayObject[i].password = massChanges[7];
            for (var l = 0; l < rollers.length; l++) {
                if (rollers[l].roleType == massChanges[8]){
                    arrayObject[i].role = rollers[l];
                    break;
                }
            }
            entity = arrayObject[i];
            console.log(arrayObject[i]);
            break;
        }
    }
    console.log(entity);
    $.ajax({
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        url: "/admin/saveChangesForUsers",
        data: JSON.stringify(entity), // Note it is important
        beforeSend: function (xhr) {
            // here it is
            xhr.setRequestHeader(header, token);
        },
        success: function (result) {
            console.log("SUCCESS: ", result);
            alert("success" + result);
        }
    });

    alert("User edit successfully");
    massChanges.splice(0, massChanges.length);
}


// метод для сохранении информации о пользователе, например после редактирования
function saveChangesForCards() {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    $("#changeForm").find('.form-control').each(function () {
        massChanges.push($(this).val());
    })

    console.log(massChanges);


    $.ajax({
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        url: "/admin/saveChangesForCards",
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
    alert("Card edit successfully");
    getCards();
    massChanges = [];
}






