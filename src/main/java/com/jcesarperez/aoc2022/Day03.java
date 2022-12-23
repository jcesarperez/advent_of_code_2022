package com.jcesarperez.aoc2022;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Day03 {

    public static void main(String[] args) throws IOException {
        String input = "src/main/resources/day03_input.txt";

        Day03 day03 = new Day03();

        int resultPart1 = day03.part1(input);
        System.out.println("Day03 part1 = " + resultPart1);

        int resultPart2 = day03.part2(input);
        System.out.println("Day03 part2 = " + resultPart2);
    }

    public int part1(String input) throws IOException {
        var lines = Files.readAllLines(Paths.get(input), StandardCharsets.UTF_8);

        List<String> commons = new ArrayList<>();
        for (var line: lines) {
            String sFirst = line.substring(0, (line.length() / 2));
            String sSecond = line.substring((line.length() / 2));

            List<String> first = new ArrayList<>(List.of(sFirst.split("")));
            List<String> second = List.of(sSecond.split(""));

            first.retainAll(second);
            commons.add(first.get(0));
        }

        return commons.stream().mapToInt(this::toPriority).sum();
    }

    public int part2(String input) throws IOException {
        var lines = Files.readAllLines(Paths.get(input), StandardCharsets.UTF_8);

        List<String> commons = new ArrayList<>();
        for (int i = 0; i < lines.size(); i = i+3) {
            String elf1 = lines.get(i);
            String elf2 = lines.get(i + 1);
            String elf3 = lines.get(i + 2);

            List<String> first = new ArrayList<>(List.of(elf1.split("")));
            List<String> second = List.of(elf2.split(""));
            List<String> third = List.of(elf3.split(""));

            first.retainAll(second);
            first.retainAll(third);

            commons.add(first.get(0));
        }

        return commons.stream().mapToInt(this::toPriority).sum();
    }

    private int toPriority(String sCharacter) {
        char cCharacter = sCharacter.charAt(0);
        if (Character.isLowerCase(cCharacter)) {
            return cCharacter - 96;
        }
        if (Character.isUpperCase(cCharacter)) {
            return cCharacter -38;
        }
        throw new IllegalArgumentException(sCharacter + " is not a character");
    }

}
