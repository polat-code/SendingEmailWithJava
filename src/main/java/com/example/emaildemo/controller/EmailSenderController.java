package com.example.emaildemo.controller;

import com.example.emaildemo.exceptions.EmptyEmailFieldException;
import com.example.emaildemo.model.User;
import com.example.emaildemo.service.EmailSenderService;
import com.example.emaildemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSenderController {

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private UserService userService;
    @PostMapping("/sendEmail")
    public void sendEmail(@RequestBody User user) throws Exception  {
        if(user.getEmail() != null) {
            emailSenderService.sendEmail(user.getEmail(),"Verify Email","This mail is to verify email.To Log in , please verify your email");
            userService.saveUser(user);
        }else {
            throw new EmptyEmailFieldException("Empty Email Address");
        }

    }
}
