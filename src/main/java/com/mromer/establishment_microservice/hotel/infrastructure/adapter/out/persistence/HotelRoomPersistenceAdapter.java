package com.mromer.establishment_microservice.hotel.infrastructure.adapter.out.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.mromer.establishment_microservice.hotel.application.port.in.command.FindHotelRoomCommand;
import com.mromer.establishment_microservice.hotel.application.port.out.persistence.*;
import com.mromer.establishment_microservice.hotel.domain.HotelRoom;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class HotelRoomPersistenceAdapter implements StoreHotelRoomOutputPort, FindHotelRoomOutputPort {
    private final HotelRoomJpaRepository repository;

    @Override
    public Page<HotelRoom> findAll(FindHotelRoomCommand command, Pageable pageable) {
        Specification<HotelRoomEntity> spec = Specification
                .allOf(
                    HotelRoomSpecs.nameContains(command.name()),
                    HotelRoomSpecs.hasTVEquals(command.hasTV()),
                    HotelRoomSpecs.minSalePrice(command.minSalePrice()),
                    HotelRoomSpecs.maxSalePrice(command.maxSalePrice()),
                    HotelRoomSpecs.minCapacity(command.minCapacity()),
                    HotelRoomSpecs.maxCapacity(command.maxCapacity())
                );
        return repository.findAll(spec, pageable)
                .map(HotelRoomEntityMapper::toDomain);
    }

    @Override
    public Optional<HotelRoom> findById(UUID hotelRoomId) {
        return repository.findById(hotelRoomId)
                .map(HotelRoomEntityMapper::toDomain);
    }

    @Override
    public boolean existsById(UUID hotelRoomId) {
        return repository.existsById(hotelRoomId);
    }

    @Override
    public HotelRoom save(HotelRoom hotelRoom) {
        HotelRoomEntity entity = HotelRoomEntityMapper.toEntity(hotelRoom);
        HotelRoomEntity saved = repository.save(entity);
        return HotelRoomEntityMapper.toDomain(saved);
    }
}
