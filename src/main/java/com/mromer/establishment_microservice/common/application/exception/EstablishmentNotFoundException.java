package com.mromer.establishment_microservice.common.application.exception;

public class EstablishmentNotFoundException extends RuntimeException {
    public EstablishmentNotFoundException(String id) {
        super("Establecimiento con ID " + id + " no encontrado.");
    }
    
}
