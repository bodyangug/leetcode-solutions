package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CountOperationsToObtainZeroTest {
    private val solver = CountOperationsToObtainZero()

    @Test
    @DisplayName("Basic case: num1=2, num2=3")
    fun countOperations_basic_2_3() {
        assertEquals(3, solver.countOperations(2, 3))
        // Step 1: num1=2, num2=3 -> num1=2, num2=1 (3-2=1)
        // Step 2: num1=2, num2=1 -> num1=1, num2=0 (2-1=1)
        // Step 3: num1=1, num2=0 -> num1=0, num2=0 (1-1=0)
    }

    @Test
    @DisplayName("Basic case: num1=10, num2=10 (equal numbers)")
    fun countOperations_basic_10_10() {
        assertEquals(1, solver.countOperations(10, 10))
        // Step 1: 10-10=0
    }

    @Test
    @DisplayName("Edge case: num1=0, num2=5")
    fun countOperations_edge_0_5() {
        assertEquals(0, solver.countOperations(0, 5))
        // One number is already 0, no operations needed
    }

    @Test
    @DisplayName("Edge case: num1=7, num2=0")
    fun countOperations_edge_7_0() {
        assertEquals(0, solver.countOperations(7, 0))
        // One number is already 0, no operations needed
    }

    @Test
    @DisplayName("Edge case: num1=0, num2=0")
    fun countOperations_edge_0_0() {
        assertEquals(0, solver.countOperations(0, 0))
        // Both numbers are 0, no operations needed
    }

    @Test
    @DisplayName("Edge case: num1=1, num2=1")
    fun countOperations_edge_1_1() {
        assertEquals(1, solver.countOperations(1, 1))
        // 1-1=0
    }

    @Test
    @DisplayName("Basic case: num1=1, num2=5")
    fun countOperations_basic_1_5() {
        assertEquals(5, solver.countOperations(1, 5))
        // 5 steps to subtract 1 from 5
    }

    @Test
    @DisplayName("Basic case: num1=5, num2=1")
    fun countOperations_basic_5_1() {
        assertEquals(5, solver.countOperations(5, 1))
        // 5 steps to subtract 1 from 5
    }

    @Test
    @DisplayName("Medium case: num1=8, num2=4")
    fun countOperations_medium_8_4() {
        assertEquals(2, solver.countOperations(8, 4))
        // Step 1: 8-4=4, num1=4, num2=4
        // Step 2: 4-4=0
    }

    @Test
    @DisplayName("Medium case: num1=12, num2=8")
    fun countOperations_medium_12_8() {
        assertEquals(3, solver.countOperations(12, 8))
        // Step 1: 12-8=4, num1=4, num2=8
        // Step 2: 8-4=4, num1=4, num2=4
        // Step 3: 4-4=0
    }

    @Test
    @DisplayName("Large case: num1=100, num2=50")
    fun countOperations_large_100_50() {
        assertEquals(2, solver.countOperations(100, 50))
        // 100-50=50, then 50-50=0
    }

    @Test
    @DisplayName("Large case: num1=100, num2=1")
    fun countOperations_large_100_1() {
        assertEquals(100, solver.countOperations(100, 1))
        // Need 100 operations to subtract 1 from 100
    }

    @Test
    @DisplayName("Large case: num1=1, num2=100")
    fun countOperations_large_1_100() {
        assertEquals(100, solver.countOperations(1, 100))
        // Need 100 operations to subtract 1 from 100
    }

    @Test
    @DisplayName("Large case: num1=1000, num2=250")
    fun countOperations_large_1000_250() {
        assertEquals(4, solver.countOperations(1000, 250))
        // 1000/250=4 -> 0
    }

    @Test
    @DisplayName("Multiple of one another: num1=20, num2=5")
    fun countOperations_multiple_20_5() {
        assertEquals(4, solver.countOperations(20, 5))
        // 20/5=4 operations
    }

    @Test
    @DisplayName("Multiple of one another: num1=5, num2=20")
    fun countOperations_multiple_5_20() {
        assertEquals(4, solver.countOperations(5, 20))
        // 20/5=4 operations
    }
}
