package com.example.smarthotelserver.controller.Room;

import com.example.smarthotelserver.service.RoomStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AudioSongController {
    private final RoomStateService roomStateService;
    @GetMapping("room/audio/{roomNumber}")
    public Object audio(@PathVariable("roomNumber") Long roomNumber){
        return roomStateService.getAudio(roomNumber);
    }
}
