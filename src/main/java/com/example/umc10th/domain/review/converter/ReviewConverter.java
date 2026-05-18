package com.example.umc10th.domain.review.converter;

import com.example.umc10th.domain.review.dto.ReviewResDTO;
import com.example.umc10th.domain.review.entity.Review;

import java.util.List;

public class ReviewConverter {

    // 리뷰 작성, 리뷰 조회
    public static ReviewResDTO.ReviewDTO toReviewDTO(Review review) {
        return ReviewResDTO.ReviewDTO.builder()
                .reviewID(review.getId())
                .contents(review.getContent())
                .scores(review.getScore())
                .createdAt(review.getCreatedAt())
                .build();
    }

    // 페이지네이션 틀 작성
    public static <T> ReviewResDTO.Pagination<T> toPagination(
            List<T> data,
            Boolean hasNext,
            String nextCursor,
            Integer pageSize
    ){
        return ReviewResDTO.Pagination.<T>builder()
                .data(data)
                .hasNext(hasNext)
                .nextCursor(nextCursor)
                .pageSize(pageSize)
                .build();
    }
}
