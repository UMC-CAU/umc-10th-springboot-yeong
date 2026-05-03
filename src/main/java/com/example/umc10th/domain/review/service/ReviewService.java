package com.example.umc10th.domain.review.service;

import com.example.umc10th.domain.review.converter.ReviewConverter;
import com.example.umc10th.domain.review.dto.ReviewReqDTO;
import com.example.umc10th.domain.review.dto.ReviewResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    // 리뷰 작성
    public ReviewResDTO.ReviewDTO getReview(ReviewReqDTO.Review reviewReq) {
        return ReviewConverter.toReviewDTO(1L);
    }
}
