package com.pandus.leetcode.solutions.google;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        int currentNum = n;
        while (true) {
            if (set.contains(currentNum)) return false;
            set.add(currentNum);
            int accumulator = 0;
            while (currentNum > 0) {
                int l = currentNum % 10;
                currentNum = currentNum / 10;
                accumulator += l * l;
            }

            if (accumulator == 1) return true;
            currentNum = accumulator;
        }
    }
}
