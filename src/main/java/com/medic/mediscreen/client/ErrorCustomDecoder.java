package com.medic.mediscreen.client;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ErrorCustomDecoder implements feign.codec.ErrorDecoder {

    private final ErrorDecoder defaultDecoder = new Default();
    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == 404){
            return new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "The id specify in the request do not correspond to any existing object");
        }
        return defaultDecoder.decode(s, response);
    }
}
