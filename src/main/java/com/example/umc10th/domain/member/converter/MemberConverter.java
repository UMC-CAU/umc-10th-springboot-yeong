package com.example.umc10th.domain.member.converter;

import com.example.umc10th.domain.member.dto.MemberResDTO;

import java.util.List;

public class MemberConverter {

    // 홈
    public static MemberResDTO.HomeDTO toHomeDTO() {
        MemberResDTO.MissionDTO mission1 = MemberResDTO.MissionDTO.builder()
                .missionId(1L)
                .name("반이학생마라탕")
                .category("중식당")
                .endDate("D-7")
                .points(500)
                .build();

        MemberResDTO.MissionDTO mission2 = MemberResDTO.MissionDTO.builder()
                .missionId(2L)
                .name("반이학생마라탕")
                .category("중식당")
                .endDate("D-7")
                .points(500)
                .build();

        MemberResDTO.MissionDTO mission3 = MemberResDTO.MissionDTO.builder()
                .missionId(3L)
                .name("반이학생마라탕")
                .category("중식당")
                .endDate("D-7")
                .points(500)
                .build();

        return MemberResDTO.HomeDTO.builder()
                .userId(1L)
                .location("안암동")
                .points(999999)
                .isAlarm(true)
                .completedMissionCount(7)
                .missions(List.of(mission1, mission2, mission3))
                .build();
    }

    // 회원가입
    public static MemberResDTO.SignUpDTO toSignUpDTO(){
        return MemberResDTO.SignUpDTO.builder()
                .memberId(1L)
                .createdAt(java.time.LocalDateTime.now())
                .build();
    }

    // 마이페이지
    public static MemberResDTO.MyPageDTO toMyPageDTO(){
        return MemberResDTO.MyPageDTO.builder()
                .memberId(1L)
                .name("홍길동")
                .email("12345@google.com")
                .phone("010-1234-5678")
                .points(2500)
                .build();

    }
}
