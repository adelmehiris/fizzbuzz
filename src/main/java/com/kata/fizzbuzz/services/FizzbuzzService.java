package com.kata.fizzbuzz.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FizzbuzzService {

    public List<String> generateFizzbuzz(int int1, int int2, int limit, String str1, String str2) {
        return IntStream.rangeClosed(1, limit)
                .mapToObj(i -> {
                    String result = (i % int1 == 0 ? str1 : "") + (i % int2 == 0 ? str2 : "");
                    return result.isEmpty() ? String.valueOf(i) : result;
                })
                .collect(Collectors.toList());
    }
}
