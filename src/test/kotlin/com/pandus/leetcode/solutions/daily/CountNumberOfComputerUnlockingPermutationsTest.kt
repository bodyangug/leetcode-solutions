package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CountNumberOfComputerUnlockingPermutationsTest {
    private val solver = CountNumberOfComputerUnlockingPermutations()

    @Test
    @DisplayName("Example 1: complexity = [1,2,3]")
    fun countPermutations_example1() {
        assertEquals(2, solver.countPermutations(intArrayOf(1, 2, 3)))
        // Valid permutations: [0,1,2] and [0,2,1]
    }

    @Test
    @DisplayName("Example 2: complexity = [3,3,3,4,4,4]")
    fun countPermutations_example2() {
        assertEquals(0, solver.countPermutations(intArrayOf(3, 3, 3, 4, 4, 4)))
        // No valid permutations because complexity[1] <= complexity[0]
    }

    @Test
    @DisplayName("Edge case: Single computer")
    fun countPermutations_singleComputer() {
        assertEquals(1, solver.countPermutations(intArrayOf(1)))
        // Only one computer, one permutation
    }

    @Test
    @DisplayName("Edge case: Two computers with increasing complexity")
    fun countPermutations_twoComputersIncreasing() {
        assertEquals(1, solver.countPermutations(intArrayOf(1, 2)))
        // Only permutation: [0,1]
    }

    @Test
    @DisplayName("Edge case: Two computers with equal complexity")
    fun countPermutations_twoComputersEqual() {
        assertEquals(0, solver.countPermutations(intArrayOf(2, 2)))
        // No valid permutations because complexity[1] <= complexity[0]
    }

    @Test
    @DisplayName("Edge case: Two computers with decreasing complexity")
    fun countPermutations_twoComputersDecreasing() {
        assertEquals(0, solver.countPermutations(intArrayOf(5, 3)))
        // No valid permutations because complexity[1] <= complexity[0]
    }

    @Test
    @DisplayName("All computers have strictly increasing complexity")
    fun countPermutations_strictlyIncreasing() {
        assertEquals(6, solver.countPermutations(intArrayOf(1, 2, 3, 4)))
        // Valid permutations = (n-1)! = 3! = 6
    }

    @Test
    @DisplayName("Large array with strictly increasing complexity")
    fun countPermutations_largeIncreasing() {
        assertEquals(24, solver.countPermutations(intArrayOf(1, 2, 3, 4, 5)))
        // Valid permutations = (n-1)! = 4! = 24
    }

    @Test
    @DisplayName("First computer has higher complexity than second")
    fun countPermutations_firstHigherThanSecond() {
        assertEquals(0, solver.countPermutations(intArrayOf(10, 5, 15)))
        // No valid permutations because complexity[1] <= complexity[0]
    }

    @Test
    @DisplayName("One computer in middle has lower complexity than first")
    fun countPermutations_middleComputerLower() {
        assertEquals(0, solver.countPermutations(intArrayOf(5, 10, 3, 20)))
        // No valid permutations because complexity[2] <= complexity[0]
    }

    @Test
    @DisplayName("All computers have same complexity")
    fun countPermutations_allSameComplexity() {
        assertEquals(0, solver.countPermutations(intArrayOf(5, 5, 5, 5)))
        // No valid permutations because complexity[i] <= complexity[0] for all i > 0
    }

    @Test
    @DisplayName("Large factorial result with modulo")
    fun countPermutations_largeFactorialWithModulo() {
        val complexity = IntArray(10) { it + 1 }  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        assertEquals(362880, solver.countPermutations(complexity))
        // Valid permutations = (n-1)! = 9! = 362880
    }

    @Test
    @DisplayName("Large array with increasing complexity")
    fun countPermutations_largeArray() {
        val complexity = IntArray(20) { it + 1 }  // [1, 2, 3, ..., 20]
        val expected = (2..19).fold(1L) { acc, i -> (acc * i) % 1000000007 }.toInt()
        assertEquals(expected, solver.countPermutations(complexity))
        // Valid permutations = (n-1)! mod 1000000007
    }

    @Test
    @DisplayName("Minimum valid complexity difference")
    fun countPermutations_minimalDifference() {
        assertEquals(2, solver.countPermutations(intArrayOf(1, 2, 3)))
        // Even with minimal differences, should work correctly
    }

    @Test
    @DisplayName("Large complexity values but strictly increasing")
    fun countPermutations_largeValues() {
        assertEquals(6, solver.countPermutations(intArrayOf(100, 200, 300, 400)))
        // Large values don't matter, only the order matters
        // Valid permutations = (n-1)! = 3! = 6
    }
}
