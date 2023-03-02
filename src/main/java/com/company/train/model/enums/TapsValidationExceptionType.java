package com.company.train.model.enums;

public enum TapsValidationExceptionType {
    MISSING_TAPS("Missing taps"),

    INVALID_TOTAL_TAPS_SIZE("Taps size should be even."),

    MISSING_CUSTOMER_ID("Missing customer Id."),
    
    MISSING_STATION("Missing station."),
    
    MISSING_UNIXTIMESTAMP("UnixTimestamp could not be null."),

    INVALID_UNIXTIMESTAMP("Invalid unixtimestamp."),

    INVALID_CUSTOMER_TAPS_SIZE("Missing tap for customer"),

    INPUT_FILE_PARSING_ERROR("Error while parsing input file"),

    OUTPUT_FILE_WRITING_ERROR("Error while writing output file");

    private final String message;

    TapsValidationExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
