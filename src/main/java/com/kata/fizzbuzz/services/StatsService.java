package com.kata.fizzbuzz.services;

import com.kata.fizzbuzz.entities.FizzbuzzRequestEntity;
import com.kata.fizzbuzz.repository.FizzbuzzRequestRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StatsService {

    private final FizzbuzzRequestRepository repository;

    public StatsService(FizzbuzzRequestRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void recordRequest(int int1, int int2, int limit, String str1, String str2) {
        // Recherche dans la base de données ou mise à jour
        Optional<FizzbuzzRequestEntity> existingRequest = repository.findByInt1AndInt2AndLimAndStr1AndStr2(
                int1, int2, limit, str1, str2
        );

        existingRequest.ifPresentOrElse(request -> {
            request.incrementHits();
            repository.save(request);
        }, () -> {
            FizzbuzzRequestEntity newRequest = new FizzbuzzRequestEntity(int1, int2, limit, str1, str2);
            repository.save(newRequest);
        });
    }

    public FizzbuzzRequestEntity getMostFrequentRequest() {
        return repository.findMostFrequentRequest().orElse(null);
    }
}
