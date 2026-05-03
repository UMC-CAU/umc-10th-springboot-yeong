package com.example.umc10th.domain.mission.dto;

import com.example.umc10th.domain.mission.enums.Success;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

public class MissionResDTO {

    // 미션 목록 조회
    @Builder
    public record MemberMissionListDTO(
            List<MemberMissionDTO> missions
    ) {}

    @Builder
    public record MemberMissionDTO(
            Long memberMissionId,
            Integer reward,
            Success status,
            String content
    ){}

    // 미션 성공 요청
    @Builder
    public record MissionSuccessRequestDTO(
            Long missionId
    ){}

    // 미션 성공 승인
    @Builder
    public record MissionSuccessConfirmDTO(
            Long missionId,
            LocalDate completedAt
    ){}
}
