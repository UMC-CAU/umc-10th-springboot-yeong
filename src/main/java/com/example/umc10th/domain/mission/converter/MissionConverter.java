package com.example.umc10th.domain.mission.converter;

import com.example.umc10th.domain.mission.dto.MissionResDTO;

import java.util.List;

import static java.time.LocalDate.now;

public class MissionConverter {

    // 미션 조회
    public static MissionResDTO.MemberMissionListDTO toMemberMissionListDTO(List<MissionResDTO.MemberMissionDTO> missions) {
        return MissionResDTO.MemberMissionListDTO.builder()
                .missions(missions)
                .build();
    }

    // 미션 성공 요청
    public static MissionResDTO.MissionSuccessRequestDTO toMissionSuccessRequestDTO(Long missionId) {
        return MissionResDTO.MissionSuccessRequestDTO.builder()
                .missionId(missionId)
                .build();
    }

    // 미션 성공 승인
    public static MissionResDTO.MissionSuccessConfirmDTO toMissionSuccessConfirmDTO(
            Long missionId
    ) {
        return MissionResDTO.MissionSuccessConfirmDTO.builder()
                .missionId(missionId)
                .completedAt(now())
                .build();
    }
}
