package com.pandus.leetcode.solutions.google;

public class LongestSubstringWithoutRepeatingCharacters {
    // Given a string s, find the length of the longest substring without duplicate characters.
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        char[] charArray = s.toCharArray();
        int maxLength = 0;
        int left = 0;
        int[] charIndex = new int[128]; // ASCII character set
        for (int right = 0; right < n; right++) {
            char currentChar = charArray[right];
            left = Math.max(charIndex[currentChar], left);
            maxLength = Math.max(maxLength, right - left + 1);
            charIndex[currentChar] = right + 1;
        }
        return maxLength;
    }
}
