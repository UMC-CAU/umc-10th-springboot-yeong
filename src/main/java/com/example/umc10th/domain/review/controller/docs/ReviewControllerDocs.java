package com.example.umc10th.domain.review.controller.docs;

import com.example.umc10th.domain.review.dto.ReviewResDTO;
import com.example.umc10th.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@Tag(name="리뷰 조회 API")
public interface ReviewControllerDocs {

    // 리뷰 조회
    @Parameters(value = {
            @Parameter(
                    name = "storeId",
                    required = true,
                    description = """
                            리뷰 조회할 가게 ID
                            """,
                    in = ParameterIn.QUERY,
                    example = "1"
            ),
            @Parameter(
                    name = "pageSize",
                    required = true,
                    description = """
                            조회할 데이터의 개수
                            """,
                    in = ParameterIn.QUERY,
                    example = "10"
            ),
            @Parameter(
                    name = "cursor",
                    required = true,
                    description = """
                            커서 기반 페이지네이션을 위한 커서 값
                            """,
                    in = ParameterIn.QUERY,
                    example = "-1 | eyJxdWVyeSI6IjAiLCJjcmVhdGVkQXQiOlsyMDI2LDUsMzEsMTIsMTcsMzQsODk4MzcxMDAwXSwiaWQiOjR"
            ),
            @Parameter(
                    name = "query",
                    required = false,
                    description = """
                            정렬 기준 (첫 페이지 요청 시 필요, 이후는 커서에 포함되어 자동으로 처리되므로 쿼리 불 필요)
                            """,
                    in = ParameterIn.QUERY,
                    example = "createdat"
            )
    })
    ApiResponse<ReviewResDTO.Pagination<ReviewResDTO.ReviewDTO>> getReviews(@AuthenticationPrincipal Long storeId, Integer pageSize, String cursor, String query);
}
