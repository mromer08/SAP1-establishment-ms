package com.mromer.establishment_microservice.hotel.infrastructure.adapter.in.rest.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record FindHotelRoomRequestDTO(
    
    @Size(max = 255, message = "El nombre no puede exceder 255 caracteres")
    String name,
    
    BigDecimal minSalePrice,
    
    BigDecimal maxSalePrice,
    
    Integer minCapacity,
    
    Integer maxCapacity,
    
    Boolean hasTV
) {}
