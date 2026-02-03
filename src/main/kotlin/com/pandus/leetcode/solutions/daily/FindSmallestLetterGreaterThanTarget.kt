package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-smallest-letter-greater-than-target
class FindSmallestLetterGreaterThanTarget {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var left = 0
        var right = letters.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (letters[mid] <= target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return if (left < letters.size) letters[left] else letters[0]
    }
}
