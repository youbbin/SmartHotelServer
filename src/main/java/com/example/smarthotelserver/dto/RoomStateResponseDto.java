package com.example.smarthotelserver.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoomStateResponseDto {
    private Long roomNumber; // 객실번호(PK)
    private boolean airPurifierPower; // 공기청정기 전원
    private double gasConcentration; // 가스 농도
    private String safePassword; // 금고 비밀번호
    private boolean deskLedPower; // 협탁등 전원
    private boolean ceilingLedPower; // 천장등 전원
    private String ceilingLedColor; // 천장등 색깔
    private String audioSong; // 노래
    private boolean bathtubWaterReceived; // 욕조 물받음 여부
}
