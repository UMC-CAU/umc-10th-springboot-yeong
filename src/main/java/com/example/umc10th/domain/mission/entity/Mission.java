package com.example.umc10th.domain.mission.entity;

import com.example.umc10th.domain.store.entity.Store;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "mission")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String content;

    @Column(nullable = false)
    private int reward;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @OneToMany(mappedBy = "mission")
    private List<MemberMission> memberMissions = new ArrayList<>();

    @Builder
    private Mission(String content, int reward, LocalDate endDate, Store store) {
        this.content = content;
        this.reward = reward;
        this.endDate = endDate;
        this.store = store;
    }
}
