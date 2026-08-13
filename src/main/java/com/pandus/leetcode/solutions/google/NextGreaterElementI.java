package com.pandus.leetcode.solutions.google;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            int c = nums2[i];
            while (!st.isEmpty() && st.peek() < c) {
                int idx = st.pop();
                map.put(idx, c);
            }
            st.push(c);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
