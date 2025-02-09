package com.agus.ramdan.cdm.exception;

import feign.FeignException.*;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
@Log4j2
public class CustomFeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        String message = "Unknown error";

        try {
            if (response.body() != null) {
                message = response.body().toString();
                log.error(message);
            }
        } catch (Exception ignored) {}

        int status = response.status();

        if (status == HttpStatus.BAD_REQUEST.value()) {
            return new BadRequestException("Propagation Bad Request",response);
        } else if (status == HttpStatus.NOT_FOUND.value()) {
            return new ResourceNotFoundException("Propagation Not Found",response);
        } else if (status == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            return new InternalServerErrorException("Propagation Internal Server Error",response);
        }
        return new InternalServerErrorException("Internal Server Error", response);
    }
}
