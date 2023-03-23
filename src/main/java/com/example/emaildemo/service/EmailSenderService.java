package com.example.emaildemo.service;

import com.example.emaildemo.model.EmailVerification;
import com.example.emaildemo.model.User;
import com.example.emaildemo.repository.EmailVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailVerificationRepository emailVerificationRepository;

    public void sendEmail(String toEmail,
                          String subject,
                          String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("askindaev@gmail.com");
        message.setTo(toEmail);
        EmailVerification emailVerification = createEmailVerification();

        /*Sent verification code to user mail.*/
        body += "\nVerification Code is " + emailVerification.getEmailVerificationCode();

        /* Save to database emailVerification Object*/
        emailVerificationRepository.save(emailVerification);

        message.setText(body);
        message.setSubject(subject);


            mailSender.send(message);




    }

    public EmailVerification createEmailVerification( ) {
        EmailVerification emailVerification = new EmailVerification();
        emailVerification.setEmailVerificationCode("1321");
        return  emailVerification;
    }


}
