package com.example.umc10th.domain.review.controller;

import com.example.umc10th.domain.member.converter.MemberConverter;
import com.example.umc10th.domain.member.exception.code.MemberSuccessCode;
import com.example.umc10th.domain.review.converter.ReviewConverter;
import com.example.umc10th.domain.review.dto.ReviewReqDTO;
import com.example.umc10th.domain.review.dto.ReviewResDTO;
import com.example.umc10th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc10th.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ReviewController {

    // 리뷰 작성
    @PostMapping("/reviews")
    public ApiResponse<ReviewResDTO.ReviewDTO> reviews(@RequestBody ReviewReqDTO.Review reviewReqDTO) {
        return ApiResponse.onSuccess(ReviewSuccessCode.REVIEW_WRITE_SUCCESS, ReviewConverter.toReviewDTO());
    }
}
