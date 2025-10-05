package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PalindromeNumberTest {

    private val solution = PalindromeNumber()

    @Test
    fun testPositivePalindrome() {
        assertTrue(solution.isPalindrome(121))
        assertTrue(solution.isPalindrome(0))
        assertTrue(solution.isPalindrome(1))
        assertTrue(solution.isPalindrome(11))
        assertTrue(solution.isPalindrome(1221))
        assertTrue(solution.isPalindrome(12321))
    }

    @Test
    fun testNegativeNumbers() {
        assertFalse(solution.isPalindrome(-121))
        assertFalse(solution.isPalindrome(-1))
        assertFalse(solution.isPalindrome(-123))
    }

    @Test
    fun testNonPalindrome() {
        assertFalse(solution.isPalindrome(10))
        assertFalse(solution.isPalindrome(123))
        assertFalse(solution.isPalindrome(1234))
    }

    @Test
    fun testSingleDigit() {
        for (i in 0..9) {
            assertTrue(solution.isPalindrome(i))
        }
    }

    @Test
    fun testLargeNumbers() {
        assertTrue(solution.isPalindrome(1234554321))
        assertFalse(solution.isPalindrome(1234567890))
    }
}
