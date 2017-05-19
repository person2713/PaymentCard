package com.team.mvc.util;

import sun.misc.Regexp;

/**
 * Created by dronp on 19.05.2017.
 */
public class FieldChecker {
    private static final String emailRegexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private static final String phoneNumberRegexp = "(\\+7){1}(\\d){10}";
    private static final String nicknameRegexp = "^[^0-9]\\w+$";
    private static final String literalsRegexp="^[а-яА-ЯёЁa-zA-Z0-9]+$";
    private static final String numbersRegexp="[0-9]";

    public static boolean checkEmail(String email) {
        return email.matches(emailRegexp);
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        return phoneNumber.matches(phoneNumberRegexp);
    }

    public static boolean checkNickname(String nickname) {
        return nickname.matches(nicknameRegexp);
    }

    public static boolean checkLiteralsField(String field)
    {
        return field.matches(literalsRegexp);
    }

    public static boolean checkNumbersField(String field)
    {
        return field.matches(numbersRegexp);
    }
}
