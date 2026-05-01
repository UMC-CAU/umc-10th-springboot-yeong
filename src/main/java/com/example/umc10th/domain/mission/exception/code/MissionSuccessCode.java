package com.example.umc10th.domain.mission.exception.code;

import com.example.umc10th.global.apiPayload.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MissionSuccessCode implements BaseSuccessCode {
    MEMBER_MISSION_LIST_SUCCESS(HttpStatus.OK, "MISSION200_1", "성공적으로 미션 리스트 화면 조회에 성공했습니다")
    ;
    private final HttpStatus status;
    private final String code;
    private final String message;
}
