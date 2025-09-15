package com.mromer.establishment_microservice.hotel.infrastructure.adapter.out.persistence;

import com.mromer.establishment_microservice.common.domain.establishment.EstablishmentId;
import com.mromer.establishment_microservice.common.domain.offering.OfferingId;
import com.mromer.establishment_microservice.hotel.domain.HotelRoom;

public class HotelRoomEntityMapper {
    
    public static HotelRoom toDomain(HotelRoomEntity entity) {
        return new HotelRoom(
            new OfferingId(entity.getId()),
            entity.getName(),
            new EstablishmentId(entity.getEstablishmentId()),
            entity.getDescription(),
            entity.getProductionCost(),
            entity.getSalePrice(),
            entity.getCapacity(),
            entity.getHasTv() != null ? entity.getHasTv() : false
        );
    }

    public static HotelRoomEntity toEntity(HotelRoom hotelRoom) {
        HotelRoomEntity entity = new HotelRoomEntity();
        entity.setId(hotelRoom.getId().value());
        entity.setName(hotelRoom.getName());
        entity.setDescription(hotelRoom.getDescription());
        entity.setProductionCost(hotelRoom.getProductionCost());
        entity.setSalePrice(hotelRoom.getSalePrice());
        entity.setEstablishmentId(hotelRoom.getEstablishmentId().value());
        // entity.setEstablishment(establishmentEntity);
        entity.setCapacity(hotelRoom.getCapacity());
        entity.setHasTv(hotelRoom.hasTV());
        return entity;
    }
}