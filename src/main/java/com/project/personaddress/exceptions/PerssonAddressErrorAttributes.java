package com.project.personaddress.exceptions;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

class PersonAddressErrorAttributes extends DefaultErrorAttributes {

    private final String currentApiVersion;
    private final String sendReportUri;

    public PersonAddressErrorAttributes(String currentApiVersion, String sendReportUri) {
        this.currentApiVersion = currentApiVersion;
        this.sendReportUri = sendReportUri;
    }

    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        final Map<String, Object> defaultErrorAttributes = super.getErrorAttributes(webRequest, false);
        final PersonAddressError personAddressError = PersonAddressError.formDefaultAttibuteMap(currentApiVersion, defaultErrorAttributes, sendReportUri);
        return personAddressError.toAttribute();
    }
}
