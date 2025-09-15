package com.mromer.establishment_microservice.hotel.domain;

import com.mromer.establishment_microservice.common.domain.establishment.EstablishmentId;
import com.mromer.establishment_microservice.common.domain.offering.Offering;
import com.mromer.establishment_microservice.common.domain.offering.OfferingId;

import java.math.BigDecimal;

import static com.mromer.establishment_microservice.common.domain.util.DomainValidationUtils.*;

public class HotelRoom extends Offering {

    private final Integer capacity;
    private final boolean hasTV;

    public HotelRoom(OfferingId id,
                     String name,
                     EstablishmentId establishmentId,
                     String description,
                     BigDecimal productionCost,
                     BigDecimal salePrice,
                     Integer capacity,
                     boolean hasTV) {
        super(id, name, establishmentId, description, productionCost, salePrice);

        this.capacity = validateCapacity(capacity);
        this.hasTV = hasTV;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public boolean hasTV() {
        return hasTV;
    }

    private static Integer validateCapacity(Integer capacity) {
        requireNonNull(capacity, "Capacity");
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        return capacity;
    }
}
