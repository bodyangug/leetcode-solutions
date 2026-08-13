package com.pandus.leetcode.solutions.google;

import java.util.ArrayDeque;
import java.util.Arrays;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums.length * 2 - 1; i++) {
            int c = nums[i % nums.length];
            while (!st.isEmpty() && nums[st.peek() % nums.length] < c) {
                int idx = st.pop();
                ans[idx] = c;
            }
            st.push(i % nums.length);
        }
        return ans;
    }
}
