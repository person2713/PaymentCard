package com.team.mvc.controller;

import com.team.mvc.configuration.MailConfig;
import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.services.BlackListService;
import com.team.mvc.database.services.PersonService;
import com.team.mvc.util.GenericResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;


import javax.crypto.spec.SecretKeySpec;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Period;
import java.util.List;
import java.util.Locale;

import com.team.mvc.database.services.BlackListService;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.security.Key;
import java.util.Date;

@Controller
@RequestMapping("/")
public class AppController {



    private static final Logger logger = Logger.getLogger(AppController.class.getName());


    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;
    @Autowired
    BlackListService blackListService;
    @Autowired
    PersonService personService;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private MessageSource messages;

    @ModelAttribute("blockCards")
    public List<Cards> getAllBlockCards() { return blackListService.getAllBlockCards();}

   /* @RequestMapping(value = "/blockCards/", method = RequestMethod.GET)
    public ResponseEntity<List<Cards>> listAllBlockCards() {
        List<Cards> cardsList = blackListService.getAllBlockCards();
        if(cardsList.isEmpty()){
            return new ResponseEntity< List<Cards>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity< List<Cards>>(cardsList, HttpStatus.OK);
    }*/



    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Welcome to the first page of the project");
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", GetRole.getPrincipal());
        return "admin/admin";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(ModelMap model) {
        model.addAttribute("user", GetRole.getPrincipal());
        return "user/user";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", GetRole.getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        // как перенаправить пользователя на определенную страницу в зависимости от роли?
        if (isCurrentAuthenticationAnonymous())
            return "login";
        else {
            if (GetRole.hasRole("ROLE_ADMIN"))
                return "redirect:/admin";
            else
                return "redirect:/user";
        }
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

 /*   @RequestMapping(value = "/resetPassword",
            method = RequestMethod.POST)
    @ResponseBody
    public void resetPassword(HttpServletRequest request,
                                         @RequestParam("email") String userEmail) {
        Persons person = personService.findByEmail(userEmail);
        if (person == null) {
         //   throw new UserNotFoundException();
        }


        mailSender.send(constructResetTokenEmail(person,request.getLocale()));}*/







  /*  private final SimpleMailMessage constructResetTokenEmail(final Persons person,final Locale locale) {

        final String message = messages.getMessage("We will send an email with a new registration token to your email account",null, locale);
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(person.getEmail());
        email.setSubject("Password");
        email.setText(message + person.getPassword());
        email.setFrom("trebvit@gmail.com");
        return email;
    }
*/

    @RequestMapping(value="/forgotPassword")
    public String forgotPassword()
    {
        return "forgotPassword";
    }

    @RequestMapping(value="/resetPassword" , method=RequestMethod.POST)
    public String resetRequest(@RequestParam(value="email") String email){

        Persons person = personService.findByEmail(email);
        String mail = person.getEmail();
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
            mailMsg.setTo(mail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            mailMsg.setSubject("Test mail");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            mailMsg.setText("<html><body>hi,<br/><a href='http://localhost:9555/newPass/"+createToken(email)+"/'> Click here</a> to reset password</body></html>",true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }//
        mailSender.send(mimeMessage);
        System.out.println("---Done---");


        return "checkMail";
    }

    @RequestMapping(value="/newPass/{email}/" )
    public String resetPassword(@PathVariable String email /*,Map<String,String> model*/)
    {
        //check if the email id is valid and registered with us.
      //model.put("emailid", email);
        String mail = readMailIdFromToken(email);
//        Persons person = personService.findByEmail(email);
//        System.out.println(person);
        return "newPass";
    }



    public String createToken( String mail )
    {

        Claims claims = Jwts.claims().setSubject( String.valueOf( mail ) );
        byte secret = (byte) 12345;
        claims.put( "mail", mail );
        Date currentTime = new Date();
        currentTime.setTime( currentTime.getTime() +   60000 );
        return Jwts.builder()
                .setClaims( claims )
                .setExpiration( currentTime )
                .signWith( SignatureAlgorithm.HS512, /*salt.getBytes()*/ "secretkey")
                .compact();

    }






    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver. isAnonymous(authentication);
    }

    public String readMailIdFromToken( String token )
    {
        byte secret = (byte) 12345;
        Jwts.parser().setSigningKey(/* salt.getBytes()*/"secretkey" ).parseClaimsJws( token ).getSignature();
        Jws<Claims> parseClaimsJws = Jwts.parser().setSigningKey( /*salt.getBytes()*/"secretkey" ).parseClaimsJws( token );
        return parseClaimsJws.getBody().getSubject();
    }
}
