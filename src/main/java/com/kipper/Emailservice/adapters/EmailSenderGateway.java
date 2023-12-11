//ligaçoes com sesemail

package com.kipper.Emailservice.adapters;

public interface EmailSenderGateway {
     void sendEmail(String to ,String subject, String body);
}
