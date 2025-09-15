package com.mromer.establishment_microservice.hotel.application.port.in;

import java.util.UUID;

public interface DeactivateHotelInputPort {
    void deactivateHotel(UUID hotelId);
}
