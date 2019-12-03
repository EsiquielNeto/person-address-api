package com.project.personaddress.exceptions;

import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
public class PersonAddressError {

    private String apiVersion;
    private ErrorBlock errorBlock;

    public PersonAddressError(String apiVersion, String code, String message, String domain, String reason, String errorMessage,
                              String errorReportUri) {
        this.apiVersion = apiVersion;
        this.errorBlock = new ErrorBlock(code, message, domain, reason, errorMessage, errorReportUri);
    }

    public static PersonAddressError formDefaultAttibuteMap(String apiVersion, Map<String, Object> defaultErrorAttributes, String sendReportBaseurl) {
        return new PersonAddressError(
                apiVersion,
                ((Integer) defaultErrorAttributes.get("status")).toString(),
                (String) defaultErrorAttributes.getOrDefault("message", "no message available"),
                (String) defaultErrorAttributes.getOrDefault("path", "no domain available"),
                (String) defaultErrorAttributes.getOrDefault("error", "no reason available"),
                (String) defaultErrorAttributes.get("message"),
                sendReportBaseurl
        );
    }

    public Map<String, Object> toAttribute() {
        return Map.of("apiVersion", apiVersion, "error", errorBlock);
    }

    @Getter
    private static final class ErrorBlock {
        private UUID uniqueId;
        private String code;
        private String message;
        private List<Error> errors;

        public ErrorBlock(UUID uniqueId, String code, String message, List<Error> errors) {
            this.uniqueId = uniqueId;
            this.code = code;
            this.message = message;
            this.errors = errors;
        }

        private ErrorBlock(String code, String message, String domain, String reason, String errorMessage,
                           String errorReportUri) {

            this.code = code;
            this.message = message;
            this.errors = List.of(new Error(domain, reason, errorMessage, errorReportUri + "?id" + this.uniqueId));
        }

        public static ErrorBlock copyWithMessage(final ErrorBlock s, final String message) {
            return new ErrorBlock(s.uniqueId, s.code, message, s.errors);
        }
    }

    @Getter
    private static final class Error {
        private final String domain;
        private final String reason;
        private final String message;
        private final String sendReport;

        public Error(String domain, String reason, String message, String sendReport) {
            this.domain = domain;
            this.reason = reason;
            this.message = message;
            this.sendReport = sendReport;
        }
    }

}
