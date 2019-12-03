package com.project.personaddress.controllers.handles;

import com.project.personaddress.exceptions.NonExistingPersonException;
import com.project.personaddress.exceptions.PersonAddressError;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@ConditionalOnProperty(name = "person_address.errors.controlleradvice", havingValue = "true")
public class PersonAddressControllerAdvice {

    @Value(("${person_address.api.version}"))
    private String currentApiVersion;
    @Value(("${person_address.sendreport.uri}"))
    private String sendReportUri;

    public ResponseEntity<PersonAddressError> handleNonExistingPerson(HttpServletRequest request, NonExistingPersonException ex) {
        final PersonAddressError error = new PersonAddressError(
                currentApiVersion,
                ex.getErrorCode(),
                 "The person with this id was not found",
                "person-exceptions",
                "Maybe this id is not registered.",
                "This person not found",
                sendReportUri
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
