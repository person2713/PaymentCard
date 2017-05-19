package com.team.mvc.database.services;


import com.team.mvc.configuration.MailConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
@Service
public class SendEMAILMessageService {
    public static final String ACCOUNT_SID = "AC49a8834042c11bb595f9d9ce94d92446";
    public static final String AUTH_TOKEN = "c197119e48fb7cd9704c3b0352f28fc0";

    private ExecutorService executorService = Executors.newCachedThreadPool();

    public void SendMessage(String email, String message) {
        System.out.println("Adding to ThreadPool:" + email + " with message:\n" + message);
        try {
            Future<Void> task = executorService.submit(() -> {
                System.out.println("Start sending SMS to " + email + " with message:\n" + message);
                try {
                    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
                    ctx.register(MailConfig.class);
                    ctx.refresh();
                    JavaMailSenderImpl mailSender = ctx.getBean(JavaMailSenderImpl.class);
                    MimeMessage mimeMessage = mailSender.createMimeMessage();
                    MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage);
                    try {
                        mailMsg.setFrom("trebvit@gmail.com");
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                    try {
                        mailMsg.setTo(email);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                    try {
                        mailMsg.setSubject("Test mail");
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                    try {
                        mailMsg.setText(message,false);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }//
                    mailSender.send(mimeMessage);
                    System.out.println("---Done---");
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
