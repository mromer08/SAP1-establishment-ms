package com.mromer.establishment_microservice.hotel.infrastructure.adapter.in.rest.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.UUID;

public record CreateHotelRoomRequestDTO(
    
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 255, message = "El nombre debe tener entre 2 y 255 caracteres")
    String name,
    
    @Size(max = 1000, message = "La descripción no puede exceder 1000 caracteres")
    String description,
    
    @NotNull(message = "El costo de producción es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El costo de producción debe ser mayor a 0")
    @Digits(integer = 10, fraction = 2, message = "El costo de producción debe tener máximo 10 enteros y 2 decimales")
    BigDecimal productionCost,
    
    @NotNull(message = "El precio de venta es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio de venta debe ser mayor a 0")
    @Digits(integer = 10, fraction = 2, message = "El precio de venta debe tener máximo 10 enteros y 2 decimales")
    BigDecimal salePrice,
    
    @NotNull(message = "La capacidad es obligatoria")
    @Min(value = 1, message = "La capacidad mínima es 1")
    @Max(value = 10, message = "La capacidad máxima es 10")
    Integer capacity,
    
    @NotNull(message = "El campo hasTV es obligatorio")
    Boolean hasTV,
    
    @NotNull(message = "El ID del hotel es obligatorio")
    UUID hotelId
) {}
