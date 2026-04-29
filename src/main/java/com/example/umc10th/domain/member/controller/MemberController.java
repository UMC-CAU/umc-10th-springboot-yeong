package com.example.umc10th.domain.member.controller;

import com.example.umc10th.domain.member.converter.MemberConverter;
import com.example.umc10th.domain.member.dto.MemberReqDTO;
import com.example.umc10th.domain.member.dto.MemberResDTO;
import com.example.umc10th.domain.member.exception.code.MemberSuccessCode;
import com.example.umc10th.domain.member.service.MemberService;
import com.example.umc10th.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class MemberController {

    private final MemberService memberService;

    // 홈
    @GetMapping("/api/v1/members/me/home")
    public ApiResponse<MemberResDTO.HomeDTO> home(
            @RequestParam Long regionId,
            @RequestParam(required = false) String cursorEndDate,
            @RequestParam(required = false) Long cursorMissionId,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        return ApiResponse.onSuccess(MemberSuccessCode.MEMBER_HOME_SUCCESS, MemberConverter.toHomeDTO());
    }

    // 회원가입
    @PostMapping("/auth/v1/members")
    public ApiResponse<MemberResDTO.SignUpDTO> signUp(@RequestBody MemberReqDTO.SignUp signUp) {
        return ApiResponse.onSuccess(MemberSuccessCode.MEMBER_SIGNUP_SUCCESS, MemberConverter.toSignUpDTO());
    }
}
