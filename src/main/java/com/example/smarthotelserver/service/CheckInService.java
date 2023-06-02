package com.example.smarthotelserver.service;

import com.example.smarthotelserver.dto.AdminCheckInDto;
import com.example.smarthotelserver.dto.GuestCheckInDto;
import com.example.smarthotelserver.entity.Room;
import com.example.smarthotelserver.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CheckInService {
    private final RoomRepository roomRepository;


    public String adminSave(AdminCheckInDto adminCheckInDto){
        Room room = Room.builder()
                .roomNumber(adminCheckInDto.getRoomNumber())
                .guestName(adminCheckInDto.getGuestName())
                .phoneNumber(adminCheckInDto.getPhoneNumber())
                .rfidId(adminCheckInDto.getRfidId())
                .safeboxOpen(false)
                .deskLedPower(true)
                .ceilingLedPower(true)
                .ceilingLedColor("255,255,255")
                .gasConcentration(550)
                .temperature(0)
                .airPurifierPower(true)
                .audioSong(0)
                .build();
        roomRepository.save(room);
        log.info("Room "+adminCheckInDto.getRoomNumber()+" Admin Check-In Completed");
        return "Admin Check-In Completed";
    }

//    public String guestSave(GuestCheckInDto guestCheckInDto){
//        Optional<Room> optionalRoom = roomRepository.findById(guestCheckInDto.getRoomNumber());
//        if(optionalRoom.isPresent()){
//            Room room = optionalRoom.get();
//            room.setDeskLedPower(guestCheckInDto.isDeskLedPower());
//            room.setAirPurifierPower(guestCheckInDto.isAirPurifierPower());
//            room.setCeilingLedPower(guestCheckInDto.isCeilingLedPower());
//            room.setCeilingLedColor(guestCheckInDto.getCeilingLedColor());
//            room.setAudioSong(guestCheckInDto.getAudioSong());
//
//            roomRepository.save(room);
//            log.info("Room "+guestCheckInDto.getRoomNumber()+" Guest Check-In Completed");
//            return "Guest Check-In Completed";
//        }
//
//        else return "Room Number Not Found";
//
//    }

}
