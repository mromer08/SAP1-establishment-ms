package com.mromer.establishment_microservice.hotel.application.port.in;

import com.mromer.establishment_microservice.hotel.application.port.in.command.CreateHotelCommand;
import com.mromer.establishment_microservice.hotel.domain.Hotel;

public interface CreateHotelInputPort {
    Hotel createHotel(CreateHotelCommand command);
}
