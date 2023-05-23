package com.example.smarthotelserver.service;

import com.example.smarthotelserver.dto.AdminCheckInDto;
import com.example.smarthotelserver.dto.GuestCheckInDto;
import com.example.smarthotelserver.entity.Room;
import com.example.smarthotelserver.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
                .build();
        roomRepository.save(room);

        return "Admin Check-In Completed";
    }

    public String guestSave(GuestCheckInDto guestCheckInDto){
        Room room = Room.builder()
                .roomNumber(guestCheckInDto.getRoomNumber())
                .airPurifierPower(guestCheckInDto.isAirPurifierPower())
                .gasConcentration(guestCheckInDto.getGasConcentration())
                .safePassword(guestCheckInDto.getSafePassword())
                .deskLedPower(guestCheckInDto.isDeskLedPower())
                .ceilingLedColor(guestCheckInDto.getCeilingLedColor())
                .ceilingLedPower(guestCheckInDto.isCeilingLedPower())
                .audioSong(guestCheckInDto.getAudioSong())
                .bathtubWaterReceived(guestCheckInDto.isBathtubWaterReceived())
                .safeOpen(false)
                .build();
        roomRepository.save(room);
        return "Guest Admin Check-In Completed";
    }

}
