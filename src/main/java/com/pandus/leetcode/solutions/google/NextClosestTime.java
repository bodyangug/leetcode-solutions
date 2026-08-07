package com.pandus.leetcode.solutions.google;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {
    public String nextClosestTime(String time) {
        char[] charArray = time.toCharArray();
        int d0 = charArray[0] - '0';
        int d1 = charArray[1] - '0';
        int d3 = charArray[3] - '0';
        int d4 = charArray[4] - '0';

        int mins = (((d0 * 10) + d1) * 60) + ((d3 * 10) + d4);
        Set<Integer> uniqNums = new HashSet<>();
        uniqNums.add(d0);
        uniqNums.add(d1);
        uniqNums.add(d3);
        uniqNums.add(d4);

        int bestDiff = 1441;
        int best = 0;
        for (int a : uniqNums)
            for (int b : uniqNums)
                for (int c : uniqNums)
                    for (int e : uniqNums) {
                        int h = a * 10 + b;
                        int m = c * 10 + e;
                        if ((h < 24) && (m < 60)) {
                            int candidate = h * 60 + m;
                            int diff = (candidate - mins + 1439) % 1440 + 1;
                            if (diff < bestDiff) {
                                bestDiff = diff;
                                best = candidate;
                            }
                        }
                    }
        return String.format("%02d:%02d", best / 60, best % 60);
    }
}
