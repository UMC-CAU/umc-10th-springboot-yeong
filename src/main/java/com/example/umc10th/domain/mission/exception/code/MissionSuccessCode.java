package com.example.umc10th.domain.mission.exception.code;

import com.example.umc10th.global.apiPayload.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MissionSuccessCode implements BaseSuccessCode {
    MEMBER_MISSION_LIST_SUCCESS(HttpStatus.OK, "MISSION200_1", "성공적으로 미션 리스트 화면 조회에 성공했습니다"),
    MISSION_SUCCESS_REQUEST_SUCCESS(HttpStatus.OK, "MISSION200_2", "정상적으로 미션 성공 요청을 하였습니다."),
    MISSION_SUCCESS_CONFIRM_SUCCESS(HttpStatus.OK, "MISSION200_3", "성공적으로 미션 승인을 하였습니다.")
    ;
    private final HttpStatus status;
    private final String code;
    private final String message;
}
