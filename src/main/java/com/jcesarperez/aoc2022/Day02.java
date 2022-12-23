package com.jcesarperez.aoc2022;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Day02 {

    private Map<String, Integer> pointsPart1 = HashMap.newHashMap(9);
    private Map<String, Integer> pointsPart2 = HashMap.newHashMap(9);
    private Map<String, String> nextMovement = HashMap.newHashMap(9);

    public static void main(String[] args) throws IOException {
        String input = "src/main/resources/day02_input.txt";

        Day02 day02 = new Day02();

        int resultPart1 = day02.part1(input);
        System.out.println("Day02 part1 = " + resultPart1);

        int resultPart2 = day02.part2(input);
        System.out.println("Day02 part2 = " + resultPart2);
    }

    public Day02() {
        pointsPart1.put("A X", 4); // 1 + 3
        pointsPart1.put("A Y", 8); // 2 + 6
        pointsPart1.put("A Z", 3); // 3 + 0
        pointsPart1.put("B X", 1); // 1 + 0
        pointsPart1.put("B Y", 5); // 2 + 3
        pointsPart1.put("B Z", 9); // 3 + 6
        pointsPart1.put("C X", 7); // 1 + 6
        pointsPart1.put("C Y", 2); // 2 + 0
        pointsPart1.put("C Z", 6); // 3 + 3

        pointsPart2.put("A A", 4); // 1 + 3
        pointsPart2.put("A B", 8); // 2 + 6
        pointsPart2.put("A C", 3); // 3 + 0
        pointsPart2.put("B A", 1); // 1 + 0
        pointsPart2.put("B B", 5); // 2 + 3
        pointsPart2.put("B C", 9); // 3 + 6
        pointsPart2.put("C A", 7); // 1 + 6
        pointsPart2.put("C B", 2); // 2 + 0
        pointsPart2.put("C C", 6); // 3 + 3

        nextMovement.put("A X", "C");
        nextMovement.put("A Y", "A");
        nextMovement.put("A Z", "B");
        nextMovement.put("B X", "A");
        nextMovement.put("B Y", "B");
        nextMovement.put("B Z", "C");
        nextMovement.put("C X", "B");
        nextMovement.put("C Y", "C");
        nextMovement.put("C Z", "A");
    }

    public int part1(String input) throws IOException {
        var lines = Files.readAllLines(Paths.get(input), StandardCharsets.UTF_8);

        return lines.stream()
                .mapToInt(l -> pointsPart1.get(l))
                .sum();
    }

    public int part2(String input) throws IOException {
        var lines = Files.readAllLines(Paths.get(input), StandardCharsets.UTF_8);

        return lines.stream()
                .mapToInt(l -> pointsPart2.get(l.substring(0, 2) + nextMovement.get(l)))
                .sum();
    }
}
