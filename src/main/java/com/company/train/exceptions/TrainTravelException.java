package com.company.train.exceptions;

import com.company.train.model.enums.TapsValidationExceptionType;

public class TrainTravelException extends RuntimeException {

    private final TapsValidationExceptionType type;

    public TrainTravelException(TapsValidationExceptionType type) {
        this(type, type.getMessage());
    }

    public TrainTravelException(TapsValidationExceptionType type, String message) {
        this(type, message, null);
    }

    public TrainTravelException(TapsValidationExceptionType type, Throwable e) {
        this(type, type.getMessage(), e);
    }

    public TrainTravelException(TapsValidationExceptionType type, String message, Throwable e) {
        super(message, e);
        this.type = type;
    }

}
