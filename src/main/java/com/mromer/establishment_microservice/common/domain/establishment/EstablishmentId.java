package com.mromer.establishment_microservice.common.domain.establishment;

import java.util.Objects;
import java.util.UUID;

public record EstablishmentId(UUID value) {
    public EstablishmentId {
        Objects.requireNonNull(value, "El identificador del establecimiento no puede ser nulo");
    }

    public static EstablishmentId generate() {
        return new EstablishmentId(UUID.randomUUID());
    }
}
