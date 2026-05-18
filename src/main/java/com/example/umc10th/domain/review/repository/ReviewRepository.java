package com.example.umc10th.domain.review.repository;

import com.example.umc10th.domain.review.entity.Review;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    // 리뷰 조회 (커서 있는 경우)
    @Query("""
        select r
        from Review r
        join fetch r.store s
        where s.id = :storeId
            and (
                r.createdAt < :cursorCreatedAt
                or (r.createdAt = :cursorCreatedAt and r.id < :cursorReviewId)
            )
        order by r.createdAt desc, r.id desc
    """)

    Slice<Review> findByStoreIdWithCursor(
            @Param("storeId") Long storeId,
            @Param("cursorCreatedAt") LocalDateTime cursorCreatedAt,
            @Param("cursorReviewId") Long cursorReviewId,
            PageRequest pageRequest
    );

    @EntityGraph(attributePaths = {"store"})
    Slice<Review> findReviewsByStore_IdOrderByCreatedAtDescIdDesc(Long storeId, PageRequest pageRequest);
}
