package com.jcesarperez.aoc2022;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01 {

    public static void main(String[] args) throws IOException {
        String input = "src/main/resources/day01_input.txt";

        Day01 day01 = new Day01();

        int resultPart1 = day01.part1(input);
        System.out.println("Day01 part1 = " + resultPart1);

        int resultPart2 = day01.part2(input);
        System.out.println("Day01 part2 = " + resultPart2);
    }

    public int part1(String inventoryPath) throws IOException {
        var lines = Files.readAllLines(Paths.get(inventoryPath), StandardCharsets.UTF_8);

        List<Integer> caloriesPerElf = getCaloriesPerElf(lines);

        return Collections.max(caloriesPerElf);
    }

    public int part2(String inventoryPath) throws IOException {
        var lines = Files.readAllLines(Paths.get(inventoryPath), StandardCharsets.UTF_8);

        List<Integer> caloriesPerElf = getCaloriesPerElf(lines);

        int max1 = 0, max2 = 0, max3 = 0;
        for (var calories: caloriesPerElf) {
            if (calories >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = calories;
            } else if (calories >= max2) {
                max3 = max2;
                max2 = calories;
            } else if (calories >= max3) {
                max3 = calories;
            }
        }

        return max3 + max2 + max1;
    }

    private List<Integer> getCaloriesPerElf(List<String> lines) {
        var caloriesPerElf = new ArrayList<Integer>();
        int calories = 0;
        for (var line: lines) {
            if (line.isBlank()) {
                caloriesPerElf.add(calories);
                calories = 0;
            } else {
                calories += Integer.parseInt(line);
            }
        }
        caloriesPerElf.add(calories);

        return caloriesPerElf;
    }
}
