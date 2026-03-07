package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfBinaryStringHasAtMostOneSegmentOfOnesTest {
    private val solution = CheckIfBinaryStringHasAtMostOneSegmentOfOnes()

    @Test
    fun testExample1() {
        // Input: s = "1001", Output: false
        // Two segments of ones: "1" and "1"
        assertFalse(solution.checkOnesSegment("1001"))
    }

    @Test
    fun testExample2() {
        // Input: s = "110", Output: true
        // One segment of ones: "11"
        assertTrue(solution.checkOnesSegment("110"))
    }

    @Test
    fun testSingleOne() {
        // "1" has one segment of ones
        assertTrue(solution.checkOnesSegment("1"))
    }

    @Test
    fun testConsecutiveOnes() {
        // "111" has one segment of ones
        assertTrue(solution.checkOnesSegment("111"))
    }

    @Test
    fun testOnesFollowedByZeros() {
        // "1100" has one segment of ones at the beginning
        assertTrue(solution.checkOnesSegment("1100"))
    }

    @Test
    fun testOnesFollowedByMultipleZeros() {
        // "10000" has one segment of ones
        assertTrue(solution.checkOnesSegment("10000"))
    }

    @Test
    fun testTwoSegmentsSeparatedByOneZero() {
        // "101" has two segments of ones
        assertFalse(solution.checkOnesSegment("101"))
    }

    @Test
    fun testTwoSegmentsSeparatedByMultipleZeros() {
        // "100001" has two segments of ones
        assertFalse(solution.checkOnesSegment("100001"))
    }

    @Test
    fun testMultipleSegments() {
        // "10101" has three segments of ones
        assertFalse(solution.checkOnesSegment("10101"))
    }

    @Test
    fun testLongSingleSegment() {
        // "11110000" has one segment of ones
        assertTrue(solution.checkOnesSegment("11110000"))
    }

    @Test
    fun testLongMultipleSegments() {
        // "1100110" has two segments of ones
        assertFalse(solution.checkOnesSegment("1100110"))
    }

    @Test
    fun testStartsWithOneEndsWithOne() {
        // "10001" has two segments
        assertFalse(solution.checkOnesSegment("10001"))
    }

    @Test
    fun testConsecutiveOnesWithTrailingZeros() {
        // "1110" has one segment of ones
        assertTrue(solution.checkOnesSegment("1110"))
    }

    @Test
    fun testAlternatingPattern() {
        // "1010101" has four segments of ones
        assertFalse(solution.checkOnesSegment("1010101"))
    }
}
