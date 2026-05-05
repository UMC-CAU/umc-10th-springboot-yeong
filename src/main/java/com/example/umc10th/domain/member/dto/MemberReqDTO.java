package com.example.umc10th.domain.member.dto;

import com.example.umc10th.domain.member.enums.Gender;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDTO {

    // 회원가입
    public record SignUp(
            String password,
            String name,
            Gender gender,
            LocalDate birth,
            String address,
            String email,
            String phone,
            List<Long> preferFoodIds,
            Agreements agreements

    ){}

    public record Agreements(
            Boolean ageAgree,
            Boolean serviceAgree,
            Boolean personalAgree,
            Boolean locationAgree,
            Boolean marketingAgree
    ){}
}
