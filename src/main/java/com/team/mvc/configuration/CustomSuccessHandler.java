package com.team.mvc.configuration;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.services.PersonService;
import com.team.mvc.log.Const;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    public static final Logger logger = Logger.getLogger(CustomSuccessHandler.class.getName());

    @Autowired
    PersonService personService;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            System.out.println("Can't redirect");
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);

        String nickName;
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            nickName = ((UserDetails) principal).getUsername();
        } else {
            nickName = principal.toString();
        }
        Persons person = personService.findByNickname(nickName);
        if (Const.DEBUG) {
            if (logger.isDebugEnabled()) {
                logger.debug("Success login: " +
                        " person: id-" + person.getPersonId() +
                        " Nickname-" + person.getNickname() +
                        " Password-" + person.getPassword() +
                        " Lastname-" + person.getLastName() +
                        " FirstName-" + person.getFirstName() +
                        " Email-" + person.getEmail() +
                        " City-" + person.getCity().getCityName() +
                        " MobileNumber-" + person.getMobileNumber() +
                        " Role-" + person.getRole().getRoleType());
            }
        }
    }


    /*
         * This method extracts the roles of currently logged-in user and returns
         * appropriate URL according to his/her role.
         */
    protected String determineTargetUrl(Authentication authentication) {
        String url = "";

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // для одной роли
        GrantedAuthority auth = authorities.iterator().next();
        String role = auth.getAuthority();


        // для нескольких ролей
//        List<String> roles = new ArrayList<String>();
//        for (GrantedAuthority a : authorities) {
//            roles.add(a.getAuthority());
//        }

        switch (role) {
            case "ROLE_USER":
                url = "/user";
                break;
            case "ROLE_DRIVER":
                url = "/driver";
                break;
            case "ROLE_OWNER":
                url = "/owner";
                break;
            case "ROLE_ADMIN":
                url = "/admin";
                break;
            default:
                url = "/accessDenied";
        }

        return url;
    }


    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}
