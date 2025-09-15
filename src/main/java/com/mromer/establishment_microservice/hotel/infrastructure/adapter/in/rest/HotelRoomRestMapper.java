package com.mromer.establishment_microservice.hotel.infrastructure.adapter.in.rest;

import com.mromer.establishment_microservice.hotel.domain.HotelRoom;
import com.mromer.establishment_microservice.hotel.infrastructure.adapter.in.rest.dto.HotelRoomResponseDTO;

public class HotelRoomRestMapper {

    public static HotelRoomResponseDTO toResponseDTO(HotelRoom hotelRoom) {
        return new HotelRoomResponseDTO(
            hotelRoom.getId().value(),
            hotelRoom.getName(),
            hotelRoom.getDescription(),
            hotelRoom.getProductionCost(),
            hotelRoom.getSalePrice(),
            hotelRoom.getCapacity(),
            hotelRoom.hasTV(),
            hotelRoom.getEstablishmentId().value(),
            null
        );
    }

    // Sobrecarga del método si necesitas incluir el nombre del hotel
    public static HotelRoomResponseDTO toResponseDTO(HotelRoom hotelRoom, String hotelName) {
        return new HotelRoomResponseDTO(
            hotelRoom.getId().value(),
            hotelRoom.getName(),
            hotelRoom.getDescription(),
            hotelRoom.getProductionCost(),
            hotelRoom.getSalePrice(),
            hotelRoom.getCapacity(),
            hotelRoom.hasTV(),
            hotelRoom.getEstablishmentId().value(),
            hotelName
        );
    }
}