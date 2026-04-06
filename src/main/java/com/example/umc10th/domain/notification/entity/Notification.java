package com.example.umc10th.domain.notification.entity;

import com.example.umc10th.domain.notification.enums.Type;
import com.example.umc10th.domain.member.entity.Member;
import com.example.umc10th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "notification")
public class Notification extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false, length = 100)
    private String content;

    @Column()
    private LocalDateTime readTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Builder
    private Notification(Long id, Type type, Member member, String title, String content, LocalDateTime readTime) {
        this.id = id;
        this.type = type;
        this.member = member;
        this.title = title;
        this.content = content;
        this.readTime = readTime;
    }
}
