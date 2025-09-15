package com.mromer.establishment_microservice.hotel.application.port.out.persistence;

import java.util.*;

import org.springframework.data.domain.*;

import com.mromer.establishment_microservice.hotel.application.port.in.command.FindHotelCommand;
import com.mromer.establishment_microservice.hotel.domain.Hotel;

public interface FindHotelsOutputPort {
    Page<Hotel> findAll(FindHotelCommand command, Pageable pageable);
    Optional<Hotel> findById(UUID hotelId);
    boolean existsById(UUID hotelId);
}
