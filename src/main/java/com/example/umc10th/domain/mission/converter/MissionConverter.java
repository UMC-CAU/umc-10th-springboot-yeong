package com.example.umc10th.domain.mission.converter;

import com.example.umc10th.domain.mission.dto.MissionReqDTO;
import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.entity.Mission;
import com.example.umc10th.domain.mission.enums.Success;

import java.util.Arrays;
import java.util.List;

public class MissionConverter {

    // 더미 데이터 생성
    private static List<MissionResDTO.MemberMissionDTO> dummy() {
        return List.of(
                MissionResDTO.MemberMissionDTO.builder()
                        .memberMissionId(1L)
                        .reward(500)
                        .content("12,000원 이상의 식사를 하세요!")
                        .status(Success.SUCCESS)
                        .build(),

                MissionResDTO.MemberMissionDTO.builder()
                        .memberMissionId(2L)
                        .reward(500)
                        .content("12,000원 이상의 식사를 하세요!")
                        .status(Success.SUCCESS)
                        .build(),

                MissionResDTO.MemberMissionDTO.builder()
                        .memberMissionId(3L)
                        .reward(500)
                        .content("12,000원 이상의 식사를 하세요!")
                        .status(Success.NONE)
                        .build(),

                MissionResDTO.MemberMissionDTO.builder()
                        .memberMissionId(4L)
                        .reward(500)
                        .content("12,000원 이상의 식사를 하세요!")
                        .status(Success.NONE)
                        .build(),

                MissionResDTO.MemberMissionDTO.builder()
                        .memberMissionId(5L)
                        .reward(500)
                        .content("12,000원 이상의 식사를 하세요!")
                        .status(Success.FAIL)
                        .build()
                );
    }

    // 미션 조회
    public static MissionResDTO.MemberMissionListDTO toMemberMissionListDTO(String status) {


        List<MissionResDTO.MemberMissionDTO> missions = dummy();

        List<MissionResDTO.MemberMissionDTO> filtered = switch (status) {
            case "ONGOING" -> missions.stream()
                    .filter(m -> m.status() == Success.NONE)
                    .toList();
            case "COMPLETED" -> missions.stream()
                    .filter(m -> m.status() == Success.SUCCESS)
                    .toList();
            case "FAILED" -> missions.stream()
                    .filter(m -> m.status() == Success.FAIL)
                    .toList();
            default -> throw new IllegalArgumentException("Unknown status: " + status);
        };


        return MissionResDTO.MemberMissionListDTO.builder()
                .missions(filtered)
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
            Long memberMissionId,
            MissionReqDTO.MissionSuccessConfirm req
    ) {
        MissionResDTO.MemberMissionDTO target = dummy().stream()
                .filter(m->m.memberMissionId().equals(memberMissionId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 memberMissionId를 못찾음 : " + memberMissionId));

        return MissionResDTO.MissionSuccessConfirmDTO.builder()
                .missionId(memberMissionId)
                .completedAt(req.completedAt())
                .build();
    }
}
