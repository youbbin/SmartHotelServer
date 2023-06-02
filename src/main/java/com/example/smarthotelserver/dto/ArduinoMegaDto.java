package com.example.smarthotelserver.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ArduinoMegaDto {
    private boolean deskLedPower; // 협탁등 전원
    private boolean ceilingLedPower; // 천장등 전원
    private String ceilingLedColor; // 천장등 색깔
    private boolean bathtubWaterReceived; // 욕조 물받음 여부
    private double gasConcentration; // 가스 농도
    private double temperature; // 온도
    private boolean isOpen; // 금고 개폐 여부
}
