package com.kata.fizzbuzz.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class FizzbuzzServiceTest {

    private final FizzbuzzService fizzbuzzService = new FizzbuzzService();

    @Test
    public void testGenerateFizzbuzz() {
        List<String> result = fizzbuzzService.generateFizzbuzz(3, 5, 15, "fizz", "buzz");

        List<String> expected = List.of(
                "1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz",
                "11", "fizz", "13", "14", "fizzbuzz"
        );

        assertEquals(expected, result);
    }
}
