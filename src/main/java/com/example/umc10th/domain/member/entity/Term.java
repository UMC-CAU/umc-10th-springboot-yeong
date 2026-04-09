package com.example.umc10th.domain.member.entity;

import com.example.umc10th.domain.member.entity.mapping.MemberTerm;
import com.example.umc10th.domain.member.enums.TermName;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "term")
public class Term {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 약관명
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TermName termName;

    @OneToMany(mappedBy = "term")
    private List<MemberTerm> memberTerms = new ArrayList<>();

    @Builder
    private Term(TermName termName) {
        this.termName = termName;
    }
}
