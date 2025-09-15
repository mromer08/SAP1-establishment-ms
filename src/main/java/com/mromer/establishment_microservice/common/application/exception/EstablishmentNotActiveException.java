package com.mromer.establishment_microservice.common.application.exception;

public class EstablishmentNotActiveException extends RuntimeException {
    
    public EstablishmentNotActiveException(String id) {
        super("El establecimiento con ID: " + id + " no se encuentra activo.");
    }
    
}
