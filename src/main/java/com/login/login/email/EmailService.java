package com.login.login.email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender{
    private final JavaMailSender mailSender;
    private final static Logger LOGGER =LoggerFactory.getLogger(EmailService.class);

    @Override
    @Async
    public void send(String to, String email) throws MessagingException {
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,"utf-8");
        helper.setText(email,true);
        helper.setTo(to);
        helper.setSubject("confirme your email");
        helper.setFrom("gadria.oussama@esprit.tn");
        mailSender.send(mimeMessage);
    }
}
