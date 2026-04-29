package com.example.umc10th.domain.member.dto;

import com.example.umc10th.domain.member.enums.Gender;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDTO {

    public record SignUp(
            String name,
            Gender gender,
            LocalDate birth,
            String address,
            String email,
            String password,
            String phone,
            List<String> preferFoodIds,
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
