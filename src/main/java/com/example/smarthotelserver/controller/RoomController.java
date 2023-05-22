package com.example.smarthotelserver.controller;

import com.example.smarthotelserver.dto.RoomDto;
import com.example.smarthotelserver.service.RoomService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    RoomService roomService;

    @PostMapping("rooms/check-in")
    public String checkIn(@RequestBody RoomDto roomDto){
        return roomService.save(roomDto);
    }

}
