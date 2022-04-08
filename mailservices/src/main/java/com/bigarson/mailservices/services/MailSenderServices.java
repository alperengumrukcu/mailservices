package com.bigarson.mailservices.services;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Service
public class MailSenderServices {
    private JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    private MimeMessage message = mailSender.createMimeMessage();
    private Properties props = mailSender.getJavaMailProperties();

    public  MailSenderServices() {
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("");
        mailSender.setPassword("");
        // ------------------------------------------------------
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
    }

    public void sendEmail(String to, String subject, HashMap<String, String> model) throws MessagingException, IOException {
        MimeMessageHelper helper = new MimeMessageHelper(message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        File file = new File("../templates/verify.html");
        FileInputStream io = new FileInputStream(file);
        String html = new String(io.readAllBytes(),StandardCharsets.UTF_8);
        for (Map.Entry<String,String> entry : model.entrySet()) {
          html  =  html.replace("${"+entry.getKey()+"}",entry.getValue());
        }
        helper.setTo(to);
        helper.setFrom("bigarsontest@gmail.com");
        helper.setSubject(subject);
        helper.setText(html, true);
        mailSender.send(message);
    }
}
