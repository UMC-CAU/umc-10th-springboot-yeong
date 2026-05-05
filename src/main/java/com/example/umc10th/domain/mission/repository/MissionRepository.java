package com.example.umc10th.domain.mission.repository;

import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.entity.Mission;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MissionRepository extends JpaRepository<Mission,Long> {

    @Query("""
    select new com.example.umc10th.domain.mission.dto.MissionResDTO$MissionDTO(m.id, s.name, m.content, m.endDate, m.reward)
    from Mission m
    join m.store s
    where s.region.id = :regionId
      and m.id not in (select mm.mission.id from MemberMission mm where mm.member.id = :memberId)
      and (
              :cursorEndDate is null
              or m.endDate > :cursorEndDate
              or (m.endDate = :cursorEndDate and m.id > :cursorMissionId)
          )
    order by m.endDate asc, m.id asc
    """)

    List<MissionResDTO.MissionDTO> findMissions(
            @Param("memberId") Long memberId,
            @Param("regionId") Long regionId,
            @Param("cursorEndDate") LocalDate cursorEndDate,
            @Param("cursorMissionId") Long cursorMissionId,
            Pageable pageable
    );
}
