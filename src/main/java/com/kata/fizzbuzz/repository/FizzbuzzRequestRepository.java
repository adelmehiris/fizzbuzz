package com.kata.fizzbuzz.repository;

import com.kata.fizzbuzz.entities.FizzbuzzRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FizzbuzzRequestRepository extends JpaRepository<FizzbuzzRequestEntity, Long> {

    Optional<FizzbuzzRequestEntity> findByInt1AndInt2AndLimAndStr1AndStr2(
            int int1, int int2, int limit, String str1, String str2
    );

    @Query("SELECT r FROM FizzbuzzRequestEntity r ORDER BY r.hits DESC")
    Optional<FizzbuzzRequestEntity> findMostFrequentRequest();
}
