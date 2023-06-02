package com.example.smarthotelserver.dto;

import lombok.Getter;

@Getter
public class AuthenicationRequestDto {
    private Long roomNumber;
    private String phoneNumber;
}
