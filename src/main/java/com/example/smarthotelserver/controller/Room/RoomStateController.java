package com.example.smarthotelserver.controller;

import com.example.smarthotelserver.service.RoomStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RoomStateController {
    private final RoomStateService roomStateService;
    @GetMapping ("/room/state/{roomNumber}")
    public Object roomState(@PathVariable("roomNumber") Long roomNumber){
        return roomStateService.getRoomState(roomNumber);
    }
}
