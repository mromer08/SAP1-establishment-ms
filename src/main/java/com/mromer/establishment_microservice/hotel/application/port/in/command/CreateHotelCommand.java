package com.mromer.establishment_microservice.hotel.application.port.in.command;

public record CreateHotelCommand(
        String name,
        String address,
        String city,
        String phoneNumber,
        String email,
        String nit,
        boolean hasPool,
        boolean hasGym
) {}


