package com.example.umc10th.domain.member.service;

import com.example.umc10th.domain.member.converter.MemberConverter;
import com.example.umc10th.domain.member.dto.MemberReqDTO;
import com.example.umc10th.domain.member.dto.MemberResDTO;
import com.example.umc10th.domain.member.entity.Member;
import com.example.umc10th.domain.member.repository.MemberRepository;
import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.repository.MissionRepository;
import com.example.umc10th.domain.store.entity.Region;
import com.example.umc10th.domain.store.repository.RegionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final RegionRepository regionRepository;
    private final MissionRepository missionRepository;

    // 홈 화면
    public MemberResDTO.HomeDTO getHome(Long regionId, LocalDate cursorEndDate, Long cursorMissionId, Integer size) {

        Long memberId = 1L; // Seed에서 만든 더미 유저 (나중에 변경)

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("회원이 존재하지 않습니다."));

        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new RuntimeException("지역이 존재하지 않습니다."));

        int requestSize = size;
        List<MissionResDTO.MissionDTO> dtos = missionRepository.findMissions(
                memberId, regionId, cursorEndDate, cursorMissionId,
                PageRequest.of(0, requestSize + 1)
        );

        boolean hasNext = dtos.size() > requestSize;
        List<MissionResDTO.MissionDTO> missions = hasNext ? dtos.subList(0, requestSize) : dtos;

        MemberResDTO.NextCursor nextCursor = null;
        if (hasNext && !missions.isEmpty()) {
            MissionResDTO.MissionDTO last = missions.get(missions.size() - 1);
            nextCursor = MemberResDTO.NextCursor.builder()
                    .endDate(last.endDate())
                    .missionId(last.missionId())
                    .build();
        }

        return MemberConverter.toHomeDTO(
                region.getName(),
                member.getPoint(),
                true,
                7,
                missions,
                hasNext,
                nextCursor
        );
    }

    // 회원가입
    public MemberResDTO.SignUpDTO signUp(MemberReqDTO.SignUp signUp) {
        return MemberConverter.toSignUpDTO(1L);
    }

    // 마이페이지
    public MemberResDTO.MyPageDTO getMyPage() {
        Long memberId = 1L; // // Seed에서 만든 더미 유저 (나중에 변경)

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("회원이 존재하지 않습니다."));

        return MemberConverter.toMyPageDTO(
                member.getId(),
                member.getName(),
                member.getEmail(),
                member.getPhone(),
                member.getPoint()
        );
    }

}
