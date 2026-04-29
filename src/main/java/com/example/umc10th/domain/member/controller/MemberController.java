package com.example.umc10th.domain.member.controller;

import com.example.umc10th.domain.member.dto.MemberReqDTO;
import com.example.umc10th.domain.member.dto.MemberResDTO;
import com.example.umc10th.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class MemberController {

    private final MemberService memberService;

    // 아무것도 받지 않은 경우
    @GetMapping("/test")
    public String test() {
        return "test";
    }

    // Query Parameter
    @PostMapping("/query-parameter")
    public String exception(@RequestParam String queryParameter){
        return memberService.singleParameter(queryParameter);
    }

    // Request Body
    @PostMapping("/request-body")
    public MemberResDTO.RequestBody requestBody(@RequestBody MemberReqDTO.RequestBody dto){
        return memberService.requestBody(dto);
    }


    // Path Variable
    @PostMapping("/{pathVariable}")
    public String pathVariable(@PathVariable String pathVariable){
        return memberService.singleParameter(pathVariable);
    }

    // Header
    @PostMapping("/header")
    public String header(@RequestHeader("test") String test){
        return memberService.singleParameter(test);
    }
}
