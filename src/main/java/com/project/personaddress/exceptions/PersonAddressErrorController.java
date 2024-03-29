package com.project.personaddress.exceptions;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

@RestControllerAdvice
@RequestMapping({ PersonAddressErrorController.ERROR_PATH })
@ConditionalOnProperty(name = "person_address.errors.controller", havingValue = "true")
public class PersonAddressErrorController extends AbstractErrorController {

    static final String ERROR_PATH = "/error";

    public PersonAddressErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes, Collections.emptyList());
    }

    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = this.getErrorAttributes(request, false);
        HttpStatus status = this.getStatus(request);
        return new ResponseEntity<>(body, status);
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
