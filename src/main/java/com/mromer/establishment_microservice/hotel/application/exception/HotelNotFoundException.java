package com.mromer.establishment_microservice.hotel.application.exception;

import com.mromer.establishment_microservice.common.application.exception.EstablishmentNotFoundException;

public class HotelNotFoundException extends EstablishmentNotFoundException {
    
    public HotelNotFoundException(String id) {
        super(id);
    }
    
}
