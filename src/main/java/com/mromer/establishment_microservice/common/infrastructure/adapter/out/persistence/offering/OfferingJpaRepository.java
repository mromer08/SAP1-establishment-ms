package com.mromer.establishment_microservice.common.infrastructure.adapter.out.persistence.offering;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OfferingJpaRepository extends JpaRepository<OfferingEntity, UUID>, JpaSpecificationExecutor<OfferingEntity> {
    
}
