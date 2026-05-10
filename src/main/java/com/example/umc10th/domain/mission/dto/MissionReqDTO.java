package com.example.umc10th.domain.mission.dto;

import com.example.umc10th.domain.mission.enums.Status;

import java.time.LocalDate;

public class MissionReqDTO {
    // 미션 성공 승인
    public record MissionSuccessConfirm(
            Status status,
            LocalDate completedAt
    ){}
}
