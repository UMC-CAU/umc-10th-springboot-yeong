package com.example.umc10th.domain.mission.service;

import com.example.umc10th.domain.mission.converter.MissionConverter;
import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.enums.Success;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {

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
    public MissionResDTO.MemberMissionListDTO getMissionList(String status) {
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

        return MissionConverter.toMemberMissionListDTO(filtered);
    }

    // 미션 성공 요청
    public MissionResDTO.MissionSuccessRequestDTO getMissionSuccessRequest(Long missionId) {
        return MissionConverter.toMissionSuccessRequestDTO(missionId);
    }

    // 미션 성공 승인
    public MissionResDTO.MissionSuccessConfirmDTO getMissionSuccessConfirm(Long missionId) {
        MissionResDTO.MemberMissionDTO target = dummy().stream()
                .filter(m->m.memberMissionId().equals(missionId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 memberMissionId를 못찾음 : " + missionId));

        if (target.status()!=Success.NONE) {throw new IllegalArgumentException("이미 처리된 미션");}

        return MissionConverter.toMissionSuccessConfirmDTO(missionId);
    }
}
