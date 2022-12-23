package com.jcesarperez.aoc2022;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day01Tests {

    private final Day01 day01 = new Day01();

    @Test
    public void testSamplePart1() throws IOException {
        String input = "src/test/resources/day01_sample.txt";

        int result = day01.part1(input);

        assertEquals(24000, result);
    }

    @Test
    public void testSamplePart2() throws IOException {
        String input = "src/test/resources/day01_sample.txt";

        int result = day01.part2(input);

        assertEquals(45000, result);
    }
}
