package com.example.umc10th.domain.mission.entity;

import com.example.umc10th.domain.member.entity.Member;
import com.example.umc10th.domain.mission.enums.Status;
import com.example.umc10th.domain.review.entity.Review;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member_mission")
public class MemberMission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private LocalDate started_at;

    @Column()
    private LocalDate completed_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @OneToOne(mappedBy = "memberMission")
    private Review review;

    @Builder
    private MemberMission(Member member, Mission mission, Status status, Review review) {
        this.member = member;
        this.mission = mission;
        this.status = status;
        this.started_at = LocalDate.now();
        this.completed_at = null;
        this.review = review;
    }

}
