package com.example.smarthotelserver.dto;

import lombok.Getter;

@Getter
public class AdminCheckInDto {

    private Long roomNumber; // 객실번호(PK)
    private String guestName; // 투숙객 이름
    private String phoneNumber; // 투숙객 전화번호
    private String rfidId; // 객실카드키(RFID) ID
}
