package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class IsSubsequenceTest {
    @Test
    fun isSubsequence_returnsTrueForValidSubsequence_positiveCase() {
        val solution = IsSubsequence()
        assertTrue(solution.isSubsequence("abc", "ahbgdc"))
    }

    @Test
    fun isSubsequence_returnsFalseForInvalidSubsequence_negativeCase() {
        val solution = IsSubsequence()
        assertFalse(solution.isSubsequence("axc", "ahbgdc"))
    }
}
