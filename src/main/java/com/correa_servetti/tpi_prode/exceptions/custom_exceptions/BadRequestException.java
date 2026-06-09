package com.correa_servetti.tpi_prode.exceptions.custom_exceptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String mensaje) {
        super(mensaje);
    }
}
