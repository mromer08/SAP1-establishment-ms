package com.mromer.establishment_microservice.common.infrastructure.adapter.out.persistence.establishment;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EstablishmentJpaRepository extends JpaRepository<EstablishmentEntity, UUID>, JpaSpecificationExecutor<EstablishmentEntity> {
    
}
