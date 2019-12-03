package com.project.personaddress.exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "person_address.errors.attributes", havingValue = "true")
public class WebErrorConfiguration {

    @Value("${person_address.api.version}")
    private String currentApiVersion;

    @Value("${person_address.sendreport.uri}")
    private String sendReportUri;

    @Bean
    public ErrorAttributes errorAttributes() {
        return new PersonAddressErrorAttributes(currentApiVersion, sendReportUri);
    }
}
