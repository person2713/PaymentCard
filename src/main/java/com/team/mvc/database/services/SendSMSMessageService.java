package com.team.mvc.database.services;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class SendSMSMessageService {
    public static final String ACCOUNT_SID = "AC49a8834042c11bb595f9d9ce94d92446";
    public static final String AUTH_TOKEN = "c197119e48fb7cd9704c3b0352f28fc0";

    private ExecutorService executorService = Executors.newCachedThreadPool();

    public void SendMessage(String mobileNumber, String message) {
        System.out.println("Adding to ThreadPool:" + mobileNumber + " with message:\n" + message);
        try {
            Future<Void> task = executorService.submit(() -> {
                System.out.println("Start sending SMS to " + mobileNumber + " with message:\n" + message);
                try {
                    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                    Message msg = Message.creator(new PhoneNumber(mobileNumber),
                            new PhoneNumber("+15054040297"),
                            message).create();
                    System.out.println("Message: " + msg.getSid() + " sended");
                } catch (Exception ex) {
                    System.out.println("Error occured: " + ex.getMessage());
                }
                return null;
            });
        } catch (Exception ex) {
            System.out.println("Error occured: " + ex.getMessage());
        }


    }
}
