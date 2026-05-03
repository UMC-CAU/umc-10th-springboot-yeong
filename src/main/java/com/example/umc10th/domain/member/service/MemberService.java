package com.example.umc10th.domain.member.service;

import com.example.umc10th.domain.member.converter.MemberConverter;
import com.example.umc10th.domain.member.dto.MemberReqDTO;
import com.example.umc10th.domain.member.dto.MemberResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    // 홈 화면
    public MemberResDTO.HomeDTO getHome(Long regionId, LocalDate cursorEndDate, Long cursorMissionId, Integer size) {
        // 더미 생성
        List<MemberResDTO.MissionDTO> missions = List.of(
                MemberResDTO.MissionDTO.builder()
                        .missionId(1L).name("반이학생마라탕").category("중식당").endDate("D-7").points(500)
                        .build(),
                MemberResDTO.MissionDTO.builder()
                        .missionId(2L).name("반이학생마라탕").category("중식당").endDate("D-7").points(500)
                        .build(),
                MemberResDTO.MissionDTO.builder()
                        .missionId(3L).name("반이학생마라탕").category("중식당").endDate("D-7").points(500)
                        .build()
        );

        return MemberConverter.toHomeDTO(
                1L,
                "안암동",
                999999,
                true,
                7,
                missions
        );
    }

    // 회원가입
    public MemberResDTO.SignUpDTO signUp(MemberReqDTO.SignUp signUp) {
        return MemberConverter.toSignUpDTO(1L);
    }

    // 마이페이지
    public MemberResDTO.MyPageDTO getMyPage() {
        return MemberConverter.toMyPageDTO(
                1L,
                "홍길동",
                "12345@google.com",
                "010-1234-5678",
                2500
        );
    }

}
