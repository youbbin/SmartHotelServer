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
                .safeOpen(false)
                .build();
        roomRepository.save(room);

        return "Admin Check-In Completed";
    }

    public String guestSave(GuestCheckInDto guestCheckInDto){
        Optional<Room> optionalRoom = roomRepository.findById(guestCheckInDto.getRoomNumber());
        if(optionalRoom.isPresent()){
            Room room = optionalRoom.get();
            room.setSafePassword(guestCheckInDto.getSafePassword());
            room.setDeskLedPower(guestCheckInDto.isDeskLedPower());
            room.setAirPurifierPower(guestCheckInDto.isAirPurifierPower());
            room.setCeilingLedPower(guestCheckInDto.isCeilingLedPower());
            room.setCeilingLedColor(guestCheckInDto.getCeilingLedColor());
            room.setAudioSong(guestCheckInDto.getAudioSong());
            //room.setBathtubWaterReceived(guestCheckInDto.isBathtubWaterReceived());

            roomRepository.save(room);
            return "Guest Admin Check-In Completed";
        }

        else return "Room Number Not Found";

    }

}
