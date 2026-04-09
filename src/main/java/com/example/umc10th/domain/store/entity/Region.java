package com.example.umc10th.domain.store.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "region")
    private List<Store> stores = new ArrayList<>();

    @Builder
    private Region(String name, List<Store> stores) {
        this.name = name;
        this.stores = stores;
    }
}
