package com.mromer.establishment_microservice.hotel.infrastructure.config;

import com.mromer.establishment_microservice.hotel.application.port.in.*;
import com.mromer.establishment_microservice.hotel.application.service.*;
import com.mromer.establishment_microservice.hotel.application.port.out.persistence.*;
import com.mromer.establishment_microservice.hotel.infrastructure.adapter.out.persistence.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HotelBeanConfig {

    // Adapters de persistencia
    @Bean
    public StoreHotelOutputPort storeHotelOutputPort(HotelJpaRepository hotelJpaRepository) {
        return new HotelPersistenceAdapter(hotelJpaRepository);
    }

    @Bean
    public StoreHotelRoomOutputPort storeHotelRoomOutputPort(HotelRoomJpaRepository hotelRoomJpaRepository) {
        return new HotelRoomPersistenceAdapter(hotelRoomJpaRepository);
    }

    @Bean
    public FindHotelsOutputPort findHotelsOutputPort(HotelJpaRepository hotelJpaRepository) {
        return new HotelPersistenceAdapter(hotelJpaRepository);
    }

    @Bean
    public FindHotelRoomOutputPort findHotelRoomOutputPort(HotelRoomJpaRepository hotelRoomJpaRepository) {
        return new HotelRoomPersistenceAdapter(hotelRoomJpaRepository);
    }

    // Beans de servicios de aplicación (Input Ports)
    @Bean
    public CreateHotelInputPort createHotelInputPort(StoreHotelOutputPort storeHotelOutputPort) {
        return new CreateHotelService(storeHotelOutputPort);
    }

    @Bean
    public CreateHotelRoomInputPort createHotelRoomInputPort(StoreHotelRoomOutputPort storeHotelRoomOutputPort) {
        return new CreateHotelRoomService(storeHotelRoomOutputPort);
    }

    @Bean
    public DeactivateHotelInputPort deactivateHotelInputPort(FindHotelsOutputPort findHotelsOutputPort,
                                                             StoreHotelOutputPort storeHotelOutputPort) {
        return new DeactivateHotelService(findHotelsOutputPort, storeHotelOutputPort);
    }

    @Bean
    public FindHotelInputPort findHotelInputPort(FindHotelsOutputPort findHotelsOutputPort) {
        return new FindHotelService(findHotelsOutputPort);
    }

    @Bean
    public FindHotelRoomInputPort findHotelRoomInputPort(FindHotelRoomOutputPort findHotelRoomOutputPort) {
        return new FindHotelRoomService(findHotelRoomOutputPort);
    }

}