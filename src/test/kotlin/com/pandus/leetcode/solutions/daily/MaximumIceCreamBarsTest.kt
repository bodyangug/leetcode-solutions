package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MaximumIceCreamBarsTest {
    private val solution = MaximumIceCreamBars()

    @Test
    @DisplayName("Example 1: costs = [1,3,2,4,1], coins = 7, output = 4")
    fun testExample1() {
        val result = solution.maxIceCream(intArrayOf(1, 3, 2, 4, 1), 7)
        assertEquals(4, result, "The boy can buy 4 bars with total cost 7")
    }

    @Test
    @DisplayName("Example 2: costs = [10,6,8,7,7,8], coins = 5, output = 0")
    fun testExample2() {
        val result = solution.maxIceCream(intArrayOf(10, 6, 8, 7, 7, 8), 5)
        assertEquals(0, result, "No bar is affordable when all costs exceed available coins")
    }

    @Test
    @DisplayName("Example 3: costs = [1,6,3,1,2,5], coins = 20, output = 6")
    fun testExample3() {
        val result = solution.maxIceCream(intArrayOf(1, 6, 3, 1, 2, 5), 20)
        assertEquals(6, result, "The boy can buy all bars when total cost is within available coins")
    }
}
