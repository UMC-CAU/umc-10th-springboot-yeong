package com.example.umc10th.domain.member.entity;

import com.example.umc10th.domain.inquiry.entity.Inquiry;
import com.example.umc10th.domain.member.entity.mapping.MemberFood;
import com.example.umc10th.domain.member.entity.mapping.MemberTerm;
import com.example.umc10th.domain.member.enums.Gender;
import com.example.umc10th.domain.member.enums.Provider;
import com.example.umc10th.domain.mission.entity.MemberMission;
import com.example.umc10th.domain.notification.entity.Notification;
import com.example.umc10th.domain.review.entity.Review;
import com.example.umc10th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 이름
    @Column(nullable = false, length = 50)
    private String name;

    // 성별
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    // 생년월일
    @Column(nullable = false)
    private LocalDate birth;

    // 주소
    @Column(nullable = false, length = 255)
    private String address;

    // 이메일
    @Column(nullable = false, length = 100, unique = true)
    private String email;

    // 전화번호
    @Column(nullable = false, length = 13)
    private String phone;

    // 소셜 로그인 제공자
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Provider socialProvider;

    // 소셜 로그인 ID
    @Column(nullable = false)
    private String socialId;

    // 포인트
    @Column(nullable = false)
    private int point;

    @OneToMany(mappedBy = "member")
    private List<MemberTerm> memberTerms = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberFood> memberFoods = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberMission> memberMissions = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Notification> notifications = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Inquiry> inquiries = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Review> reviews = new ArrayList<>();
}
