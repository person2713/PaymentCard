package com.team.mvc.configuration;


import com.team.mvc.log.Const;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomFailureHandler implements AuthenticationFailureHandler {

    public static final Logger logger = Logger.getLogger(CustomFailureHandler.class.getName());

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {


        String targetUrl = "/login";

        redirectStrategy.sendRedirect(request, response, targetUrl);
//        System.out.println("CUSTOMFAILUREHANDLER " + request.getParameter("nickName") + " " + request.getParameter("password"));

        if (Const.DEBUG) {
            if (logger.isDebugEnabled()) {
                logger.debug("Unsuccessful login:" +
                        " Nickname-" + request.getParameter("nickName") +
                        " Password-" +request.getParameter("password"));
            }
        }
    }


}
