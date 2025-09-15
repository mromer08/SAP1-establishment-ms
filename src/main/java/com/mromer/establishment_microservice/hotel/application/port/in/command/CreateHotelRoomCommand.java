package com.mromer.establishment_microservice.hotel.application.port.in.command;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateHotelRoomCommand(
        String name,
        String description,
        BigDecimal productionCost,
        BigDecimal salePrice,
        Integer capacity,
        boolean hasTV,
        UUID hotelId
) {}

