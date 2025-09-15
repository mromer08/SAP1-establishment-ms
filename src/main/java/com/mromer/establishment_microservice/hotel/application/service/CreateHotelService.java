package com.mromer.establishment_microservice.hotel.application.service;

import org.springframework.transaction.annotation.Transactional;

import com.mromer.establishment_microservice.hotel.application.mapper.HotelMapper;
import com.mromer.establishment_microservice.hotel.application.port.in.CreateHotelInputPort;
import com.mromer.establishment_microservice.hotel.application.port.in.command.CreateHotelCommand;
import com.mromer.establishment_microservice.hotel.application.port.out.persistence.StoreHotelOutputPort;
import com.mromer.establishment_microservice.hotel.domain.Hotel;

@Transactional(rollbackFor = Exception.class)
public class CreateHotelService implements CreateHotelInputPort {
    
    private final StoreHotelOutputPort storeHotelOutputPort;

    public CreateHotelService(StoreHotelOutputPort storeHotelOutputPort) {
        this.storeHotelOutputPort = storeHotelOutputPort;
    }

    @Override
    public Hotel createHotel(CreateHotelCommand command) {
        Hotel hotel = HotelMapper.toDomain(command);
        return storeHotelOutputPort.save(hotel);
    }
    
}
