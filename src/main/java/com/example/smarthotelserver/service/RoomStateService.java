package com.example.smarthotelserver.service;

import com.example.smarthotelserver.dto.ArduinoMegaDto;
import com.example.smarthotelserver.dto.RoomStateResponseDto;
import com.example.smarthotelserver.entity.Room;
import com.example.smarthotelserver.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomStateService {
    private final RoomRepository roomRepository;
    public Object getRoomState(Long roomNumber){
        Optional<Room> optionalRoom = roomRepository.findById(roomNumber);
        if(optionalRoom.isPresent()){
            Room room = optionalRoom.get();
            return RoomStateResponseDto.builder()
                    .roomNumber(room.getRoomNumber())
                    .airPurifierPower(room.isAirPurifierPower())
                    .gasConcentration(room.getGasConcentration())
                    .deskLedPower(room.isDeskLedPower())
                    .ceilingLedPower(room.isCeilingLedPower())
                    .ceilingLedColor(room.getCeilingLedColor())
                    .safePassword(room.getSafePassword())
                    .audioSong(room.getAudioSong())
                    .bathtubWaterReceived(room.isBathtubWaterReceived())
                    .temperature(room.getTemperature())
                    .build();

        }
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
                    .bathtubWaterReceived(room.isBathtubWaterReceived())
                    .temperature(room.getTemperature())
                    .gasConcentration(room.getGasConcentration())
                    .isOpen(room.isSafeOpen())
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
}
