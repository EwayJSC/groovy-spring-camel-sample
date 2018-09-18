package com.eway.common.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class EwayException extends Exception {

    private int code
    private String userMessage

    EwayException(int code) {
        this.code = code
    }

    EwayException(String message) {
        super(message)
    }

    EwayException(int code, String userMessage) {
        this.code = code
        this.userMessage = userMessage
    }

    EwayException(int code, String userMessage, String message) {
        super(message)
        this.code = code
        this.userMessage = userMessage
    }

    int getCode() {
        return code
    }

    void setCode(int code) {
        this.code = code
    }

    String getUserMessage() {
        return userMessage
    }

    void setUserMessage(String userMessage) {
        this.userMessage = userMessage
    }

    @Override
    String toString() {
        return "EwayException{" +
            "code=" + code +
            ", userMessage='" + userMessage + '\'' +
            "}"
    }
}
