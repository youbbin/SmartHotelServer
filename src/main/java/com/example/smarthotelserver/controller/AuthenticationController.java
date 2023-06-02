package com.example.smarthotelserver.controller;

import com.example.smarthotelserver.dto.AuthenticationRequestDto;
import com.example.smarthotelserver.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class AuthenticationController {
    private final AuthenticationService authenticationService;

    // RFID UID로 인증
//    @GetMapping("/authentication/{rfidId}")
//    public Object authenticateByRfidId(@PathVariable("rfidId") String rfidId){
//        return authenticationService.authenticateByRfidId(rfidId);
//    }

    // 룸넘버, 전화번호로 인증
    @GetMapping("/authentication")
    public Object authenticateByPhoneNumber(@RequestBody AuthenticationRequestDto authenticationRequestDto){
        return authenticationService.authenticateByPhoneNumber(authenticationRequestDto);
    }
}
