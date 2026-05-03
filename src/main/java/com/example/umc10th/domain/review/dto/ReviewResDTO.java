package com.example.umc10th.domain.review.dto;

import lombok.Builder;

import java.time.LocalDate;

public class ReviewResDTO {

    @Builder
    public record ReviewDTO(
            Long reviewID,
            LocalDate createdAt
    ){}
}
