package com.example.umc10th.domain.member.converter;

import com.example.umc10th.domain.member.dto.MemberResDTO;
import com.example.umc10th.domain.member.entity.Member;
import com.example.umc10th.domain.mission.dto.MissionResDTO;

import java.util.List;

public class MemberConverter {

    // 홈
    public static MemberResDTO.HomeDTO toHomeDTO(
            String location,
            Integer points,
            Boolean isAlarm,
            Integer completedMissionCount,
            List<MissionResDTO.MissionDTO> missions,
            Boolean hasNext,
            MemberResDTO.NextCursor nextCursor
    ) {
        return MemberResDTO.HomeDTO.builder()
                .location(location)
                .points(points)
                .isAlarm(isAlarm)
                .completedMissionCount(completedMissionCount)
                .missions(missions)
                .hasNext(hasNext)
                .nextCursor(nextCursor)
                .build();
    }

    // 회원가입
    public static MemberResDTO.SignUpDTO toSignUpDTO(Long memberId){
        return MemberResDTO.SignUpDTO.builder()
                .memberId(memberId)
                .createdAt(java.time.LocalDateTime.now())
                .build();
    }

    // 마이페이지
    public static MemberResDTO.MyPageDTO toMyPageDTO(
            Member member
    ){
        return MemberResDTO.MyPageDTO.builder()
                .memberId(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .phone(member.getPhone())
                .points(member.getPoint())
                .build();

    }
}
