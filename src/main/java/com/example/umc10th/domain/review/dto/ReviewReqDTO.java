package com.example.umc10th.domain.review.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ReviewReqDTO {

    // 리뷰 작성
    public record Review(
            @NotNull(message= "가게 ID는 필수입니다.")
            Long storeID,
            @Min(value = 0, message = "점수는 0점 이상이어야 합니다.")
            @Max(value = 5, message = "점수는 5점 이하여야 합니다.")          Integer scores,
            @NotBlank(message = "리뷰 내용은 필수입니다.")
            String contents,
            List<String> images
    ){}
}
