package com.mromer.establishment_microservice.hotel.application.port.out.persistence;

import com.mromer.establishment_microservice.hotel.domain.HotelRoom;

public interface StoreHotelRoomOutputPort {
    HotelRoom save(HotelRoom hotelRoom);
}
