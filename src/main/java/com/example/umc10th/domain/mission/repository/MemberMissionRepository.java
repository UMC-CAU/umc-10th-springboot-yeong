package com.example.umc10th.domain.mission.repository;

import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.entity.MemberMission;
import com.example.umc10th.domain.mission.enums.Status;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission,Long> {

    @Query("""
    select new com.example.umc10th.domain.mission.dto.MissionResDTO$MemberMissionDTO(mm.id, m.reward, mm.status, m.content)
    from MemberMission mm
    join mm.mission m
    where mm.member.id = :memberId
      and (:status is null or mm.status = :status)
      and (:cursor is null or mm.id > :cursor)
    order by mm.id asc
    """)

    List<MissionResDTO.MemberMissionDTO> findMissions(
            @Param("memberId") Long memberId,
            @Param("status") Status status,
            @Param("cursor") Long cursor,
            Pageable pageable
    );
}
