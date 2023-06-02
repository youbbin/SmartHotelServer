package com.example.smarthotelserver.service;

import com.example.smarthotelserver.dto.RoomControlDto;
import com.example.smarthotelserver.entity.Room;
import com.example.smarthotelserver.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomControlService {
    private final RoomRepository roomRepository;

    public Object roomControl(RoomControlDto roomControlDto){
        Optional<Room> optionalRoom = roomRepository.findById(roomControlDto.getRoomNumber());
        if(optionalRoom.isPresent()) {
            Room room = optionalRoom.get();
            room.setAudioSong(roomControlDto.getAudioSong());
            room.setCeilingLedColor(roomControlDto.getCeilingLedColor());
            room.setCeilingLedPower(roomControlDto.isCeilingLedPower());
            room.setDeskLedPower(roomControlDto.isDeskLedPower());
            room.setBathtubWaterReceived(roomControlDto.isBathtubWaterReceived());
            room.setAirPurifierPower(roomControlDto.isAirPurifierPower());
            room.setSafePassword(roomControlDto.getSafePassword());
            roomRepository.save(room);
            return "Control Completed";
        }
        return "Room Number Not Found";
    }
}
