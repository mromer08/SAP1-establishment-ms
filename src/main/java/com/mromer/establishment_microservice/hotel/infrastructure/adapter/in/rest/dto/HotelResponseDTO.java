package com.mromer.establishment_microservice.hotel.infrastructure.adapter.in.rest.dto;

import java.util.UUID;

public record HotelResponseDTO(
    UUID id,
    String name,
    String address,
    String city,
    String phoneNumber,
    String email,
    String nit,
    Boolean hasPool,
    Boolean hasGym,
    boolean active
) {}
