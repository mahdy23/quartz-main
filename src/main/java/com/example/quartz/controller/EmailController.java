package com.example.quartz.controller;
import com.example.quartz.entities.EmailRequest;
import com.example.quartz.entities.User;
import com.example.quartz.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;
@AllArgsConstructor
@RestController
@RequestMapping("feedback")
public class EmailController {


private  EmailService emailService;


    @PostMapping
    public void sendEmail(@RequestBody EmailRequest emailRequest,
                             BindingResult bindingResult) throws ValidationException {

if (bindingResult.hasErrors()){
    throw new ValidationException("feedback not valid");
}
 emailService.sendEmail(emailRequest);




    }



}
