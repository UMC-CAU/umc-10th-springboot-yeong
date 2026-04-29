package com.example.umc10th.domain.member.service;

import com.example.umc10th.domain.member.converter.MemberConverter;
import com.example.umc10th.domain.member.dto.MemberReqDTO;
import com.example.umc10th.domain.member.dto.MemberResDTO;
import com.example.umc10th.domain.member.entity.Member;
import com.example.umc10th.domain.member.enums.Gender;
import com.example.umc10th.domain.member.enums.Provider;
import com.example.umc10th.domain.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static java.time.LocalDate.now;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public String createUser(){
        Member member = Member.builder()
                .name("test")
                .gender(Gender.MALE)
                .birth(LocalDate.of(2000, 1, 1))
                .address("seoul")
                .email("test@example.com")
                .phone("010-0000-0000")
                .socialProvider(Provider.KAKAO)
                .socialId("test-social-id")
                .point(0)
                .build();
        memberRepository.save(member);
        return "OK";
    }

    @Transactional
    public String deleteUser(){
        memberRepository.deleteByName("test");
        return "OK";
    }

    // Query Parameter
    public String singleParameter(String singleParameter){
        return singleParameter;
    }

    // Request Body
    public MemberResDTO.RequestBody requestBody(MemberReqDTO.RequestBody dto){
        return MemberConverter.toRequestBody(dto.stringTest(), dto.longTest());
    }
}
