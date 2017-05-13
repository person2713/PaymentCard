package com.team.mvc.API.Terminal;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import javax.servlet.http.HttpServletRequest;

public class Utils {
    public static CsrfToken getCsrfToken(HttpServletRequest request) {
        CsrfToken token = new HttpSessionCsrfTokenRepository().loadToken(request);
        if (token == null) {
            token = new HttpSessionCsrfTokenRepository().generateToken(request);
            new HttpSessionCsrfTokenRepository().saveToken(token, request, null);
        }
        return token;
    }
}
