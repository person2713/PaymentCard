package com.team.mvc.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**

 */
@Scope("session")
@Component
public class Mail {
    String mail;
    public Mail() {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return mail;
    }
}
