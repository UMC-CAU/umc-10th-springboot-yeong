package com.example.umc10th.domain.member.dto;

import com.example.umc10th.domain.mission.dto.MissionResDTO;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberResDTO {
    // 홈 화면
    @Builder
    public record HomeDTO(
            String location,
            Integer points,
            Boolean isAlarm,
            Integer completedMissionCount,
            List<MissionResDTO.MissionDTO> missions,
            Boolean hasNext,
            NextCursor nextCursor
    ){}

    @Builder
    public record NextCursor(
            LocalDate endDate,
            Long missionId
    ){}

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
