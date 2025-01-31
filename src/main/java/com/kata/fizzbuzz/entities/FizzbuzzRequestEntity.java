package com.kata.fizzbuzz.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fizzbuzz_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class FizzbuzzRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int int1;
    private int int2;
    private int lim;
    private String str1;
    private String str2;
    private int hits;

    public FizzbuzzRequestEntity(int int1, int int2, int limit, String str1, String str2) {
        this.int1 = int1;
        this.int2 = int2;
        this.lim = limit;
        this.str1 = str1;
        this.str2 = str2;
        this.hits = 1;
    }

    public void incrementHits() {
        this.hits++;
    }
}
