package com.example.smarthotelserver.controller;

import com.example.smarthotelserver.dto.SafePasswordInputDto;
import com.example.smarthotelserver.service.SafeboxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SafeboxController {

    private final SafeboxService safeboxService;
    @PostMapping("room/safebox/password")
    public Object safePassword(@RequestBody SafePasswordInputDto safePasswordInputDto){
        return safeboxService.match(safePasswordInputDto);
    }


    @GetMapping("room/safebox/{roomNumber}")
    public boolean isOpen(@PathVariable("roomNumber") Long roomNumber){
        return safeboxService.isOpen(roomNumber);
    }

}
