package com.mromer.establishment_microservice.common.infrastructure.adapter.in.dto;

import java.util.List;

public record PagedResponseDTO<T>(
        List<T> data,
        long totalElements,
        int pageNumber,
        int totalPages,
        boolean isFirst,
        boolean isLast,
        boolean hasNext,
        boolean hasPrevious) {}
