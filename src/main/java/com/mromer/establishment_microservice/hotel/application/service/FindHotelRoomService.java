package com.mromer.establishment_microservice.hotel.application.service;

import com.mromer.establishment_microservice.hotel.application.port.in.FindHotelRoomInputPort;
import com.mromer.establishment_microservice.hotel.application.port.in.command.FindHotelRoomCommand;
import com.mromer.establishment_microservice.hotel.application.port.out.persistence.FindHotelRoomOutputPort;
import com.mromer.establishment_microservice.hotel.domain.HotelRoom;

import org.springframework.data.domain.*;

import java.util.Optional;
import java.util.UUID;

public class FindHotelRoomService implements FindHotelRoomInputPort {

    private final FindHotelRoomOutputPort findHotelRoomOutputPort;

    public FindHotelRoomService(FindHotelRoomOutputPort findHotelRoomOutputPort) {
        this.findHotelRoomOutputPort = findHotelRoomOutputPort;
    }

    @Override
    public Page<HotelRoom> findAll(FindHotelRoomCommand command, Pageable pageable) {
        return findHotelRoomOutputPort.findAll(command, pageable);
    }

    @Override
    public Optional<HotelRoom> findById(UUID roomId) {
        return findHotelRoomOutputPort.findById(roomId);
    }
}
