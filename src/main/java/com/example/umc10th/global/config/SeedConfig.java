package com.example.umc10th.global.config;

import com.example.umc10th.domain.member.entity.Member;
import com.example.umc10th.domain.member.enums.Gender;
import com.example.umc10th.domain.member.enums.Provider;
import com.example.umc10th.domain.member.repository.MemberRepository;
import com.example.umc10th.domain.mission.entity.MemberMission;
import com.example.umc10th.domain.mission.entity.Mission;
import com.example.umc10th.domain.mission.enums.Status;
import com.example.umc10th.domain.mission.repository.MemberMissionRepository;
import com.example.umc10th.domain.mission.repository.MissionRepository;
import com.example.umc10th.domain.review.entity.Review;
import com.example.umc10th.domain.review.repository.ReviewRepository;
import com.example.umc10th.domain.store.entity.Region;
import com.example.umc10th.domain.store.entity.Store;
import com.example.umc10th.domain.store.repository.RegionRepository;
import com.example.umc10th.domain.store.repository.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Configuration
@RequiredArgsConstructor
public class SeedConfig {

    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final ReviewRepository reviewRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    @Transactional
    public CommandLineRunner seed() {
        return args -> {

            // Region
            Region region = regionRepository.save(Region.builder().name("안암동").build());

            // Store
            Store store = storeRepository.save(Store.builder().name("반이학생마라탕").region(region).build());

            // Mission
            Mission m1 = missionRepository.save(Mission.builder()
                    .content("12,000원 이상의 식사를 하세요!")
                    .reward(500)
                    .endDate(LocalDate.now().plusDays(7))
                    .store(store)
                    .build());

            Mission m2 = missionRepository.save(Mission.builder()
                    .content("12,000원 이상의 식사를 하세요!")
                    .reward(600)
                    .endDate(LocalDate.now().plusDays(10))
                    .store(store)
                    .build());

            Mission m3 = missionRepository.save(Mission.builder()
                    .content("12,000원 이상의 식사를 하세요!")
                    .reward(700)
                    .endDate(LocalDate.now().plusDays(14))
                    .store(store)
                    .build());

            Mission m4 = missionRepository.save(Mission.builder()
                    .content("12,000원 이상의 식사를 하세요!")
                    .reward(700)
                    .endDate(LocalDate.now().plusDays(21))
                    .store(store)
                    .build());

            Mission m5 = missionRepository.save(Mission.builder()
                    .content("12,000원 이상의 식사를 하세요!")
                    .reward(700)
                    .endDate(LocalDate.now().plusDays(28))
                    .store(store)
                    .build());

            Mission m6 = missionRepository.save(Mission.builder()
                    .content("12,000원 이상의 식사를 하세요!")
                    .reward(700)
                    .endDate(LocalDate.now().plusDays(35))
                    .store(store)
                    .build());

            // Member
            Member member = memberRepository.save(Member.builder()
                    .password(passwordEncoder.encode("pw"))
                    .name("더미유저")
                    .gender(Gender.MALE)
                    .birth(LocalDate.of(2000, 1, 1))
                    .address("서울")
                    .email("dummy@test.com")
                    .phone("010-0000-0000")
                    .socialProvider(Provider.LOCAL)
                    .socialId("dummy")
                    .point(5000)
                    .build());

            // Review
            Review review1 = reviewRepository.save(Review.builder().score(1).content("맛있어요").store(store).member(member).build());
            Review review2 = reviewRepository.save(Review.builder().score(2).content("맛있어요").store(store).member(member).build());
            Review review3 = reviewRepository.save(Review.builder().score(3).content("맛있어요").store(store).member(member).build());
            Review review4 = reviewRepository.save(Review.builder().score(4).content("맛있어요").store(store).member(member).build());

            // MemberMission
            memberMissionRepository.save(MemberMission.builder()
                    .member(member).mission(m1).status(Status.NONE).build());
            memberMissionRepository.save(MemberMission.builder()
                    .member(member).mission(m5).status(Status.NONE).build());
            memberMissionRepository.save(MemberMission.builder()
                    .member(member).mission(m2).status(Status.SUCCESS).build());
            memberMissionRepository.save(MemberMission.builder()
                    .member(member).mission(m3).status(Status.SUCCESS).build());
            memberMissionRepository.save(MemberMission.builder()
                    .member(member).mission(m4).status(Status.SUCCESS).build());

        };
    }
}