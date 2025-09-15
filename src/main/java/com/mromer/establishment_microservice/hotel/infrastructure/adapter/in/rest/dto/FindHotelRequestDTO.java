package com.mromer.establishment_microservice.hotel.infrastructure.adapter.in.rest.dto;

import jakarta.validation.constraints.Size;

public record FindHotelRequestDTO(
    
    @Size(max = 255, message = "El nombre no puede exceder 255 caracteres")
    String name,
    
    @Size(max = 100, message = "La ciudad no puede exceder 100 caracteres")
    String city,
    
    Boolean hasPool,
    
    Boolean hasGym,
    
    Boolean active
) {}
