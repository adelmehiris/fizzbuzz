package com.kata.fizzbuzz.services;

import com.kata.fizzbuzz.entities.FizzbuzzRequestEntity;
import com.kata.fizzbuzz.repository.FizzbuzzRequestRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StatsServiceTest {

    private final FizzbuzzRequestRepository repository = mock(FizzbuzzRequestRepository.class);
    private final StatsService statsService = new StatsService(repository);

    @Test
    public void testRecordRequest() {
        int int1 = 3, int2 = 5, limit = 15;
        String str1 = "fizz", str2 = "buzz";

        // Simulation d'une requête existante
        FizzbuzzRequestEntity existingRequest = new FizzbuzzRequestEntity(int1, int2, limit, str1, str2);
        when(repository.findByInt1AndInt2AndLimAndStr1AndStr2(int1, int2, limit, str1, str2))
                .thenReturn(Optional.of(existingRequest));

        statsService.recordRequest(int1, int2, limit, str1, str2);

        // Vérification que la requête a été mise à jour
        assertEquals(2, existingRequest.getHits());
        verify(repository, times(1)).save(existingRequest);
    }

    @Test
    public void testGetMostFrequentRequest() {
        FizzbuzzRequestEntity request = new FizzbuzzRequestEntity(3, 5, 15, "fizz", "buzz");
        request.incrementHits();

        when(repository.findMostFrequentRequest()).thenReturn(Optional.of(request));

        FizzbuzzRequestEntity result = statsService.getMostFrequentRequest();

        assertEquals(3, result.getInt1());
        assertEquals("fizz", result.getStr1());
    }
}
