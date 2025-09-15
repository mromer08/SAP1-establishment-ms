package com.mromer.establishment_microservice.hotel.infrastructure.adapter.out.persistence;

import com.mromer.establishment_microservice.common.domain.establishment.Email;
import com.mromer.establishment_microservice.common.domain.establishment.EstablishmentId;
import com.mromer.establishment_microservice.common.domain.establishment.NIT;
import com.mromer.establishment_microservice.common.domain.establishment.PhoneNumber;
import com.mromer.establishment_microservice.hotel.domain.Hotel;

public class HotelEntityMapper {
    
    public static Hotel toDomain(HotelEntity entity) {
        Hotel hotel = new Hotel(
            new EstablishmentId(entity.getId()),
            entity.getName(),
            entity.getAddress(),
            entity.getCity(),
            new PhoneNumber(entity.getPhoneNumber()),
            new Email(entity.getEmail()),
            new NIT(entity.getNit()),
            entity.getHasPool(),
            entity.getHasGym()
        );

        if (!entity.isActive()) {
            hotel.deactivate();
        }

        return hotel;
    }

    public static HotelEntity toEntity(Hotel hotel) {
        HotelEntity entity = new HotelEntity();
        entity.setId(hotel.getId().value());
        entity.setName(hotel.getName());
        entity.setAddress(hotel.getAddress());
        entity.setCity(hotel.getCity());
        entity.setPhoneNumber(hotel.getPhoneNumber().value());
        entity.setEmail(hotel.getEmail().value());
        entity.setNit(hotel.getNit().value());
        entity.setHasPool(hotel.hasPool());
        entity.setHasGym(hotel.hasGym());
        entity.setActive(hotel.isActive());
        return entity;
    }
}
