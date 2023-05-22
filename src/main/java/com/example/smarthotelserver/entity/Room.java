package com.example.smarthotelserver.entity;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@RequiredArgsConstructor
public class Room {
    @Id
    private Long id; // ID
    private String guestName; // 투숙객 이름
    private String phoneNumber; // 투숙객 전화번호
    private String email; // 투숙객 이메일
    private String rfidId; // 객실카드키(RFID) ID
    private boolean airPurifierPower; // 공기청정기 전원
    private double gasConcentration; // 가스 농도
    private double safePassword; // 금고 비밀번호
    private boolean deskLedPower; // 협탁등 전원
    private boolean ceilingLedPower; // 천장등 전원
    private String celingLedColor; // 천장등 색깔
    private String audioSong; // 노래
    private boolean bathtubWaterReceived; // 욕조 물받음 여부


}
