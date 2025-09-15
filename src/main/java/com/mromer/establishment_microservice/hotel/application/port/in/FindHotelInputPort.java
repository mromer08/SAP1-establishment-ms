package com.mromer.establishment_microservice.hotel.application.port.in;

import com.mromer.establishment_microservice.hotel.application.port.in.command.FindHotelCommand;
import com.mromer.establishment_microservice.hotel.domain.Hotel;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.*;

public interface FindHotelInputPort {
    Page<Hotel> findAll(FindHotelCommand command, Pageable pageable);
    Optional<Hotel> findById(UUID hotelId);
}
