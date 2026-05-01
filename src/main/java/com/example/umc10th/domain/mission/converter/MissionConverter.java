package com.example.umc10th.domain.mission.converter;

import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.enums.Success;

import java.util.Arrays;
import java.util.List;

public class MissionConverter {

    // 미션 조회
    public static MissionResDTO.MemberMissionListDTO toMemberMissionListDTO(Success status) {
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

        List<MissionResDTO.MemberMissionDTO> missions = Arrays.asList(mission1, mission2, mission3, mission4).stream()
                .filter(m->m.status()==status)
                .toList();

        return MissionResDTO.MemberMissionListDTO.builder()
                .missions(missions)
                .build();
    }
}
