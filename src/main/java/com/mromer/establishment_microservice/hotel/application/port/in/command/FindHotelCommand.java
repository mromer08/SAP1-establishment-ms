package com.mromer.establishment_microservice.hotel.application.port.in.command;

public record FindHotelCommand(
        String name,
        String city,
        Boolean hasPool,
        Boolean hasGym,
        Boolean active
) {}
