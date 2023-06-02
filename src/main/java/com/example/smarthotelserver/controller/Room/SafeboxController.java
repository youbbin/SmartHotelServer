package com.example.smarthotelserver.controller.Room;

import com.example.smarthotelserver.dto.SafeOpenDto;
import com.example.smarthotelserver.service.SafeboxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SafeboxController {

    private final SafeboxService safeboxService;
    @PostMapping("room/safebox")
    public Object safePassword(@RequestBody SafeOpenDto safeOpenDto){
        return safeboxService.open(safeOpenDto);
    }


    @GetMapping("room/safebox/{roomNumber}")
    public boolean isOpen(@PathVariable("roomNumber") Long roomNumber){
        return safeboxService.isOpen(roomNumber);
    }

}
