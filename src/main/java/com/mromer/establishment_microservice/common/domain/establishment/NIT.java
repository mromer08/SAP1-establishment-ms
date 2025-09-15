package com.mromer.establishment_microservice.common.domain.establishment;

import java.util.Objects;

public record NIT(String value) {
    public NIT {
        Objects.requireNonNull(value, "El NIT no puede ser nulo");
        if (!value.matches("\\d{9}")) {
            throw new IllegalArgumentException("El NIT debe tener exactamente 9 digitos");
        }
    }
}
