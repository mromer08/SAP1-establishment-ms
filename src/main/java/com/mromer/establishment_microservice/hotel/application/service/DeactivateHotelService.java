package com.mromer.establishment_microservice.hotel.application.service;

import java.util.UUID;

import com.mromer.establishment_microservice.hotel.application.exception.HotelNotFoundException;
import com.mromer.establishment_microservice.hotel.application.port.in.DeactivateHotelInputPort;
import com.mromer.establishment_microservice.hotel.application.port.out.persistence.FindHotelsOutputPort;
import com.mromer.establishment_microservice.hotel.application.port.out.persistence.StoreHotelOutputPort;
import com.mromer.establishment_microservice.hotel.domain.Hotel;

public class DeactivateHotelService implements DeactivateHotelInputPort{
    private final FindHotelsOutputPort findHotelsOutputPort;
    private final StoreHotelOutputPort storeHotelOutputPort;

    public DeactivateHotelService(FindHotelsOutputPort findHotelsOutputPort, StoreHotelOutputPort storeHotelOutputPort) {
        this.findHotelsOutputPort = findHotelsOutputPort;
        this.storeHotelOutputPort = storeHotelOutputPort;
    }

    @Override
    public void deactivateHotel(UUID hotelId) {
        Hotel hotel = findHotelsOutputPort.findById(hotelId)
                .orElseThrow(() -> new HotelNotFoundException(hotelId.toString()));

        hotel.deactivate();
        storeHotelOutputPort.save(hotel);
    }
    
}
