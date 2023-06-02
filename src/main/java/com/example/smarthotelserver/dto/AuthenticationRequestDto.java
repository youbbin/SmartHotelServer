package com.example.smarthotelserver.dto;

import lombok.Getter;

@Getter
public class AuthenticationRequestDto {
    private Long roomNumber;
    private String phoneNumber;
}
