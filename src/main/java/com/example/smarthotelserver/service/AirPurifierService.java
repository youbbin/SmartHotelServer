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

    public boolean updateAirPurifier(AirPurifierDto airPurifierDto){
        Optional<Room> optionalRoom = roomRepository.findById(airPurifierDto.getRoomNumber());

        Room room = optionalRoom.get();
        room.setGasConcentration(airPurifierDto.getGasConcentration());
        boolean currentPowerState = room.isAirPurifierPower();
        boolean requestedPowerState = airPurifierDto.isAirPurifierPower();

        log.info(String.valueOf(room.isAirPurifierPower()));
        log.info(String.valueOf(airPurifierDto.isAirPurifierPower()));

        if (currentPowerState != requestedPowerState) {
            //room.setAirPurifierPower(requestedPowerState);
            roomRepository.save(room);
            return true; // Air Purifier State change required
        }
        roomRepository.save(room);
        return false; // Air Purifier State change not required
    }

}
