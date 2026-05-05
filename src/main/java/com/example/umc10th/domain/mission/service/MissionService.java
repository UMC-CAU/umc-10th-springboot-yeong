package com.example.umc10th.domain.mission.service;

import com.example.umc10th.domain.mission.converter.MissionConverter;
import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.enums.Status;
import com.example.umc10th.domain.mission.repository.MemberMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MemberMissionRepository memberMissionRepository;

    // 더미 데이터 생성
    private static List<MissionResDTO.MemberMissionDTO> dummy() {
        return List.of(
                MissionResDTO.MemberMissionDTO.builder()
                        .memberMissionId(1L)
                        .reward(500)
                        .content("12,000원 이상의 식사를 하세요!")
                        .status(Status.SUCCESS)
                        .build(),

                MissionResDTO.MemberMissionDTO.builder()
                        .memberMissionId(2L)
                        .reward(500)
                        .content("12,000원 이상의 식사를 하세요!")
                        .status(Status.SUCCESS)
                        .build(),
                MissionResDTO.MemberMissionDTO.builder()
                        .memberMissionId(3L)
                        .reward(500)
                        .content("12,000원 이상의 식사를 하세요!")
                        .status(Status.SUCCESS)
                        .build(),

                MissionResDTO.MemberMissionDTO.builder()
                        .memberMissionId(4L)
                        .reward(500)
                        .content("12,000원 이상의 식사를 하세요!")
                        .status(Status.NONE)
                        .build(),

                MissionResDTO.MemberMissionDTO.builder()
                        .memberMissionId(5L)
                        .reward(500)
                        .content("12,000원 이상의 식사를 하세요!")
                        .status(Status.NONE)
                        .build(),

                MissionResDTO.MemberMissionDTO.builder()
                        .memberMissionId(6L)
                        .reward(500)
                        .content("12,000원 이상의 식사를 하세요!")
                        .status(Status.FAIL)
                        .build()
        );
    }

    // 미션 조회
    public MissionResDTO.MemberMissionListDTO getMissionList(String statusStr, Long cursorMissionId, Integer size) {
        // 상태 필터
        Status status = switch (statusStr) {
            case "ONGOING" -> Status.NONE;
            case "COMPLETED" -> Status.SUCCESS;
            case "FAILED" -> Status.FAIL;
            default -> throw new IllegalArgumentException("Invalid status: " + statusStr);
        };

        Long memberId = 1L;  // Seed에서 만든 더미 유저 (나중에 변경)

        int requestSize = size;
        List<MissionResDTO.MemberMissionDTO> dtos = memberMissionRepository.findMissions(
                memberId,
                status,
                cursorMissionId, PageRequest.of(0, requestSize + 1));

        boolean hasNext = dtos.size() > requestSize;

        List<MissionResDTO.MemberMissionDTO> missions = hasNext ? dtos.subList(0, requestSize) : dtos;
        Long nextCursor = null;
        if (hasNext && !missions.isEmpty()) {
            nextCursor = missions.get(missions.size() - 1).memberMissionId();
        }

        return MissionConverter.toMemberMissionListDTO(missions, hasNext, nextCursor);
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

        if (target.status()!= Status.NONE) {throw new IllegalArgumentException("이미 처리된 미션");}

        return MissionConverter.toMissionSuccessConfirmDTO(missionId);
    }
}
