package com.mromer.establishment_microservice.common.domain.offering;

import java.util.Objects;
import java.util.UUID;

public record OfferingId(UUID value) {
    public OfferingId {
        Objects.requireNonNull(value, "Offering id cannot be null");
    }

    public static OfferingId generate() {
        return new OfferingId(UUID.randomUUID());
    }
}
