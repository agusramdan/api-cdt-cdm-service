package com.agus.ramdan.cdm.exception;

import feign.Response;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
public class ResourceNotFoundException extends RuntimeException implements FeighResponError{

    private static final long serialVersionUID = 1L;
    private Response response;
    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(String message, Response response) {
        super(message);
        this.response = response;
    }
}
