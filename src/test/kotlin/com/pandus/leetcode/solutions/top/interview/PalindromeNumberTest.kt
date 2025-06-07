package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PalindromeNumberTest {
    @Test
    fun isPalindrome_returnsTrueForPalindrome_positiveCase() {
        val solution = PalindromeNumber()
        assertTrue(solution.isPalindrome(121))
    }

    @Test
    fun isPalindrome_returnsFalseForNonPalindrome_negativeCase() {
        val solution = PalindromeNumber()
        assertFalse(solution.isPalindrome(123))
    }
}
