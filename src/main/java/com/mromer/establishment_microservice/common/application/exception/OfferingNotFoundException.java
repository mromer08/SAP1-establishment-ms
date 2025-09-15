package com.mromer.establishment_microservice.common.application.exception;

public class OfferingNotFoundException extends RuntimeException {
    public OfferingNotFoundException(String id) {
        super("Servicio/Bien con ID " + id + " no encontrado.");
    }
    
}
