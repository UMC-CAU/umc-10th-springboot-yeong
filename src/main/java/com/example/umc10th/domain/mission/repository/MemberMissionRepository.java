package com.example.umc10th.domain.mission.repository;

import com.example.umc10th.domain.mission.entity.MemberMission;
import com.example.umc10th.domain.mission.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberMissionRepository extends JpaRepository<MemberMission,Long> {

    // Mission 엔티티를 한 번에 조인해 가져오도록 설정(N+1 문제 해결)
    @EntityGraph(attributePaths = {"mission"})
    Page<MemberMission> findByMember_IdAndStatusOrderByIdDesc(
            Long memberId,
            Status status,
            Pageable pageable
    );

    @Query("""
        select count(mm)
        from MemberMission mm
        join mm.mission m
        join m.store s
        where mm.member.id = :memberId
            and s.region.id = :regionId
            and mm.status = :status
    """)

    Integer countByMemberAndRegionAndStatus(
            @Param("memberId") Long memberId,
            @Param("regionId") Long regionId,
            @Param("status") Status status
    );
}
