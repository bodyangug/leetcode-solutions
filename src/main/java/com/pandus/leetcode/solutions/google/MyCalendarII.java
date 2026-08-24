package com.pandus.leetcode.solutions.google;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarII {
    private List<int[]> events;
    private List<int[]> overlapsed;

    public MyCalendarII() {
        events = new ArrayList<>();
        overlapsed = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        for (int[] interval : overlapsed) {
            int s = interval[0];
            int e = interval[1];
            if (startTime < e && endTime > s) {
                return false;
            }
        }

        for (int[] interval : events) {
            int s = interval[0];
            int e = interval[1];
            if (startTime < e && endTime > s) {
                overlapsed.add(new int[]{Math.max(startTime, s), Math.min(endTime, e)});
            }
        }

        events.add(new int[]{startTime, endTime});
        return true;
    }
}
