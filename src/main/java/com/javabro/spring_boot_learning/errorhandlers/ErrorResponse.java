package com.javabro.spring_boot_learning.errorhandlers;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ErrorResponse implements Serializable {
    private String errorMessage;
    private String errorDescription;
    private LocalDateTime timestamp;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "errorMessage='" + errorMessage + '\'' +
                ", errorDescription='" + errorDescription + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
