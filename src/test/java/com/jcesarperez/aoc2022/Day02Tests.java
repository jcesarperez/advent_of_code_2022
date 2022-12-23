package com.jcesarperez.aoc2022;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day02Tests {

    private final Day02 day02 = new Day02();

    @Test
    public void testSamplePart1() throws IOException {
        String input = "src/test/resources/day02_sample.txt";

        int result = day02.part1(input);

        assertEquals(15, result);
    }

    @Test
    public void testSamplePart2() throws IOException {
        String input = "src/test/resources/day02_sample.txt";

        int result = day02.part2(input);

        assertEquals(12, result);
    }

}
