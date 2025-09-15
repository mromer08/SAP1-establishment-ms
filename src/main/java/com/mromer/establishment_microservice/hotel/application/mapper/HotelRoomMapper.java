package com.mromer.establishment_microservice.hotel.application.mapper;

import com.mromer.establishment_microservice.common.domain.establishment.EstablishmentId;
import com.mromer.establishment_microservice.common.domain.offering.OfferingId;
import com.mromer.establishment_microservice.hotel.application.port.in.command.CreateHotelRoomCommand;
import com.mromer.establishment_microservice.hotel.domain.HotelRoom;

public class HotelRoomMapper {

    private HotelRoomMapper() {
        // Private constructor to prevent instantiation
    }

    public static HotelRoom toDomain(CreateHotelRoomCommand command) {
        return new HotelRoom(
                OfferingId.generate(),
                command.name(),
                new EstablishmentId(command.hotelId()),
                command.description(),
                command.productionCost(),
                command.salePrice(),
                command.capacity(),
                command.hasTV()
        );
    }
}
