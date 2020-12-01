package com.example.mutiple_reicever_mail;

import com.example.mutiple_reicever_mail.configurationclasses.EmailPropertiesConfiguration;
import com.example.mutiple_reicever_mail.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Component
public class MailContructor {

    @Autowired
    EmailPropertiesConfiguration  props;

    public  void  sendmail(Email email ) throws MessagingException{
        Session session=Session.getInstance(props.setUpMailProperties(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(props.getEmailAndPassword()[0],props.getEmailAndPassword()[1]);
            }
        });
        Message msg=new MimeMessage(session);
        msg.setFrom(new InternetAddress(props.getEmailAndPassword()[0],false));

        msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(props.getEmailRecipients().get(0)));
        msg.setSubject(email.getEmailSubject());
        msg.setContent(email.getEmailBody(),"text/html");
        msg.setSentDate(new Date());
        Transport.send(msg);

    }

}
