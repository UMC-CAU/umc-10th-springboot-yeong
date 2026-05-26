package com.example.umc10th.domain.member.converter;

import com.example.umc10th.domain.member.dto.MemberResDTO;
import com.example.umc10th.domain.member.entity.Member;
import com.example.umc10th.domain.member.enums.Provider;
import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.global.security.dto.OAuthDTO;

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

    // 로그인 (토큰 응답용)
    public static MemberResDTO.LoginDTO toLoginDTO(String accessToken) {
        return MemberResDTO.LoginDTO.builder()
                .accessToken(accessToken)
                .build();
    }

    // 소셜 로그인 회원가입용 엔티티 변환
    public static Member toMember(OAuthDTO dto) {
        return Member.builder()
                .name(dto.getName())
                .email(dto.getSocialEmail())
                .socialUid(dto.getSocialUid())
                .socialType(Provider.KAKAO)
                .point(0)
                .password("")
                .address("주소 미입력")
                .build();
    }
}
