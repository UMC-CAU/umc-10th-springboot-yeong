package com.example.umc10th.domain.review.dto;

import java.util.List;

public class ReviewReqDTO {

    // 리뷰 작성
    public record Review(
            Long storeID,
            Integer scores,
            String contents,
            List<String> images
    ){}
}
