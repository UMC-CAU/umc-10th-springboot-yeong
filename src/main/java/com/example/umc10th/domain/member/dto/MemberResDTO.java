package com.example.umc10th.domain.member.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public class MemberResDTO {
    // 홈 화면
    @Builder
    public record HomeDTO(
            Long userId,
            String location,
            Integer points,
            Boolean isAlarm,
            Integer completedMissionCount,
            List<MissionDTO> missions
    ){}

    @Builder
    public record MissionDTO(
            Long missionId,
            String name,
            String category,
            String endDate,
            Integer points
    ) {}

    // 회원가입
    @Builder
    public record SignUpDTO(
            Long memberId,
            LocalDateTime createdAt
    ){}

    // 마이페이지
    @Builder
    public record MyPageDTO(
            Long memberId,
            String name,
            String email,
            String phone,
            Integer points
    ){}
}
