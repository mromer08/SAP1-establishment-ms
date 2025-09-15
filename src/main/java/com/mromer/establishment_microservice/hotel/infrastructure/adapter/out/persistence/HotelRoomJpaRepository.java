package com.mromer.establishment_microservice.hotel.infrastructure.adapter.out.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HotelRoomJpaRepository extends JpaRepository<HotelRoomEntity, UUID>, JpaSpecificationExecutor<HotelRoomEntity> {
    
}
