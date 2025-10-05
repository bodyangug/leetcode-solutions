package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FactorialTrailingZeroesTest {

    private val solution = FactorialTrailingZeroes()

    @Test
    fun testExample1() {
        assertEquals(1, solution.trailingZeroes(5)) // 5! = 120 has 1 trailing zero
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.trailingZeroes(3)) // 3! = 6 has 0 trailing zeros
    }

    @Test
    fun testExample3() {
        assertEquals(0, solution.trailingZeroes(0)) // 0! = 1 has 0 trailing zeros
    }

    @Test
    fun testLargerNumbers() {
        assertEquals(2, solution.trailingZeroes(10)) // 10! has 2 trailing zeros
        assertEquals(4, solution.trailingZeroes(20)) // 20! has 4 trailing zeros
        assertEquals(6, solution.trailingZeroes(25)) // 25! has 6 trailing zeros (25 = 5^2)
    }

    @Test
    fun testVeryLargeNumber() {
        assertEquals(24, solution.trailingZeroes(100)) // 100! has 24 trailing zeros
    }

    @Test
    fun testPowerOfFive() {
        assertEquals(6, solution.trailingZeroes(25)) // 25 = 5^2, extra factor of 5
        assertEquals(31, solution.trailingZeroes(125)) // 125 = 5^3, more factors of 5
    }
}
