package com.example.smarthotelserver.controller.Room;

import com.example.smarthotelserver.dto.AirQualityRequestDto;
import com.example.smarthotelserver.service.AirQualityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AirQualityController {
    private final AirQualityService airQualityService;
    @PostMapping("/room/air-quality")
    public Object airQuality(@RequestBody AirQualityRequestDto airQualityRequestDto){
        return airQualityService.updateAirQuality(airQualityRequestDto);
    }


}
