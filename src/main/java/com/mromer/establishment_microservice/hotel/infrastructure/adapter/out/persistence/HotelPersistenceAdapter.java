package com.mromer.establishment_microservice.hotel.infrastructure.adapter.out.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.mromer.establishment_microservice.hotel.application.port.in.command.FindHotelCommand;
import com.mromer.establishment_microservice.hotel.application.port.out.persistence.FindHotelsOutputPort;
import com.mromer.establishment_microservice.hotel.application.port.out.persistence.StoreHotelOutputPort;
import com.mromer.establishment_microservice.hotel.domain.Hotel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class HotelPersistenceAdapter implements StoreHotelOutputPort, FindHotelsOutputPort {

    private final HotelJpaRepository repository;

    @Override
    public Hotel save(Hotel hotel) {
        HotelEntity entity = HotelEntityMapper.toEntity(hotel);
        HotelEntity saved = repository.save(entity);
        return HotelEntityMapper.toDomain(saved);
    }

    @Override
    public Page<Hotel> findAll(FindHotelCommand command, Pageable pageable) {
        Specification<HotelEntity> spec = Specification
                .allOf(HotelSpecs.nameContains(command.name()),
                        HotelSpecs.cityEquals(command.city()),
                        HotelSpecs.hasPoolEquals(command.hasPool()),
                        HotelSpecs.hasGymEquals(command.hasGym()),
                        HotelSpecs.activeEquals(command.active()));

        Page<HotelEntity> page = repository.findAll(spec, pageable);

        return page.map(HotelEntityMapper::toDomain);
    }

    @Override
    public Optional<Hotel> findById(UUID hotelId) {
        return repository.findById(hotelId).map(HotelEntityMapper::toDomain);
    }

    @Override
    public boolean existsById(UUID hotelId) {
        return repository.existsById(hotelId);
    }
}
