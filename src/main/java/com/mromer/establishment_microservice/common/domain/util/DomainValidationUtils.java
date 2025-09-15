package com.mromer.establishment_microservice.common.domain.util;

import java.math.BigDecimal;
import java.util.Objects;

public final class DomainValidationUtils {

    private DomainValidationUtils() {
        // evitar instanciación
    }

    public static String requireNotBlank(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " no puede estar en blanco");
        }
        return value.trim();
    }

    public static <T> T requireNonNull(T value, String fieldName) {
        return Objects.requireNonNull(value, fieldName + " no puede ser nulo");
    }

    public static BigDecimal validatePositive(BigDecimal value, String fieldName) {
        if (value == null || value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(fieldName + " debe ser mayor a 0");
        }
        return value;
    }
}
