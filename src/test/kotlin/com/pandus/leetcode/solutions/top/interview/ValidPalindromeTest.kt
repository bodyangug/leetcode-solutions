package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidPalindromeTest {
    @Test
    fun isPalindrome_returnsTrueForValidPalindrome_positiveCase() {
        val solution = ValidPalindrome()
        assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"))
    }

    @Test
    fun isPalindrome_returnsFalseForInvalidPalindrome_negativeCase() {
        val solution = ValidPalindrome()
        assertFalse(solution.isPalindrome("race a car"))
    }
}
