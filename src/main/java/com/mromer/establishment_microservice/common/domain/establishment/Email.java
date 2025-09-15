package com.mromer.establishment_microservice.common.domain.establishment;

import java.util.Objects;
import java.util.regex.Pattern;

public record Email(String value) {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public Email {
        Objects.requireNonNull(value, "El correo electronico no puede ser nulo");
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("El formato del correo electronico es invalido");
        }
    }
}
