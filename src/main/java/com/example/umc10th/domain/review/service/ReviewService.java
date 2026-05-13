package com.example.umc10th.domain.review.service;

import com.example.umc10th.domain.member.entity.Member;
import com.example.umc10th.domain.member.exception.MemberException;
import com.example.umc10th.domain.member.exception.code.MemberErrorCode;
import com.example.umc10th.domain.member.repository.MemberRepository;
import com.example.umc10th.domain.review.converter.ReviewConverter;
import com.example.umc10th.domain.review.dto.ReviewReqDTO;
import com.example.umc10th.domain.review.dto.ReviewResDTO;
import com.example.umc10th.domain.review.entity.Review;
import com.example.umc10th.domain.review.exception.ReviewException;
import com.example.umc10th.domain.review.exception.code.ReviewErrorCode;
import com.example.umc10th.domain.review.repository.ReviewRepository;
import com.example.umc10th.domain.store.entity.Store;
import com.example.umc10th.domain.store.exception.StoreException;
import com.example.umc10th.domain.store.exception.code.StoreErrorCode;
import com.example.umc10th.domain.store.repository.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    // 리뷰 작성
    public ReviewResDTO.ReviewDTO postReview(Long memberId, ReviewReqDTO.Review reviewReq) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()-> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));

        Store store = storeRepository.findById(reviewReq.storeID())
                .orElseThrow(()-> new StoreException(StoreErrorCode.STORE_NOT_FOUND));

        Review review = Review.builder()
                .member(member)
                .store(store)
                .content(reviewReq.contents())
                .score(reviewReq.scores())
                .build();

        reviewRepository.save(review);

        return ReviewConverter.toReviewDTO(review);
    }

    // 리뷰 조회
    public ReviewResDTO.Pagination<ReviewResDTO.ReviewDTO> getReviews(
            Long storeId,
            Integer pageSize,
            String cursor,
            String query
    ) {
        // 페이지 정보들을 PageRequest로 만들기
        PageRequest pageRequest = PageRequest.of(0, pageSize);

        Slice<Review> reviews;
        String nextCursor;

        // 커서가 있는 경우
        if (!cursor.equals("-1")){

            // 커서 분리
            String[] cursorSplit = cursor.split("\\|");
            switch (query.toLowerCase()) {
                case "createdat" -> {

                    // 커서 타입 변환
                    LocalDateTime cursorCreatedAt = LocalDateTime.parse(cursorSplit[0]);
                    Long cursorReviewId = Long.parseLong(cursorSplit[1]);

                    // 가게 내 리뷰들 조회 & where절에 커서값 기입
                    reviews = reviewRepository.findByStoreIdWithCursor(
                            storeId,
                            cursorCreatedAt,
                            cursorReviewId,
                            pageRequest
                    );
                }
                default -> throw new ReviewException(ReviewErrorCode.QUERY_INVALID);
            }
        } else {
            // 커서 없이 조회
            reviews = reviewRepository.findReviewsByStore_IdOrderByCreatedAtDescIdDesc(storeId, pageRequest);
        }

        // 다음 커서 계산
        nextCursor = reviews.getContent().getLast().getCreatedAt() + "|" + reviews.getContent().getLast().getId();

        // 리뷰들 응답 DTO로 포장하기
        return ReviewConverter.toPagination(
                reviews.map(ReviewConverter::toReviewDTO).toList(),
                reviews.hasNext(),
                nextCursor,
                reviews.getSize()
        );
    }
}
