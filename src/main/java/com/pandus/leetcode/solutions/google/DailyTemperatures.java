package com.pandus.leetcode.solutions.google;

import java.util.ArrayDeque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int c = temperatures[i];
            while (!st.isEmpty() && temperatures[st.peek()] < c) {
                int idx = st.pop();
                ans[idx] = i - idx;
            }
            st.push(i);
        }
        return ans;
    }
}
