package com.example.smarthotelserver.dto;

import lombok.Getter;

@Getter
public class RoomControlDto {
    private Long roomNumber;
    private boolean airPurifierPower; // 공기청정기 전원
    private boolean deskLedPower; // 협탁등 전원
    private boolean ceilingLedPower; // 천장등 전원
    private String ceilingLedColor; // 천장등 색깔
    private int audioSong; // 노래
    private boolean safeboxOpen; // 금고 개폐 여부
}
