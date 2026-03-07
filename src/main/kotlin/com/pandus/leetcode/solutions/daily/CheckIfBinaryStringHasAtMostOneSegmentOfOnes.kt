package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones
class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    fun checkOnesSegment(s: String): Boolean {
        return !s.contains("01")
    }
}
