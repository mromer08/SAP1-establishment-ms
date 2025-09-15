package com.mromer.establishment_microservice.hotel.application.mapper;

import com.mromer.establishment_microservice.common.domain.establishment.Email;
import com.mromer.establishment_microservice.common.domain.establishment.EstablishmentId;
import com.mromer.establishment_microservice.common.domain.establishment.NIT;
import com.mromer.establishment_microservice.common.domain.establishment.PhoneNumber;
import com.mromer.establishment_microservice.hotel.application.port.in.command.CreateHotelCommand;
import com.mromer.establishment_microservice.hotel.domain.Hotel;

public class HotelMapper {
    private HotelMapper(){
        // Private constructor to prevent instantiation
    }

    public static Hotel toDomain(CreateHotelCommand command) {
        return new Hotel(
                EstablishmentId.generate(),
                command.name(),
                command.address(),
                command.city(),
                new PhoneNumber(command.phoneNumber()),
                new Email(command.email()),
                new NIT(command.nit()),
                command.hasPool(),
                command.hasGym()
        );
    }
}
