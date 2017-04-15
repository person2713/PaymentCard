function deleteUser() {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    var mass = new Array();
    $("#dataTable").find("tr").each(function () {
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
//                                headers : {
//                                    'Accept' : 'application/json',
//                                    'Content-Type' : 'application/json'
//                                },
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
function getUsers() {

    $.ajax({
        type: "GET",
        url: "/admin/getUsers",
        datatype: "json",
        success: function (response) {
            $("#head").children().remove();
            var trHTML='';
            trHTML += '<h2>' + "Пользователи" + '</h2>' +
                '<div class="table-responsive">' +
                '<table id="dataTable" class="table table-hover">' +
                '<thead><tr><th>' +
                'Ник' + '</th><th>' +
                "Имя" + '</th><th>' +
                "Фамилия" + '</th><th>' +
                "Мобильный телефон" + '</th><th>' +
                "Электронная почта" + '</th><th>' +
                "Город" + '</th><th>' +
                '</th></tr></thead><tbody>'
            ;

            $.each(response, function (i, item) {
                trHTML += '<tr><td>' +
                    item.nickname + '</td><td>' +
                    item.firstName + '</td><td>' +
                    item.lastName + '</td><td>' +
                    item.mobileNumber + '</td><td>' +
                    item.email + '</td><td>' +
                    item.city.cityName + '</td><td>' +
                    '<input type="checkbox" value=""/>' +
                    '</td></tr>';
            });
            trHTML += '</tbody>'+'</table>'+'</div>';
            $("#head").append(trHTML);
        },
        error: function () {
            alert("error")
        }
    });
}

function getOwners() {

    $.ajax({
        type: "GET",
        url: "/admin/getOwners",
        datatype: "json",
        success: function (response) {
            $("#head").children().remove();
            var trHTML='';
            trHTML += '<h2>' + "Владельцы" + '</h2>' +
                '<div class="table-responsive">' +
                '<table id="dataTable" class="table table-hover">' +
                '<thead><tr><th>' +
                'Ник' + '</th><th>' +
                "Имя" + '</th><th>' +
                "Фамилия" + '</th><th>' +
                "Мобильный телефон" + '</th><th>' +
                "Электронная почта" + '</th><th>' +
                "Город" + '</th><th>' +
                '</th></tr></thead><tbody>'
            ;

            $.each(response, function (i, item) {
                trHTML += '<tr><td>' +
                    item.nickname + '</td><td>' +
                    item.firstName + '</td><td>' +
                    item.lastName + '</td><td>' +
                    item.mobileNumber + '</td><td>' +
                    item.email + '</td><td>' +
                    item.city.cityName + '</td><td>' +
                    '<input type="checkbox" value=""/>' +
                    '</td></tr>';
            });
            trHTML += '</tbody>'+'</table>'+'</div>';
            $("#head").append(trHTML);
        },
        error: function () {
            alert("error")
        }
    });
}

function getDrivers() {

    $.ajax({
        type: "GET",
        url: "/admin/getDrivers",
        datatype: "json",
        success: function (response) {
            $("#head").children().remove();
            var trHTML='';
            trHTML += '<h2>' + "Водители" + '</h2>' +
                '<div class="table-responsive">' +
                '<table id="dataTable" class="table table-hover">' +
                '<thead><tr><th>' +
                'Ник' + '</th><th>' +
                "Имя" + '</th><th>' +
                "Фамилия" + '</th><th>' +
                "Мобильный телефон" + '</th><th>' +
                "Электронная почта" + '</th><th>' +
                "Город" + '</th><th>' +
                '</th></tr></thead><tbody>'
            ;

            $.each(response, function (i, item) {
                trHTML += '<tr><td>' +
                    item.nickname + '</td><td>' +
                    item.firstName + '</td><td>' +
                    item.lastName + '</td><td>' +
                    item.mobileNumber + '</td><td>' +
                    item.email + '</td><td>' +
                    item.city.cityName + '</td><td>' +
                    '<input type="checkbox" value=""/>' +
                    '</td></tr>';
            });
            trHTML += '</tbody>'+'</table>'+'</div>';
            $("#head").append(trHTML);
        },
        error: function () {
            alert("error")
        }
    });
}



