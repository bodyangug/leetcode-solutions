package com.pandus.leetcode.solutions.google;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int bestLeft = 0;
        int bestRight = 1;
        int bestSize = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                right++;
                left--;
            }
            if (right - left -1 > bestSize) {
                bestLeft = left +1;
                bestRight = right;
                bestSize = right - left -1;
            }

            left = i;
            right = i +1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                right++;
                left--;
            }
            if (right - left -1 > bestSize) {
                bestLeft = left +1;
                bestRight = right;
                bestSize = right - left -1;
            }
        }
        return s.substring(bestLeft, bestRight);
    }
}
