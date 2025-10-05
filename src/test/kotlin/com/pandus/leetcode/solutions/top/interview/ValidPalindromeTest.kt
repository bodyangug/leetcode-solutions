package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidPalindromeTest {

    private val solution = ValidPalindrome()

    @Test
    fun testExample1() {
        assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.isPalindrome("race a car"))
    }

    @Test
    fun testExample3() {
        assertTrue(solution.isPalindrome(" "))
    }

    @Test
    fun testEmptyString() {
        assertTrue(solution.isPalindrome(""))
    }

    @Test
    fun testSingleCharacter() {
        assertTrue(solution.isPalindrome("a"))
        assertTrue(solution.isPalindrome("A"))
        assertTrue(solution.isPalindrome("1"))
    }

    @Test
    fun testOnlyNonAlphanumeric() {
        assertTrue(solution.isPalindrome(".,"))
        assertTrue(solution.isPalindrome("!@#$%^&*()"))
    }

    @Test
    fun testMixedCaseAlphanumeric() {
        assertTrue(solution.isPalindrome("Madam"))
        assertTrue(solution.isPalindrome("12321"))
        assertTrue(solution.isPalindrome("A1B2b1a"))
    }
}
