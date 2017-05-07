package com.team.mvc.controller;

/**

 */
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.team.mvc.configuration.MailConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
public class SendSimpleMail {
    public static void main(String[] args) throws MessagingException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MailConfig.class);
        ctx.refresh();
        JavaMailSenderImpl mailSender = ctx.getBean(JavaMailSenderImpl.class);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage);
        mailMsg.setFrom("trebvit@gmail.com");
        mailMsg.setTo("alexdruggg@yandex.ru");
        mailMsg.setSubject("Test mail");
        mailMsg.setText("Hello World!");
        mailSender.send(mimeMessage);
        System.out.println("---Done---");
    }
}