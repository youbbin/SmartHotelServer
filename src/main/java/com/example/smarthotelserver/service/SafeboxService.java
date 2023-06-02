package com.example.smarthotelserver.service;

import com.example.smarthotelserver.dto.SafeOpenDto;
import com.example.smarthotelserver.dto.SafePasswordResponseDto;
import com.example.smarthotelserver.entity.Room;
import com.example.smarthotelserver.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class SafeboxService {
    private final RoomRepository roomRepository;

    public boolean isOpen(Long roomNumber){
        Optional<Room> optionalRoom = roomRepository.findById(roomNumber);
        Room room = optionalRoom.get();
        return room.isSafeboxOpen();
    }
}
