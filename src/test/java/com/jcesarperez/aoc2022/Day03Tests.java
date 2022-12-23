package com.jcesarperez.aoc2022;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day03Tests {

    private final Day03 day03 = new Day03();

    @Test
    public void testSamplePart1() throws IOException {
        String input = "src/test/resources/day03_sample.txt";

        int result = day03.part1(input);

        assertEquals(157, result);
    }

    @Test
    public void testSamplePart2() throws IOException {
        String input = "src/test/resources/day03_sample.txt";

        int result = day03.part2(input);

        assertEquals(70, result);
    }
}
