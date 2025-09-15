package com.mromer.establishment_microservice.hotel.application.service;

import org.springframework.transaction.annotation.Transactional;

import com.mromer.establishment_microservice.hotel.application.mapper.HotelRoomMapper;
import com.mromer.establishment_microservice.hotel.application.port.in.CreateHotelRoomInputPort;
import com.mromer.establishment_microservice.hotel.application.port.in.command.CreateHotelRoomCommand;
import com.mromer.establishment_microservice.hotel.application.port.out.persistence.StoreHotelRoomOutputPort;
import com.mromer.establishment_microservice.hotel.domain.HotelRoom;

@Transactional(rollbackFor = Exception.class)
public class CreateHotelRoomService implements CreateHotelRoomInputPort {

    private final StoreHotelRoomOutputPort storeHotelRoomOutputPort;

    public CreateHotelRoomService(StoreHotelRoomOutputPort storeHotelRoomOutputPort) {
        this.storeHotelRoomOutputPort = storeHotelRoomOutputPort;
    }

    @Override
    public HotelRoom createHotelRoom(CreateHotelRoomCommand command) {
        HotelRoom room = HotelRoomMapper.toDomain(command);
        return storeHotelRoomOutputPort.save(room);
    }
}
