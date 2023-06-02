package com.example.smarthotelserver.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AirQualityResponseDto {
    private boolean gasQuality;
    private double temperature;
}
