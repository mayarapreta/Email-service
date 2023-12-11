package com.kipper.Emailservice.Controllers;

import com.amazonaws.Response;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.kipper.Emailservice.Application.EmailSenderService;
import com.kipper.Emailservice.core.EmailRequest;
import com.kipper.Emailservice.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//ELE DEPENDE DO SENDERCONTROLLER
@RestController
@RequestMapping("/api/email")
public class EmailSendercontroller {

    private  final EmailSenderService emailSenderService;

    @Autowired
    public EmailSendercontroller(EmailSenderService emailService){
        this.emailSenderService = emailService;
    }
    @PostMapping()
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
        try {
            this.emailSenderService.SendEmail(request.to(), request.subject(), request.body());
            return ResponseEntity.ok(body:"EMAIL SEND SUCCESSFULLY");
        }catch (EmailServiceException ex){
          return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while Sending email");
        }
    }
}
