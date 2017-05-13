// при заходе на страницу админа сразу подгружаем коллекцию городов
// массив городов
var cards = Array();
// переменная которая будет цепляться к форме для выпадающего списка
var city = '';
// функция получения городов, загружается после захода на страницу админа
function getCardsForAlex() {

    return $.ajax({
        type: "GET",
        url: "/user/getCardsForAlex",
        datatype: "json",
        success: function (response) {
            $.each(response, function (i, item) {
//                    city += '<option>' + item.cityName + '</option>';
                cards.push(item);
            });
            console.log(cards);
        },
        error: function () {
            alert("error")
        }
    })
}

