package com.mromer.establishment_microservice.common.infrastructure.adapter.out.persistence.establishment;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "establishments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class EstablishmentEntity {
    @Id
    private UUID id;
    private String name;
    private String address;
    private String city;
    private String phoneNumber;
    private String email;
    private String nit;
    private boolean active;
}
