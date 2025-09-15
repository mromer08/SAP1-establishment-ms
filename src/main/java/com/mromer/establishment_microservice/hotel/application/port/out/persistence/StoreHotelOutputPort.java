package com.mromer.establishment_microservice.hotel.application.port.out.persistence;

import com.mromer.establishment_microservice.hotel.domain.Hotel;

public interface StoreHotelOutputPort {
    Hotel save(Hotel hotel);
}
