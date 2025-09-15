package com.mromer.establishment_microservice.hotel.infrastructure.adapter.out.persistence;

import com.mromer.establishment_microservice.common.infrastructure.adapter.out.persistence.establishment.EstablishmentEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hotels")
@PrimaryKeyJoinColumn(name = "id")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HotelEntity extends EstablishmentEntity{

    private Boolean hasPool;
    private Boolean hasGym;
}