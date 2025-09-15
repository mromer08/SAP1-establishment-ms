package com.mromer.establishment_microservice.hotel.infrastructure.adapter.out.persistence;

import org.springframework.data.jpa.domain.Specification;
import java.math.BigDecimal;

public class HotelRoomSpecs {

    public static Specification<HotelRoomEntity> nameContains(String name) {
        return (root, query, criteriaBuilder) -> (name == null || name.isBlank())
                ? null
                : criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("name")),
                        "%" + name.toLowerCase() + "%");
    }

    public static Specification<HotelRoomEntity> minSalePrice(BigDecimal minSalePrice) {
        return (root, query, criteriaBuilder) -> (minSalePrice == null)
                ? null
                : criteriaBuilder.greaterThanOrEqualTo(root.get("salePrice"), minSalePrice);
    }

    public static Specification<HotelRoomEntity> maxSalePrice(BigDecimal maxSalePrice) {
        return (root, query, criteriaBuilder) -> (maxSalePrice == null)
                ? null
                : criteriaBuilder.lessThanOrEqualTo(root.get("salePrice"), maxSalePrice);
    }

    public static Specification<HotelRoomEntity> minCapacity(Integer minCapacity) {
        return (root, query, criteriaBuilder) -> (minCapacity == null)
                ? null
                : criteriaBuilder.greaterThanOrEqualTo(root.get("capacity"), minCapacity);
    }

    public static Specification<HotelRoomEntity> maxCapacity(Integer maxCapacity) {
        return (root, query, criteriaBuilder) -> (maxCapacity == null)
                ? null
                : criteriaBuilder.lessThanOrEqualTo(root.get("capacity"), maxCapacity);
    }

    public static Specification<HotelRoomEntity> hasTVEquals(Boolean hasTV) {
        return (root, query, criteriaBuilder) -> (hasTV == null)
                ? null
                : criteriaBuilder.equal(root.get("hasTv"), hasTV);
    }

    public static Specification<HotelRoomEntity> activeEquals(Boolean active) {
        return (root, query, criteriaBuilder) -> (active == null)
                ? null
                : criteriaBuilder.equal(root.get("active"), active);
    }
}
