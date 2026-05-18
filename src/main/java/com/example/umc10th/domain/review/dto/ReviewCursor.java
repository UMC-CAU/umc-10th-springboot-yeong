package com.example.umc10th.domain.review.dto;

import java.time.LocalDateTime;

public record ReviewCursor(
    // 커서 DTO
    String query,
    LocalDateTime createdAt,
    Long id
) {}

