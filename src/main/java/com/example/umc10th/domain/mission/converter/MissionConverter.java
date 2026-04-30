package com.example.umc10th.domain.mission.converter;

import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.enums.Success;

public class MissionConverter {

    // 미션 조회
    public static MissionResDTO.MemberMissionDTO toMemberMissionDTO(Success status) {
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
                .status(Success.NONE)
                .build();

        return switch(status){
            case Success.SUCCESS -> mission1;
            case Success.NONE -> mission2;
            default -> throw new IllegalArgumentException();
        };
    }
}
