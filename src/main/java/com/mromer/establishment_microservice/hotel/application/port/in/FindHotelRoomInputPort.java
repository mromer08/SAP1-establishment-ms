package com.mromer.establishment_microservice.hotel.application.port.in;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.*;

import com.mromer.establishment_microservice.hotel.application.port.in.command.FindHotelRoomCommand;
import com.mromer.establishment_microservice.hotel.domain.HotelRoom;

public interface FindHotelRoomInputPort {
    Page<HotelRoom> findAll(FindHotelRoomCommand command, Pageable pageable);
    Optional<HotelRoom> findById(UUID hotelRoomId);
}
