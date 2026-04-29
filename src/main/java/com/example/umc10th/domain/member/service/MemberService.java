package com.example.umc10th.domain.member.service;

import com.example.umc10th.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

//    // 마이페이지
//    public MemberResDTO.GetInfo getInfo(MemberReqDTO.GetInfo dto) {
//        // DTO에서 유저 ID를 추출
//        Long memberId = dto.id();
//        // DB에서 해당 유저 ID로 데이터 조회
//        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));
//        // 컨버터를 이용해서 응답 DTO 생성 & return
//        return MemberConverter.toGetInfo(member);
//    }

//    @Transactional
//    public String createUser(){
//        Member member = Member.builder()
//                .name("test")
//                .gender(Gender.MALE)
//                .birth(LocalDate.of(2000, 1, 1))
//                .address("seoul")
//                .email("test@example.com")
//                .phone("010-0000-0000")
//                .socialProvider(Provider.KAKAO)
//                .socialId("test-social-id")
//                .point(0)
//                .build();
//        memberRepository.save(member);
//        return "OK";
//    }
//
//    @Transactional
//    public String deleteUser(){
//        memberRepository.deleteByName("test");
//        return "OK";
//    }

//    // Query Parameter
//    public String singleParameter(String singleParameter){
//        return singleParameter;
//    }
//
//    // Request Body
//    public MemberResDTO.RequestBody requestBody(MemberReqDTO.RequestBody dto){
//        return MemberConverter.toRequestBody(dto.stringTest(), dto.longTest());
//    }
}
