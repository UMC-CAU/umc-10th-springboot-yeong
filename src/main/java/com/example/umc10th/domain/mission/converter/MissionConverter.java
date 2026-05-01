package com.example.umc10th.domain.mission.converter;

import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.enums.Success;

import java.util.Arrays;
import java.util.List;

public class MissionConverter {

    // 미션 조회
    public static MissionResDTO.MemberMissionListDTO toMemberMissionListDTO(String status) {
        MissionResDTO.MemberMissionDTO mission1 = MissionResDTO.MemberMissionDTO.builder()
                .memberMissionId(1L)
                .reward(500)
                .content("12,000원 이상의 식사를 하세요!")
                .status(Success.SUCCESS)
                .build();

        MissionResDTO.MemberMissionDTO mission2 = MissionResDTO.MemberMissionDTO.builder()
                .memberMissionId(2L)
                .reward(500)
                .content("12,000원 이상의 식사를 하세요!")
                .status(Success.SUCCESS)
                .build();

        MissionResDTO.MemberMissionDTO mission3 = MissionResDTO.MemberMissionDTO.builder()
                .memberMissionId(3L)
                .reward(500)
                .content("12,000원 이상의 식사를 하세요!")
                .status(Success.NONE)
                .build();

        MissionResDTO.MemberMissionDTO mission4 = MissionResDTO.MemberMissionDTO.builder()
                .memberMissionId(4L)
                .reward(500)
                .content("12,000원 이상의 식사를 하세요!")
                .status(Success.NONE)
                .build();

        MissionResDTO.MemberMissionDTO mission5 = MissionResDTO.MemberMissionDTO.builder()
                .memberMissionId(5L)
                .reward(500)
                .content("12,000원 이상의 식사를 하세요!")
                .status(Success.FAIL)
                .build();

        List<MissionResDTO.MemberMissionDTO> missions = Arrays.asList(mission1, mission2, mission3, mission4, mission5);

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
}
