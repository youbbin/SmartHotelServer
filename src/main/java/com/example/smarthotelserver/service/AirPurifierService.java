package com.example.smarthotelserver.service;

import com.example.smarthotelserver.dto.AirPurifierDto;
import com.example.smarthotelserver.entity.Room;
import com.example.smarthotelserver.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AirPurifierService {
    private final RoomRepository roomRepository;

    public Object updateAirPurifier(AirPurifierDto airPurifierDto){
        Optional<Room> optionalRoom = roomRepository.findById(airPurifierDto.getRoomNumber());
        if(optionalRoom.isPresent()){
            Room room = optionalRoom.get();
            room.setGasConcentration(airPurifierDto.getGasConcentration());
            room.setTemperature(airPurifierDto.getTemperature());
            roomRepository.save(room);
            return room.isAirPurifierPower();
        }
        else return "Room Number Not Found";
    }

}
