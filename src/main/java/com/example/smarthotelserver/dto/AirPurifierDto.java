package com.example.smarthotelserver.dto;

import lombok.Getter;

@Getter
public class AirPurifierDto {
    private Long roomNumber; // 객실번호(PK)
    private boolean airPurifierPower; // 공기청정기 전원
    private double gasConcentration; // 가스 농도
}
