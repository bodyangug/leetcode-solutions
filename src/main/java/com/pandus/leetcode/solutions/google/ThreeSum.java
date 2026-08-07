package com.pandus.leetcode.solutions.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int[] array = Arrays.stream(nums).sorted().toArray();
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < array.length - 1; i++) {
            int first = array[i];
            int target = -first;
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int sum = array[left] + array[right];
                if (sum == target) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(first);
                    triplet.add(array[left]);
                    triplet.add(array[right]);
                    result.add(triplet);
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
