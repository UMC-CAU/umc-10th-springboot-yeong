package com.example.umc10th.domain.mission.dto;

import com.example.umc10th.domain.mission.enums.Success;

import java.time.LocalDate;

public class MissionReqDTO {
    // 미션 성공 승인
    public record MissionSuccessConfirm(
            Success status,
            LocalDate completedAt
    ){}
}
