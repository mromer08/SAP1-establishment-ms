package com.mromer.establishment_microservice.hotel.application.exception;

import com.mromer.establishment_microservice.common.application.exception.OfferingNotFoundException;

public class HotelRoomNotFoundException extends OfferingNotFoundException {
    public HotelRoomNotFoundException(String id) {
        super(id);
    }
    
}
