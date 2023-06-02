package com.example.smarthotelserver.controller.Room;

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

    @GetMapping("room/state/arduino-mega/{roomNumber}")
    public Object arduino3State(@PathVariable("roomNumber") Long roomNumber){
        return roomStateService.getArduinoMegaState(roomNumber);
    }

    @GetMapping("room/state/rfid/{roomNumber}")
    public Object rfidId(@PathVariable("roomNumber") Long roomNumber){
        return roomStateService.getRfidId(roomNumber);
    }

    @GetMapping("room/state/air-quality/{roomNumber}")
    public Object airQuality(@PathVariable("roomNumber") Long roomNumber){
        return roomStateService.getAirQuality(roomNumber);
    }

    @GetMapping("room/state/audio/{roomNumber}")
    public Object audio(@PathVariable("roomNumber") Long roomNumber){
        return roomStateService.getAudio(roomNumber);
    }
}
