package com.example.smarthotelserver.controller;

import com.example.smarthotelserver.dto.SafePasswordInputDto;
import com.example.smarthotelserver.service.SafeboxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SafeboxController {

    private final SafeboxService safeboxService;
    @PostMapping("room/safe-password")
    public Object safePassword(@RequestBody SafePasswordInputDto safePasswordInputDto){
        return safeboxService.match(safePasswordInputDto);
    }
}
