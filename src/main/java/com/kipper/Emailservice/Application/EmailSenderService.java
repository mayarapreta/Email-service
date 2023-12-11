/*representa um contrato da minha aplição  com os serviços  de promovedores  dos meus email que vou usar
* classe mae e filha*/
package com.kipper.Emailservice.Application;

import com.kipper.Emailservice.adapters.EmailSenderGateway;
import com.kipper.Emailservice.core.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // ESSE EMAIL DEPENDER DELE MESMO QUE É  AQUI


public class EmailSenderService implements EmailSenderUseCase {
private final EmailSenderGateway emailSenderGateway;
@Autowired
public EmailSenderService(EmailSenderGateway emailGaterway){
    this.emailSenderGateway = emailGaterway;
}
    @Override
    public void SendEmail(String to, String subject, String body) {
    this.emailSenderGateway.sendEmail( to ,subject, body); // chamada de caso de uso
    }
}

