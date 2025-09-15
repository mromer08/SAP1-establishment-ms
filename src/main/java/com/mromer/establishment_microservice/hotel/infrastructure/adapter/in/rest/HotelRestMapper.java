package com.mromer.establishment_microservice.hotel.infrastructure.adapter.in.rest;

import com.mromer.establishment_microservice.hotel.domain.Hotel;
import com.mromer.establishment_microservice.hotel.infrastructure.adapter.in.rest.dto.HotelResponseDTO;

public class HotelRestMapper {

    public static HotelResponseDTO toResponseDTO(Hotel hotel) {
        return new HotelResponseDTO(
            hotel.getId().value(),
            hotel.getName(),
            hotel.getAddress(),
            hotel.getCity(),
            hotel.getPhoneNumber().value(),
            hotel.getEmail().value(),
            hotel.getNit().value(),
            hotel.hasPool(),
            hotel.hasGym(),
            hotel.isActive()
        );
    }
}