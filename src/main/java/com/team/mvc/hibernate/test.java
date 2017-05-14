package com.team.mvc.hibernate;

import com.team.mvc.database.entities.Buses;
import org.hibernate.Session;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class test {


        // Find your Account Sid and Token at twilio.com/user/account
        public static final String ACCOUNT_SID = "AC49a8834042c11bb595f9d9ce94d92446";
        public static final String AUTH_TOKEN = "c197119e48fb7cd9704c3b0352f28fc0";

        public static void main(String[] args) {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            Message message = Message.creator(new PhoneNumber("+79003004688"),
                    new PhoneNumber("+15054040297"),
                    "This is the ship that made the Kessel Run in fourteen parsecs?").create();

            System.out.println(message.getSid());
        }
    }