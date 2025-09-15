package com.mromer.establishment_microservice.hotel.application.service;

import com.mromer.establishment_microservice.hotel.application.port.in.FindHotelInputPort;
import com.mromer.establishment_microservice.hotel.application.port.in.command.FindHotelCommand;
import com.mromer.establishment_microservice.hotel.application.port.out.persistence.FindHotelsOutputPort;
import com.mromer.establishment_microservice.hotel.domain.Hotel;

import org.springframework.data.domain.*;

import java.util.*;

public class FindHotelService implements FindHotelInputPort {

    private final FindHotelsOutputPort findHotelsOutputPort;

    public FindHotelService(FindHotelsOutputPort findHotelsOutputPort) {
        this.findHotelsOutputPort = findHotelsOutputPort;
    }

    @Override
    public Page<Hotel> findAll(FindHotelCommand command, Pageable pageable) {
        return findHotelsOutputPort.findAll(command, pageable);
    }

    @Override
    public Optional<Hotel> findById(UUID hotelId) {
        return findHotelsOutputPort.findById(hotelId);
    }
}
