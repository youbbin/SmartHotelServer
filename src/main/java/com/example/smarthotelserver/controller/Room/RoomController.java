package com.example.smarthotelserver.controller.Room;

import com.example.smarthotelserver.dto.RoomControlDto;
import com.example.smarthotelserver.service.RoomControlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RoomController {
    private final RoomControlService roomControlService;
    @PostMapping("room/control")
    public Object roomControl(RoomControlDto roomControlDto){
        return roomControlService.roomControl(roomControlDto);
    }
}
