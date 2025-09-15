package com.mromer.establishment_microservice.hotel.infrastructure.adapter.in.rest.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record HotelRoomResponseDTO(
    UUID id,
    String name,
    String description,
    BigDecimal productionCost,
    BigDecimal salePrice,
    Integer capacity,
    Boolean hasTV,
    UUID hotelId,
    String hotelName
) {}
