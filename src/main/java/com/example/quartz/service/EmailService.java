package com.example.quartz.service;


import com.example.quartz.config.EmailConfig;
import com.example.quartz.entities.EmailRequest;
import com.example.quartz.entities.User;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@JsonSerialize
@Service
public class EmailService {
    private EmailConfig emailConfig;

    public EmailRequest sendEmail(EmailRequest emailRequest){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailConfig.getHost());
        mailSender.setPort(this.emailConfig.getPort());
        mailSender.setUsername(this.emailConfig.getUsername());
        mailSender.setPassword(this.emailConfig.getPassword());

        //create an mail instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(emailRequest.getMail());
        mailMessage.setTo("samett.mahdi@gmail.com");
        mailMessage.setSubject("New feedback from"+emailRequest.getName());
        mailMessage.setText(emailRequest.getFeedback());

        //Send mail
        mailSender.send(mailMessage);
        return (emailRequest);
    }
}
