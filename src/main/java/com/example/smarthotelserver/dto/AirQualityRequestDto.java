package com.example.smarthotelserver.dto;

import lombok.Getter;

@Getter
public class AirQualityRequestDto {
    private Long roomNumber; // 객실번호(PK)
    private double gasConcentration; // 가스 농도
    private double temperature; // 온도
}
