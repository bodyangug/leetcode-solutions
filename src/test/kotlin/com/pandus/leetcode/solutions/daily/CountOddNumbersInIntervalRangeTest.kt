package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CountOddNumbersInIntervalRangeTest {
    private val solution = CountOddNumbersInIntervalRange()

    @Test
    @DisplayName("Example 1: low = 3, high = 7")
    fun testExample1() {
        val low = 3
        val high = 7
        val result = solution.countOdds(low, high)
        assertEquals(3, result, "The odd numbers between 3 and 7 are [3,5,7]")
    }

    @Test
    @DisplayName("Example 2: low = 8, high = 10")
    fun testExample2() {
        val low = 8
        val high = 10
        val result = solution.countOdds(low, high)
        assertEquals(1, result, "The odd numbers between 8 and 10 are [9]")
    }

    @Test
    @DisplayName("Single number - odd: low = 5, high = 5")
    fun testSingleOddNumber() {
        val low = 5
        val high = 5
        val result = solution.countOdds(low, high)
        assertEquals(1, result, "Single odd number should return 1")
    }

    @Test
    @DisplayName("Single number - even: low = 4, high = 4")
    fun testSingleEvenNumber() {
        val low = 4
        val high = 4
        val result = solution.countOdds(low, high)
        assertEquals(0, result, "Single even number should return 0")
    }

    @Test
    @DisplayName("Both bounds even: low = 2, high = 10")
    fun testBothBoundsEven() {
        val low = 2
        val high = 10
        val result = solution.countOdds(low, high)
        assertEquals(4, result, "The odd numbers between 2 and 10 are [3,5,7,9]")
    }

    @Test
    @DisplayName("Both bounds odd: low = 1, high = 9")
    fun testBothBoundsOdd() {
        val low = 1
        val high = 9
        val result = solution.countOdds(low, high)
        assertEquals(5, result, "The odd numbers between 1 and 9 are [1,3,5,7,9]")
    }

    @Test
    @DisplayName("Consecutive numbers - even to odd: low = 2, high = 3")
    fun testConsecutiveEvenToOdd() {
        val low = 2
        val high = 3
        val result = solution.countOdds(low, high)
        assertEquals(1, result, "The odd numbers between 2 and 3 are [3]")
    }

    @Test
    @DisplayName("Consecutive numbers - odd to even: low = 3, high = 4")
    fun testConsecutiveOddToEven() {
        val low = 3
        val high = 4
        val result = solution.countOdds(low, high)
        assertEquals(1, result, "The odd numbers between 3 and 4 are [3]")
    }

    @Test
    @DisplayName("Large range: low = 0, high = 100")
    fun testLargeRange() {
        val low = 0
        val high = 100
        val result = solution.countOdds(low, high)
        assertEquals(50, result, "The odd numbers between 0 and 100 are [1,3,5,...,99]")
    }

    @Test
    @DisplayName("Zero in range: low = 0, high = 5")
    fun testZeroInRange() {
        val low = 0
        val high = 5
        val result = solution.countOdds(low, high)
        assertEquals(3, result, "The odd numbers between 0 and 5 are [1,3,5]")
    }
}

