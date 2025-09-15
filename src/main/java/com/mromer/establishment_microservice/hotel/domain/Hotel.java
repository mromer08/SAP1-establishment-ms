package com.mromer.establishment_microservice.hotel.domain;

import com.mromer.establishment_microservice.common.domain.establishment.*;

public class Hotel extends Establishment {

    private final boolean hasPool;
    private final boolean hasGym;

    public Hotel(EstablishmentId id,
                 String name,
                 String address,
                 String city,
                 PhoneNumber phoneNumber,
                 Email email,
                 NIT nit,
                 boolean hasPool,
                 boolean hasGym) {
        super(id, name, address, city, phoneNumber, email, nit);
        this.hasPool = hasPool;
        this.hasGym = hasGym;
    }

    public boolean hasPool() {
        return hasPool;
    }

    public boolean hasGym() {
        return hasGym;
    }
}
