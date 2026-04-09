package com.example.umc10th.domain.inquiry.entity;

import com.example.umc10th.domain.inquiry.enums.Type;
import com.example.umc10th.domain.member.entity.Member;
import com.example.umc10th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "inquiry")
public class Inquiry extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false, length = 100)
    private String content;

    @Column
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Column(nullable = false)
    private Boolean state;

    @Column
    private LocalDateTime answered_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Builder
    private Inquiry(Long id, String title, String content, Type type, Boolean state, LocalDateTime answered_at, Member member) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.type = type;
        this.state = state;
        this.answered_at = answered_at;
        this.member = member;
    }
}
