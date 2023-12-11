// criando camada de infraestrutura
// usando ipa google e outras comunicaçoes
// MINHA CLASSE DO WEB PRINCIPAL
package com.kipper.Emailservice.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.kipper.Emailservice.adapters.EmailSenderGateway;
import com.kipper.Emailservice.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
@Service // isso é uma anotação de todos os serviçoes
public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService amazonSimpleEmailService;
    @Autowired //isso vai ser injetado  por isso que usa autorried
    public  SesEmailSender (AmazonSimpleEmailService amazonSimpleEmailService){
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }
    @Override // montando os String para as mensagens do nossos origens
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource(" LivesMayaKipper@gmail.com")
                .withDestination( new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject( new Content(subject))
                        .withBody(new Body().withText(new Content(body))));
        try {
          this.amazonSimpleEmailService.sendEmail(request) ; //se caso da um error
        }catch (AmazonServiceException exception){

            // caso um error maior, isso é criação de exceçao
            // E é ligação do emailserviceException
            throw  new EmailServiceException("Failure while sending email", exception);
        }
    }
}
