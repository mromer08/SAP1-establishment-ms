package com.mromer.establishment_microservice.common.infrastructure.adapter.out.persistence.offering;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "offerings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class OfferingEntity {
    
    @Id
    private UUID id;
    
    private String name;
    private String description;
    private BigDecimal productionCost;
    private BigDecimal salePrice;
    private UUID establishmentId;
    
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "establishment_id", nullable = false)
    // private EstablishmentEntity establishment;
}