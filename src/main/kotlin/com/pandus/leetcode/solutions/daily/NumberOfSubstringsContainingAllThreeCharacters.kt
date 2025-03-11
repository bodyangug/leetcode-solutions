package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters
class NumberOfSubstringsContainingAllThreeCharacters {
    fun numberOfSubstrings(s: String): Int {
        val len = s.length
        var left = 0
        var right = 0
        val freq = IntArray(3)
        var total = 0

        while (right < len) {
            freq[s[right] - 'a']++

            // Move left pointer to ensure all characters exist in the window
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                total += len - right
                freq[s[left] - 'a']--
                left++
            }
            right++
        }

        return total
    }
}
