package com.mromer.establishment_microservice.common.domain.establishment;

import static com.mromer.establishment_microservice.common.domain.util.DomainValidationUtils.*;

public class Establishment {

    private final EstablishmentId id;
    private final String name;
    private final String address;
    private final String city;
    private final PhoneNumber phoneNumber;
    private final Email email;
    private final NIT nit;
    private boolean active;

    public Establishment(EstablishmentId id,
                         String name,
                         String address,
                         String city,
                         PhoneNumber phoneNumber,
                         Email email,
                         NIT nit) {
        this.id = requireNonNull(id, "Identificador de establecimiento");
        this.name = requireNotBlank(name, "Nombre de establecimiento");
        this.address = requireNotBlank(address, "Dirección de establecimiento");
        this.city = requireNotBlank(city, "Ciudad de establecimiento");
        this.phoneNumber = requireNonNull(phoneNumber, "Teléfono de establecimiento");
        this.email = requireNonNull(email, "Email de establecimiento");
        this.nit = requireNonNull(nit, "NIT de establecimiento");
        this.active = true;
    }

    public EstablishmentId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Email getEmail() {
        return email;
    }

    public NIT getNit() {
        return nit;
    }

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
    }
}

