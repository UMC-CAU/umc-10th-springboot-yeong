package com.example.umc10th.domain.member.service;

import com.example.umc10th.domain.member.converter.MemberConverter;
import com.example.umc10th.domain.member.dto.MemberReqDTO;
import com.example.umc10th.domain.member.dto.MemberResDTO;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    // Query Parameter
    public String singleParameter(String singleParameter){
        return singleParameter;
    }

    // Request Body
    public MemberResDTO.RequestBody requestBody(MemberReqDTO.RequestBody dto){
        return MemberConverter.toRequestBody(dto.stringTest(), dto.longTest());
    }
}
