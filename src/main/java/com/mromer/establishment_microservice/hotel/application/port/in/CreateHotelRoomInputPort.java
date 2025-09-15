package com.mromer.establishment_microservice.hotel.application.port.in;

import com.mromer.establishment_microservice.hotel.application.port.in.command.CreateHotelRoomCommand;
import com.mromer.establishment_microservice.hotel.domain.HotelRoom;

public interface CreateHotelRoomInputPort {
    HotelRoom createHotelRoom(CreateHotelRoomCommand command);
}
