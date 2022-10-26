package com.email.email_02.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendTo(String email, String title, String text) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(email);
        helper.setSubject(title);
        helper.setText("<h1>Test Hello</h1> <h2>Testing description by Mirko</h2> <h3>" + text + "</h3>" + "<img src='cid:img' width=600>", true);
        ClassPathResource image = new ClassPathResource("img.png");
        helper.addInline("img", image);
        javaMailSender.send(message);
    }
}
