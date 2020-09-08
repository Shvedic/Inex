package main.java.tasks;

import java.util.*;

public class SumTask {
    public static void main(String[] args) {
        int[] numbers = {1, 34, 7, 2, 8};
        System.out.println(sumsOfPairs(numbers));
    }

    private static HashSet<Integer> sumsOfPairs(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(Integer.sum(numbers[i], numbers[j]));
            }
        }

        return set;
    }
}
