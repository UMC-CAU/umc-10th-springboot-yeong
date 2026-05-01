package com.example.umc10th.domain.mission.dto;

import com.example.umc10th.domain.mission.enums.Success;
import lombok.Builder;

import java.util.List;

public class MissionResDTO {

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
}
