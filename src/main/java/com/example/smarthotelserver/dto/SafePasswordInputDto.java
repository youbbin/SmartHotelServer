package com.example.smarthotelserver.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SafePasswordInputDto {
    private Long roomNumber; // 객실번호(PK)
    private String safePassword;
}
