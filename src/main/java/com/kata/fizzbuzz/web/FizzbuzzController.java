package com.kata.fizzbuzz.web;

import com.kata.fizzbuzz.entities.FizzbuzzRequestEntity;
import com.kata.fizzbuzz.services.FizzbuzzService;
import com.kata.fizzbuzz.services.StatsService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class FizzbuzzController {

    private final FizzbuzzService fizzbuzzService;
    private final StatsService statsService;

    public FizzbuzzController(FizzbuzzService fizzbuzzService, StatsService statsService) {
        this.fizzbuzzService = fizzbuzzService;
        this.statsService = statsService;
    }

    @GetMapping("/fizzbuzz")
    public List<String> getFizzbuzz(
            @RequestParam("int1") int int1,
            @RequestParam("int2") int int2,
            @RequestParam("limit") int limit,
            @RequestParam("str1") String str1,
            @RequestParam("str2") String str2
    ) {
        statsService.recordRequest(int1, int2, limit, str1, str2);
        return fizzbuzzService.generateFizzbuzz(int1, int2, limit, str1, str2);
    }


    @GetMapping("/stats")
    public FizzbuzzRequestEntity getStats() {
        return statsService.getMostFrequentRequest();
    }
}
