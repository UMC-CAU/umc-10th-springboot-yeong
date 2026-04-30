package com.example.umc10th.domain.mission.controller;

import com.example.umc10th.domain.mission.converter.MissionConverter;
import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.enums.Success;
import com.example.umc10th.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc10th.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members/me")
public class MissionController {
    // 미션 조회
    @GetMapping("/missions")
    public ApiResponse<MissionResDTO.MemberMissionDTO> missions(
            @RequestParam Success status
            ){
        return ApiResponse.onSuccess(MissionSuccessCode.MISSION_LIST_SUCCESS, MissionConverter.toMemberMissionDTO(status));
    }
}
