package com.example.smarthotelserver.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SafeOpenDto {
    private Long roomNumber; // 객실번호(PK)
    private boolean isOpen;
}
