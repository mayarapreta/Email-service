package com.kipper.Emailservice.core;
//case de use de  regra de negocios classe principal da sainda
public interface EmailSenderUseCase {
    void SendEmail(String to ,String subject , String body);
}
