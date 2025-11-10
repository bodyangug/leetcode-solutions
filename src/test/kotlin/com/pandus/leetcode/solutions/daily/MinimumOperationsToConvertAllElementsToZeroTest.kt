package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MinimumOperationsToConvertAllElementsToZeroTest {
    private val solver = MinimumOperationsToConvertAllElementsToZero()

    @Test
    @DisplayName("Example 1: nums = [1,5,0,3,5]")
    fun minOperations_example1() {
        assertEquals(4, solver.minOperations(intArrayOf(1, 5, 0, 3, 5)))
    }

    @Test
    @DisplayName("Example 2: nums = [2,2,3,4]")
    fun minOperations_example2() {
        assertEquals(3, solver.minOperations(intArrayOf(2, 2, 3, 4)))
    }

    @Test
    @DisplayName("Edge case: single element array with zero")
    fun minOperations_singleZero() {
        assertEquals(0, solver.minOperations(intArrayOf(0)))
    }

    @Test
    @DisplayName("Edge case: single element array with positive number")
    fun minOperations_singlePositive() {
        assertEquals(1, solver.minOperations(intArrayOf(5)))
    }

    @Test
    @DisplayName("Edge case: all zeros")
    fun minOperations_allZeros() {
        assertEquals(0, solver.minOperations(intArrayOf(0, 0, 0, 0)))
    }

    @Test
    @DisplayName("Edge case: all same positive numbers")
    fun minOperations_allSame() {
        assertEquals(1, solver.minOperations(intArrayOf(3, 3, 3, 3)))
    }

    @Test
    @DisplayName("Ascending order: nums = [1,2,3,4,5]")
    fun minOperations_ascending() {
        assertEquals(5, solver.minOperations(intArrayOf(1, 2, 3, 4, 5)))
        // Each increment requires a new operation
    }

    @Test
    @DisplayName("Descending order: nums = [5,4,3,2,1]")
    fun minOperations_descending() {
        assertEquals(5, solver.minOperations(intArrayOf(5, 4, 3, 2, 1)))
        // All can be handled in one operation
    }

    @Test
    @DisplayName("Mountain pattern: nums = [1,3,5,3,1]")
    fun minOperations_mountain() {
        assertEquals(3, solver.minOperations(intArrayOf(1, 3, 5, 3, 1)))
    }

    @Test
    @DisplayName("Zeros in between: nums = [3,0,0,3]")
    fun minOperations_zerosInBetween() {
        assertEquals(2, solver.minOperations(intArrayOf(3, 0, 0, 3)))
    }

    @Test
    @DisplayName("Mixed with zeros: nums = [1,0,2,0,3]")
    fun minOperations_mixedWithZeros() {
        assertEquals(3, solver.minOperations(intArrayOf(1, 0, 2, 0, 3)))
    }

    @Test
    @DisplayName("Two elements same: nums = [2,2]")
    fun minOperations_twoSame() {
        assertEquals(1, solver.minOperations(intArrayOf(2, 2)))
    }

    @Test
    @DisplayName("Two elements ascending: nums = [1,2]")
    fun minOperations_twoAscending() {
        assertEquals(2, solver.minOperations(intArrayOf(1, 2)))
    }

    @Test
    @DisplayName("Two elements descending: nums = [2,1]")
    fun minOperations_twoDescending() {
        assertEquals(2, solver.minOperations(intArrayOf(2, 1)))
    }

    @Test
    @DisplayName("Complex case: nums = [1,2,1,2,1]")
    fun minOperations_complex1() {
        assertEquals(3, solver.minOperations(intArrayOf(1, 2, 1, 2, 1)))
    }

    @Test
    @DisplayName("Complex case: nums = [5,1,3,2,4]")
    fun minOperations_complex2() {
        assertEquals(5, solver.minOperations(intArrayOf(5, 1, 3, 2, 4)))
    }

    @Test
    @DisplayName("Large values: nums = [100,200,50,150]")
    fun minOperations_largeValues() {
        assertEquals(4, solver.minOperations(intArrayOf(100, 200, 50, 150)))
    }

    @Test
    @DisplayName("Plateau pattern: nums = [1,3,3,3,1]")
    fun minOperations_plateau() {
        assertEquals(2, solver.minOperations(intArrayOf(1, 3, 3, 3, 1)))
    }
}
