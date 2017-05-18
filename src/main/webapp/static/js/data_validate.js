function validateEmail(email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}

function validatePhoneNumber(number) {
    var re = /(\+7){1}(\d){10}/;
    return re.test(number);
}

function validateNickname(nickname) {
    var re = /^[^0-9]\w+$/;
    return re.test(nickname);
}