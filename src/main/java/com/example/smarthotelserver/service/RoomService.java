package com.example.smarthotelserver.service;

import com.example.smarthotelserver.dto.RoomDto;
import com.example.smarthotelserver.entity.Room;
import com.example.smarthotelserver.repository.RoomRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public String save(RoomDto roomDto){

    }
}
