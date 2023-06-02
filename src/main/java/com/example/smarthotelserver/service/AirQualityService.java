package com.example.smarthotelserver.service;

import com.example.smarthotelserver.dto.AirQualityRequestDto;
import com.example.smarthotelserver.entity.Room;
import com.example.smarthotelserver.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AirQualityService {
    private final RoomRepository roomRepository;

    public Object updateAirQuality(AirQualityRequestDto airQualityRequestDto){
        Optional<Room> optionalRoom = roomRepository.findById(airQualityRequestDto.getRoomNumber());
        if(optionalRoom.isPresent()){
            Room room = optionalRoom.get();
            room.setGasConcentration(airQualityRequestDto.getGasConcentration());
            room.setTemperature(airQualityRequestDto.getTemperature());
            roomRepository.save(room);
            return room.isAirPurifierPower();
        }
        else return "Room Number Not Found";
    }

}
