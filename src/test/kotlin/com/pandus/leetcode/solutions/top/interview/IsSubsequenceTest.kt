package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class IsSubsequenceTest {

    private val solution = IsSubsequence()

    @Test
    fun testExample1() {
        assertTrue(solution.isSubsequence("abc", "aebdc"))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.isSubsequence("axc", "ahbgdc"))
    }

    @Test
    fun testEmptySubsequence() {
        assertTrue(solution.isSubsequence("", "abc"))
        assertTrue(solution.isSubsequence("", ""))
    }

    @Test
    fun testEmptyTarget() {
        assertFalse(solution.isSubsequence("a", ""))
    }

    @Test
    fun testSameString() {
        assertTrue(solution.isSubsequence("abc", "abc"))
    }

    @Test
    fun testSingleCharacter() {
        assertTrue(solution.isSubsequence("a", "a"))
        assertTrue(solution.isSubsequence("a", "ba"))
        assertFalse(solution.isSubsequence("a", "b"))
    }

    @Test
    fun testLongerSubsequence() {
        assertFalse(solution.isSubsequence("abc", "ab"))
    }
}
