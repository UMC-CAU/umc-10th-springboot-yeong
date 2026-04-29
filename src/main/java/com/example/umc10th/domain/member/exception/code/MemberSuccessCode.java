package com.example.umc10th.domain.member.exception.code;

import com.example.umc10th.global.apiPayload.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MemberSuccessCode implements BaseSuccessCode {

    MEMBER_HOME_SUCCESS(HttpStatus.OK, "MEMBER200_1", "성공적으로 홈 화면 조회에 성공했습니다"),
    MEMBER_SIGNUP_SUCCESS(HttpStatus.OK, "MEMBER200_2", "성공적으로 회원가입 했습니다")
    ;


    private final HttpStatus status;
    private final String code;
    private final String message;
}
