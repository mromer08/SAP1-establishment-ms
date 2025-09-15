package com.mromer.establishment_microservice.hotel.infrastructure.adapter.in.rest;

import com.mromer.establishment_microservice.common.infrastructure.adapter.in.dto.PagedResponseDTO;
import com.mromer.establishment_microservice.hotel.application.exception.HotelNotFoundException;
import com.mromer.establishment_microservice.hotel.application.exception.HotelRoomNotFoundException;
import com.mromer.establishment_microservice.hotel.application.port.in.*;
import com.mromer.establishment_microservice.hotel.application.port.in.command.CreateHotelCommand;
import com.mromer.establishment_microservice.hotel.application.port.in.command.CreateHotelRoomCommand;
import com.mromer.establishment_microservice.hotel.application.port.in.command.FindHotelCommand;
import com.mromer.establishment_microservice.hotel.application.port.in.command.FindHotelRoomCommand;
import com.mromer.establishment_microservice.hotel.domain.Hotel;
import com.mromer.establishment_microservice.hotel.domain.HotelRoom;
import com.mromer.establishment_microservice.hotel.infrastructure.adapter.in.rest.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/v1/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final CreateHotelInputPort createHotelInputPort;
    private final CreateHotelRoomInputPort createHotelRoomInputPort;
    private final DeactivateHotelInputPort deactivateHotelInputPort;
    private final FindHotelInputPort findHotelInputPort;
    private final FindHotelRoomInputPort findHotelRoomInputPort;

    @PostMapping
    public ResponseEntity<HotelResponseDTO> createHotel(
            @Valid @RequestBody CreateHotelRequestDTO requestDTO) {
        CreateHotelCommand command = new CreateHotelCommand(
            requestDTO.name(),
            requestDTO.address(),
            requestDTO.city(),
            requestDTO.phoneNumber(),
            requestDTO.email(),
            requestDTO.nit(),
            requestDTO.hasPool(),
            requestDTO.hasGym()
        );
        Hotel created = createHotelInputPort.createHotel(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(HotelRestMapper.toResponseDTO(created));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivateHotel(@PathVariable UUID id) {
        deactivateHotelInputPort.deactivateHotel(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelResponseDTO> getHotel(@PathVariable UUID id) {
        Hotel hotel = findHotelInputPort.findById(id).orElseThrow(() -> new HotelNotFoundException(id.toString()));
        return ResponseEntity.ok(HotelRestMapper.toResponseDTO(hotel));
    }

    @PostMapping("/rooms")
    public ResponseEntity<HotelRoomResponseDTO> createHotelRoom(
            @Valid @RequestBody CreateHotelRoomRequestDTO requestDTO) {
        CreateHotelRoomCommand command = new CreateHotelRoomCommand(
            requestDTO.name(),
            requestDTO.description(),
            requestDTO.productionCost(),
            requestDTO.salePrice(),
            requestDTO.capacity(),
            requestDTO.hasTV(),
            requestDTO.hotelId()
        );

        HotelRoom created = createHotelRoomInputPort.createHotelRoom(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(HotelRoomRestMapper.toResponseDTO(created));
    }

    @GetMapping
    public ResponseEntity<PagedResponseDTO<HotelResponseDTO>> getAllHotels(
            @Valid FindHotelRequestDTO requestDTO,
            @PageableDefault Pageable pageable) {
        FindHotelCommand command = new FindHotelCommand(
            requestDTO.name(),
            requestDTO.city(),
            requestDTO.hasPool(),
            requestDTO.hasGym(),
            requestDTO.active()
        );
        Page<Hotel> page = findHotelInputPort.findAll(command, pageable);
        PagedResponseDTO<HotelResponseDTO> response = new PagedResponseDTO<>(
                page.getContent().stream().map(HotelRestMapper::toResponseDTO).toList(),
                page.getTotalElements(),
                page.getNumber(),
                page.getTotalPages(),
                page.isFirst(),
                page.isLast(),
                page.hasNext(),
                page.hasPrevious()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/rooms")
    public ResponseEntity<PagedResponseDTO<HotelRoomResponseDTO>> getAllHotelRooms(
            @Valid FindHotelRoomRequestDTO requestDTO,
            @PageableDefault Pageable pageable) {
        FindHotelRoomCommand command = new FindHotelRoomCommand(
            requestDTO.name(),
            requestDTO.minSalePrice(),
            requestDTO.maxSalePrice(),
            requestDTO.minCapacity(),
            requestDTO.maxCapacity(),
            requestDTO.hasTV()
        );
        Page<HotelRoom> page = findHotelRoomInputPort.findAll(command, pageable);
        PagedResponseDTO<HotelRoomResponseDTO> response = new PagedResponseDTO<>(
                page.getContent().stream().map(HotelRoomRestMapper::toResponseDTO).toList(),
                page.getTotalElements(),
                page.getNumber(),
                page.getTotalPages(),
                page.isFirst(),
                page.isLast(),
                page.hasNext(), 
                page.hasPrevious()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<HotelRoomResponseDTO> getHotelRoom(@PathVariable UUID id) {
        HotelRoom hotelRoom = findHotelRoomInputPort.findById(id).orElseThrow(() -> new HotelRoomNotFoundException(id.toString()));
        return ResponseEntity.ok(HotelRoomRestMapper.toResponseDTO(hotelRoom));
    }
    
}
