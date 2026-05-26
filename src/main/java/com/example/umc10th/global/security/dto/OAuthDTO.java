package com.example.umc10th.global.security.dto;

import com.example.umc10th.domain.member.enums.Provider;

public interface OAuthDTO {
    Provider getSocialType();
    String getSocialUid();
    String getSocialEmail();
    String getName();
}
