package com.example.umc10th.domain.review.converter;

import com.example.umc10th.domain.review.dto.ReviewResDTO;
import com.example.umc10th.domain.review.entity.Review;

public class ReviewConverter {

    // 리뷰 작성
    public static ReviewResDTO.ReviewDTO toReviewDTO(Review review) {
        return ReviewResDTO.ReviewDTO.builder()
                .reviewID(review.getId())
                .contents(review.getContent())
                .scores(review.getScore())
                .build();
    }
}
