package com.example.smarthotelserver.service;

import com.example.smarthotelserver.dto.SafePasswordInputDto;
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

    public Object match(SafePasswordInputDto safePasswordInputDto){
        Optional<Room> optionalRoom = roomRepository.findById(safePasswordInputDto.getRoomNumber());
        Room room = optionalRoom.get();
        if(safePasswordInputDto.getSafePassword() != room.getSafePassword()){
            return SafePasswordResponseDto.builder()
                    .isCorrect(false)
                    .build();// 비밀번호 불일치
        }
        room.setSafeOpen(true); // 금고 열림
        return SafePasswordResponseDto.builder()
                .isCorrect(true)
                .build();// 비밀번호 일치
    }
}
