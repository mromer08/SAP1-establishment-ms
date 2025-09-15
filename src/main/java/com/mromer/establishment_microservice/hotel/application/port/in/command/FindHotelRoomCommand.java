package com.mromer.establishment_microservice.hotel.application.port.in.command;

import java.math.BigDecimal;

public record FindHotelRoomCommand(
    String name,
    BigDecimal minSalePrice,
    BigDecimal maxSalePrice,
    Integer minCapacity,
    Integer maxCapacity,
    Boolean hasTV
) {}
