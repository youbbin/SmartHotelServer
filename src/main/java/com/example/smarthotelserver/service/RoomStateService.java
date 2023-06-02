package com.example.smarthotelserver.service;

import com.example.smarthotelserver.dto.AirQualityResponseDto;
import com.example.smarthotelserver.dto.ArduinoMegaDto;
import com.example.smarthotelserver.dto.RoomStateResponseDto;
import com.example.smarthotelserver.entity.Room;
import com.example.smarthotelserver.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomStateService {
    private final RoomRepository roomRepository;
    public Object getRoomState(Long roomNumber){
        Optional<Room> optionalRoom = roomRepository.findById(roomNumber);
        if(optionalRoom.isPresent()){
            Room room = optionalRoom.get();
            log.info(roomNumber+ " GET Room State Completed");
            return RoomStateResponseDto.builder()
                    .roomNumber(room.getRoomNumber())
                    .airPurifierPower(room.isAirPurifierPower())
                    .gasConcentration(room.getGasConcentration())
                    .deskLedPower(room.isDeskLedPower())
                    .ceilingLedPower(room.isCeilingLedPower())
                    .ceilingLedColor(room.getCeilingLedColor())
                    .audioSong(room.getAudioSong())
                    .temperature(room.getTemperature())
                    .safeboxOpen(room.isSafeboxOpen())
                    .build();

        }
        log.info(roomNumber+ " GET Room State Failed");
        return "Room Number Not Found";
    }

    public Object getAudio(Long roomNumber){
        Optional<Room> optionalRoom = roomRepository.findById(roomNumber);
        if(optionalRoom.isPresent()) {
            Room room = optionalRoom.get();
            return "@"+room.getAudioSong()+"@";
        }
        return "Room Number Not Found";
    }


    public Object getArduinoMegaState(Long roomNumber){
        Optional<Room> optionalRoom = roomRepository.findById(roomNumber);
        if(optionalRoom.isPresent()) {
            Room room = optionalRoom.get();
            return ArduinoMegaDto.builder()
                    .ceilingLedPower(room.isCeilingLedPower())
                    .ceilingLedColor(room.getCeilingLedColor())
                    .deskLedPower(room.isDeskLedPower())
                    .temperature(room.getTemperature())
                    .gasConcentration(room.getGasConcentration())
                    .safeboxOpen(room.isSafeboxOpen())
                    .build();
        }
        return "Room Number Not Found";
    }

    public Object getRfidId(Long roomNumber){
        Optional<Room> optionalRoom = roomRepository.findById(roomNumber);
        if(optionalRoom.isPresent()) {
            Room room = optionalRoom.get();
            return "@"+room.getRfidId()+"@";
        }
        else return "Room Number Not Found";
    }

    public Object getAirQuality(Long roomNumber){
        boolean airQuality;
        Optional<Room> optionalRoom = roomRepository.findById(roomNumber);
        if(optionalRoom.isPresent()){
            Room room = optionalRoom.get();
            if(room.getGasConcentration()>=550){
                airQuality = false;
            }
            else airQuality = true;
            log.info(roomNumber+ " GET Air Quality Response Completed");
            return AirQualityResponseDto.builder()
                    .gasQuality(airQuality)
                    .temperature(room.getTemperature())
                    .build();
        }
        log.info(roomNumber+ " GET Air Quality Response Failed");
        return "Room Number Not Found";

    }
}
