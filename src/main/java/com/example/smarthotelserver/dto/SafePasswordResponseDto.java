package com.example.smarthotelserver.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SafePasswordResponseDto {
    private boolean isOpen;
}
