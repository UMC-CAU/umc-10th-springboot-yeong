package com.example.umc10th.domain.mission.controller;

import com.example.umc10th.domain.mission.converter.MissionConverter;
import com.example.umc10th.domain.mission.dto.MissionReqDTO;
import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc10th.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MissionController {
    // 미션 조회
    @GetMapping("/members/me/missions")
    public ApiResponse<MissionResDTO.MemberMissionListDTO> missions(
            @RequestParam String status) {
        return ApiResponse.onSuccess(MissionSuccessCode.MEMBER_MISSION_LIST_SUCCESS, MissionConverter.toMemberMissionListDTO(status));
    }

    // 미션 성공 요청
    @GetMapping("/members/me/missions/{missionId}/successRequest")
    public ApiResponse<MissionResDTO.MissionSuccessRequestDTO> missionSuccessRequest(
            @PathVariable Long missionId) {
        return ApiResponse.onSuccess(MissionSuccessCode.MISSION_SUCCESS_REQUEST_SUCCESS, MissionConverter.toMissionSuccessRequestDTO(missionId));
    }

    // 미션 성공 승인
    @PatchMapping("/owner/member-missions/{memberMissionId}/confirm")
    public ApiResponse<MissionResDTO.MissionSuccessConfirmDTO> missionSuccessConfirm(
            @PathVariable Long memberMissionId,
            @RequestBody MissionReqDTO.MissionSuccessConfirm missionSuccessConfirm) {
        return ApiResponse.onSuccess(MissionSuccessCode.MISSION_SUCCESS_CONFIRM_SUCCESS, MissionConverter.toMissionSuccessConfirmDTO(memberMissionId, missionSuccessConfirm));
    }

}
