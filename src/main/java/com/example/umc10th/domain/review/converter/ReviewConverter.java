package com.example.umc10th.domain.review.converter;

import com.example.umc10th.domain.review.dto.ReviewResDTO;

import static java.time.LocalDate.now;

public class ReviewConverter {

    // 리뷰 작성
    public static ReviewResDTO.ReviewDTO toReviewDTO() {
        return ReviewResDTO.ReviewDTO.builder()
                .reviewID(1L)
                .createdAt(now())
                .build();
    }
}
