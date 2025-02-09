package com.agus.ramdan.cdm.exception;

import feign.Response;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Getter
public class BadRequestException extends RuntimeException implements FeighResponError{
    private static final long serialVersionUID = 1L;
    private ErrorValidation[] errors;
    private Response response;
    public BadRequestException(String message){
        super(message);
    }

    public BadRequestException(String message, ErrorValidation[] errors) {
        super(message);
        this.errors = errors;
    }

    public BadRequestException(String message, Response response) {
        super(message);
        this.response = response;
    }
}
