package com.mromer.establishment_microservice.hotel.infrastructure.adapter.out.persistence;

import org.springframework.data.jpa.domain.Specification;

public class HotelSpecs {

    public static Specification<HotelEntity> nameContains(String name) {
        return (root, query, criteriaBuilder) -> (name == null || name.isBlank())
                ? null
                : criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("name")),
                        "%" + name.toLowerCase() + "%");
    }

    public static Specification<HotelEntity> cityEquals(String city) {
        return (root, query, criteriaBuilder) -> (city == null || city.isBlank())
                ? null
                : criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get("city")),
                        city.toLowerCase());
    }

    public static Specification<HotelEntity> hasPoolEquals(Boolean hasPool) {
        return (root, query, criteriaBuilder) -> (hasPool == null)
                ? null
                : criteriaBuilder.equal(root.get("hasPool"), hasPool);
    }

    public static Specification<HotelEntity> hasGymEquals(Boolean hasGym) {
        return (root, query, criteriaBuilder) -> (hasGym == null)
                ? null
                : criteriaBuilder.equal(root.get("hasGym"), hasGym);
    }

    public static Specification<HotelEntity> activeEquals(Boolean active) {
        return (root, query, criteriaBuilder) -> (active == null)
                ? null
                : criteriaBuilder.equal(root.get("active"), active);
    }
}
