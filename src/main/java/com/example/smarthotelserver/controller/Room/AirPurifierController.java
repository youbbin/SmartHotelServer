package com.example.smarthotelserver.controller.Room;

import com.example.smarthotelserver.dto.AirPurifierDto;
import com.example.smarthotelserver.service.AirPurifierService;
import com.example.smarthotelserver.service.CheckInService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AirPurifierController {
    private final AirPurifierService airPurifierService;
    @PostMapping("/room/air-purifier")
    public Object airPurifier(@RequestBody AirPurifierDto airPurifierDto){
        return airPurifierService.updateAirPurifier(airPurifierDto);
    }
}
