package com.team.mvc.controller;

import com.team.mvc.configuration.MailConfig;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.services.BlackListService;
import com.team.mvc.database.services.PersonService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**

 */

@Controller
@Scope("session")
public class ResetPass {
   @Autowired
   Mail maill;

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
    @RequestMapping(value="/forgotPassword")
    public String forgotPassword()
    {
        return "forgotPassword";
    }

    @RequestMapping(value="/resetPassword" , method=RequestMethod.POST)
    public String resetRequest(@RequestParam(value="email") String email, Model model){
try{

    if (personService.findByEmail(email)==null) {
        model.addAttribute("flag", true);
        return "/reset_pass";
    }

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
            mailMsg.setSubject("Восстановление пароля");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            mailMsg.setText("<html><body>hi,<br/><a href='http://localhost:9000/newPass?email="+createToken(email)+"'> Click here</a> to reset password</body></html>",true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }//
        mailSender.send(mimeMessage);
        System.out.println("---Done---");


        return "checkMail";}
        catch (Exception E){return "errorPage";}
    }

    @RequestMapping(value="/newPass" , method=RequestMethod.GET)
    public String resetPassword(@RequestParam(value="email") String email /*,Map<String,String> model*/)
    {
        try{

            //check if the email id is valid and registered with us.
        //model.put("emailid", email);
         maill.setMail(readMailIdFromToken(email));
        System.out.println(maill);
//        Persons person = personService.findByEmail(email);
//        System.out.println(person);
        return "enter_new_pass";}
        catch (Exception E){return "errorPage";}
    }
    @RequestMapping(value="/updPass" ,method=RequestMethod.POST)
    public String updPassword(@RequestParam(value="pass") String pass /*,Map<String,String> model*/)
    {
        try{
        System.out.println(maill.toString()+"   updPassword");
        personService.updPass(maill.toString(),pass);
        //check if the email id is valid and registered with us.
        //model.put("emailid", email);
      //  String  mail = readMailIdFromToken(maill.getMail());

//        Persons person = personService.findByEmail(email);
//        System.out.println(person);
        return "success_pass";}
        catch (Exception E){return "errorPage";}
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








    public String readMailIdFromToken( String token )
    {
        byte secret = (byte) 12345;
        Jwts.parser().setSigningKey(/* salt.getBytes()*/"secretkey" ).parseClaimsJws( token ).getSignature();
        Jws<Claims> parseClaimsJws = Jwts.parser().setSigningKey( /*salt.getBytes()*/"secretkey" ).parseClaimsJws( token );
        return parseClaimsJws.getBody().getSubject();
    }
}
