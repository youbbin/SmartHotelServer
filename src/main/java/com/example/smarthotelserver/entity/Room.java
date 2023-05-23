package com.example.smarthotelserver.entity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="room")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    private Long roomNumber; // ID
    private String guestName; // 투숙객 이름
    private String phoneNumber; // 투숙객 전화번호
    private String rfidId; // 객실카드키(RFID) ID
    private boolean airPurifierPower; // 공기청정기 전원
    private double gasConcentration; // 가스 농도
    private String safePassword; // 금고 비밀번호
    private boolean safeOpen; // 금고 개폐여부
    private boolean deskLedPower; // 협탁등 전원
    private boolean ceilingLedPower; // 천장등 전원
    private String ceilingLedColor; // 천장등 색깔
    private String audioSong; // 노래
    private boolean bathtubWaterReceived; // 욕조 물받음 여부


}
