package com.example.umc10th.domain.member.entity.mapping;

import com.example.umc10th.domain.member.entity.Member;
import com.example.umc10th.domain.member.entity.Term;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Table(name = "member_term")
public class MemberTerm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 회원
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    // 약관
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "term_id", nullable = false)
    private Term term;

    // 동의 여부
    @Column(nullable = false)
    private boolean isAgreed;

    @Builder
    private MemberTerm(Member member, Term term, boolean isAgreed) {
        this.member = member;
        this.term = term;
        this.isAgreed = isAgreed;
    }
}
