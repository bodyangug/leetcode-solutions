package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class StoneGameIIITest {
    private val solution = StoneGameIII()

    @Test
    @DisplayName("Example 1: stoneValue = [1,2,3,7], returns Bob")
    fun testExample1() {
        val stoneValue = intArrayOf(1, 2, 3, 7)

        val result = solution.stoneGameIII(stoneValue)

        assertEquals("Bob", result, "Alice always loses; Bob ends with the higher score")
    }

    @Test
    @DisplayName("Example 2: stoneValue = [1,2,3,-9], returns Alice")
    fun testExample2() {
        val stoneValue = intArrayOf(1, 2, 3, -9)

        val result = solution.stoneGameIII(stoneValue)

        assertEquals("Alice", result, "Alice takes all three piles to leave Bob with a negative score")
    }

    @Test
    @DisplayName("Example 3: stoneValue = [1,2,3,6], returns Tie")
    fun testExample3() {
        val stoneValue = intArrayOf(1, 2, 3, 6)

        val result = solution.stoneGameIII(stoneValue)

        assertEquals("Tie", result, "Alice can only force a draw by taking the first three piles")
    }

    @Test
    @DisplayName("Single pile positive: stoneValue = [5], returns Alice")
    fun testSinglePilePositive() {
        val stoneValue = intArrayOf(5)

        val result = solution.stoneGameIII(stoneValue)

        assertEquals("Alice", result, "Alice takes the only positive pile and wins")
    }

    @Test
    @DisplayName("Single pile negative: stoneValue = [-5], returns Bob")
    fun testSinglePileNegative() {
        val stoneValue = intArrayOf(-5)

        val result = solution.stoneGameIII(stoneValue)

        assertEquals("Bob", result, "Alice is forced to take the only negative pile and loses")
    }

    @Test
    @DisplayName("Single pile zero: stoneValue = [0], returns Tie")
    fun testSinglePileZero() {
        val stoneValue = intArrayOf(0)

        val result = solution.stoneGameIII(stoneValue)

        assertEquals("Tie", result, "The only pile is zero so scores are equal")
    }

    @Test
    @DisplayName("Two piles: stoneValue = [1,2], returns Alice")
    fun testTwoPiles() {
        val stoneValue = intArrayOf(1, 2)

        val result = solution.stoneGameIII(stoneValue)

        assertEquals("Alice", result, "Alice takes both piles for a score of 3 and wins")
    }

    @Test
    @DisplayName("Three piles taken at once: stoneValue = [1,1,1], returns Alice")
    fun testThreePiles() {
        val stoneValue = intArrayOf(1, 1, 1)

        val result = solution.stoneGameIII(stoneValue)

        assertEquals("Alice", result, "Alice takes all three piles for a score of 3 and wins")
    }

    @Test
    @DisplayName("All zeros: stoneValue = [0,0,0,0], returns Tie")
    fun testAllZeros() {
        val stoneValue = intArrayOf(0, 0, 0, 0)

        val result = solution.stoneGameIII(stoneValue)

        assertEquals("Tie", result, "Every pile is zero so the game ends in a tie")
    }
    
    @Test
    @DisplayName("Longer array: stoneValue = [-1,-2,-3,7,-8], returns Bob")
    fun testLongerArray() {
        val stoneValue = intArrayOf(-1, -2, -3, 7, -8)

        val result = solution.stoneGameIII(stoneValue)

        assertEquals("Bob", result, "Optimal play leaves Bob with the higher score")
    }
}
