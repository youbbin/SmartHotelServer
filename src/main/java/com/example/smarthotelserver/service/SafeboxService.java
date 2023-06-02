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

    public Object open(SafeOpenDto safeOpenDto) {
        Optional<Room> optionalRoom = roomRepository.findById(safeOpenDto.getRoomNumber());
        if (optionalRoom.isPresent()) {
            Room room = optionalRoom.get();

            room.setSafeOpen(safeOpenDto.isOpen()); // 금고 열림
            roomRepository.save(room);
            return SafePasswordResponseDto.builder()
                    .isOpen(true)
                    .build();// 비밀번호 일치
        }
        else return "Room Number Not Found";
    }

    public boolean isOpen(Long roomNumber){
        Optional<Room> optionalRoom = roomRepository.findById(roomNumber);
        Room room = optionalRoom.get();
        return room.isSafeOpen();
    }
}
