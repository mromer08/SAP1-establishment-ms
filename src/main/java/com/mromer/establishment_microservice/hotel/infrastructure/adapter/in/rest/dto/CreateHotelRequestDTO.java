package com.mromer.establishment_microservice.hotel.infrastructure.adapter.in.rest.dto;

import jakarta.validation.constraints.*;

public record CreateHotelRequestDTO(
    
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 255, message = "El nombre debe tener entre 2 y 255 caracteres")
    String name,
    
    @Size(max = 1000, message = "La descripción no puede exceder 1000 caracteres")
    String description,
    
    @NotBlank(message = "La dirección es obligatoria")
    @Size(max = 250, message = "La dirección no puede exceder 250 caracteres")
    String address,
    
    @NotBlank(message = "La ciudad es obligatoria")
    @Size(max = 100, message = "La ciudad no puede exceder 100 caracteres")
    String city,
    
    @NotBlank(message = "El número de teléfono es obligatorio")
    @Pattern(regexp = "^\\d{8}$", message = "El número de teléfono debe contener exactamente 8 dígitos")
    String phoneNumber,
    
    @Email(message = "El formato del email no es válido")
    @Size(max = 255, message = "El email no puede exceder 255 caracteres")
    String email,
    
    @NotBlank(message = "El NIT es obligatorio")
    @Pattern(regexp = "^\\d{9}$", message = "El NIT debe contener exactamente 9 dígitos")
    String nit,
    
    @NotNull(message = "El campo hasPool es obligatorio")
    Boolean hasPool,
    
    @NotNull(message = "El campo hasGym es obligatorio")
    Boolean hasGym
) {}
