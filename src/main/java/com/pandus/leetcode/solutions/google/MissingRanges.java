package com.pandus.leetcode.solutions.google;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int prev = lower;
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int num : nums) {
            // range
            List<Integer> range = new ArrayList<>(2);
            if (num - prev > 0) {
                range.add(prev);
                range.add(num - 1);
                result.add(range);
            }
            prev = num + 1;
        }

        if (prev <= upper) {
            List<Integer> range = new ArrayList<>(2);
            range.add(prev);
            range.add(upper);
            result.add(range);
        }
        return result;
    }
}
