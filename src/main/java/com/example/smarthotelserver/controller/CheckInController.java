package com.example.smarthotelserver.controller;

import com.example.smarthotelserver.dto.AdminCheckInDto;
import com.example.smarthotelserver.dto.GuestCheckInDto;
import com.example.smarthotelserver.service.CheckInService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/check-in")
public class CheckInController {

    private final CheckInService checkInService;

    @PostMapping("/admin")
    public String adminCheckIn(@RequestBody AdminCheckInDto adminCheckInDto){
        return checkInService.adminSave(adminCheckInDto);
    }

    @PostMapping("/guest")
    public String guestCheckIn(@RequestBody GuestCheckInDto guestCheckInDto){
        return checkInService.guestSave(guestCheckInDto);
    }
}
