package com.example.smarthotelserver.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
@Builder
public class AuthenticationResponseDto {
    private Long roomNumber; // 객실번호(PK)
    private String guestName; // 투숙객 이름
    private String phoneNumber; // 투숙객 전화번호
}
