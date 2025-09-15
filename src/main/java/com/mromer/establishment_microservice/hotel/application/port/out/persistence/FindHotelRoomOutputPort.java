package com.mromer.establishment_microservice.hotel.application.port.out.persistence;

import java.util.*;

import org.springframework.data.domain.*;

import com.mromer.establishment_microservice.hotel.application.port.in.command.FindHotelRoomCommand;
import com.mromer.establishment_microservice.hotel.domain.HotelRoom;

public interface FindHotelRoomOutputPort {
    Page<HotelRoom> findAll(FindHotelRoomCommand command, Pageable pageable);
    Optional<HotelRoom> findById(UUID hotelRoomId);
    boolean existsById(UUID hotelRoomId);
}
