package com.pandus.leetcode.solutions.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] interval) -> interval[0]));

        List<int[]> ans = new ArrayList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (cur[1] >= intervals[i][0]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                ans.add(cur);
                cur = intervals[i];
            }
        }
        ans.add(cur);
        return ans.toArray(new int[0][]);
    }
}
