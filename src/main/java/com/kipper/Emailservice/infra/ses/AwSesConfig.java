package com.kipper.Emailservice.infra.ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClientBuilder;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwSesConfig {
    @Bean
    public AmazonSimpleEmailService amazonSimplesEmailService(){
        return AmazonSimplesEmailServiceClientBuilder().standard().build();
    }




}
