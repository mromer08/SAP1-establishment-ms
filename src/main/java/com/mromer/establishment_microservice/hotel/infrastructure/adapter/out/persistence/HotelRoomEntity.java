package com.mromer.establishment_microservice.hotel.infrastructure.adapter.out.persistence;

import com.mromer.establishment_microservice.common.infrastructure.adapter.out.persistence.offering.OfferingEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hotel_rooms")
@PrimaryKeyJoinColumn(name = "id")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class HotelRoomEntity extends OfferingEntity{
    Integer capacity;
    Boolean hasTv;
}
