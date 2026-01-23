package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MinimumPairRemovalToSortArrayIITest {
    private val solver = MinimumPairRemovalToSortArrayII()

    @Test
    @DisplayName("Edge case: empty array")
    fun minimumPairRemoval_edge_emptyArray() {
        assertEquals(0, solver.minimumPairRemoval(intArrayOf()))
    }

    @Test
    @DisplayName("Edge case: single element array")
    fun minimumPairRemoval_edge_singleElement() {
        assertEquals(0, solver.minimumPairRemoval(intArrayOf(5)))
    }

    @Test
    @DisplayName("Already sorted array: [1, 2, 3, 4, 5]")
    fun minimumPairRemoval_alreadySorted_ascending() {
        assertEquals(0, solver.minimumPairRemoval(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    @DisplayName("Already sorted array with equal elements: [1, 1, 2, 2, 3]")
    fun minimumPairRemoval_alreadySorted_withEquals() {
        assertEquals(0, solver.minimumPairRemoval(intArrayOf(1, 1, 2, 2, 3)))
    }

    @Test
    @DisplayName("Already sorted array: all equal elements [5, 5, 5, 5]")
    fun minimumPairRemoval_alreadySorted_allEqual() {
        assertEquals(0, solver.minimumPairRemoval(intArrayOf(5, 5, 5, 5)))
    }

    @Test
    @DisplayName("Two elements: already sorted [1, 2]")
    fun minimumPairRemoval_twoElements_sorted() {
        assertEquals(0, solver.minimumPairRemoval(intArrayOf(1, 2)))
    }

    @Test
    @DisplayName("Two elements: needs one operation [3, 1]")
    fun minimumPairRemoval_twoElements_unsorted() {
        assertEquals(1, solver.minimumPairRemoval(intArrayOf(3, 1)))
    }

    @Test
    @DisplayName("Simple case: [3, 1, 2]")
    fun minimumPairRemoval_simple_3_1_2() {
        assertEquals(1, solver.minimumPairRemoval(intArrayOf(3, 1, 2)))
        // Min pair: (1,2) with sum 3 -> [3, 3]
    }

    @Test
    @DisplayName("Simple case: [5, 2, 3, 1]")
    fun minimumPairRemoval_simple_5_2_3_1() {
        val result = solver.minimumPairRemoval(intArrayOf(5, 2, 3, 1))
        assertEquals(2, result)
        // Step 1: Min pair (3,1) with sum 4 -> [5, 2, 4]
        // Step 2: Min pair (2,4) with sum 6 -> [5, 6]
    }

    @Test
    @DisplayName("Case: [10, 1, 2, 3]")
    fun minimumPairRemoval_case_10_1_2_3() {
        val result = solver.minimumPairRemoval(intArrayOf(10, 1, 2, 3))
        // (10,1)=11, (1,2)=3, (2,3)=5 -> pick (1,2) -> [10, 3, 3]
        // (10,3)=13, (3,3)=6 -> pick (3,3) -> [10, 6] NOT sorted
        // (10,6)=16 -> [16] sorted
        assertEquals(3, result)
    }

    @Test
    @DisplayName("Case: [4, 3, 2, 1]")
    fun minimumPairRemoval_case_descending() {
        val result = solver.minimumPairRemoval(intArrayOf(4, 3, 2, 1))
        assertEquals(2, result)
        // Step 1: Min pair (2,1) with sum 3 -> [4, 3, 3]
        // Step 2: Min pair (3,3) with sum 6 -> [4, 6]
    }

    @Test
    @DisplayName("Case: [1, 5, 2, 4, 3]")
    fun minimumPairRemoval_case_mixed() {
        val result = solver.minimumPairRemoval(intArrayOf(1, 5, 2, 4, 3))
        // Step 1: Min pair (4,3) sum=7 -> [1, 5, 2, 7]
        // Step 2: Min pair (1,5) sum=6 -> [6, 2, 7] NOT sorted
        // Step 3: Min pair (2,7) sum=9 -> [6, 9] sorted
        assertEquals(3, result)
    }

    @Test
    @DisplayName("Case: [8, 4, 2, 1]")
    fun minimumPairRemoval_case_8_4_2_1() {
        val result = solver.minimumPairRemoval(intArrayOf(8, 4, 2, 1))
        // Step 1: Min pair (2,1) sum=3 -> [8, 4, 3] NOT sorted
        // Step 2: Min pair (4,3) sum=7 -> [8, 7] NOT sorted
        // Step 3: Min pair (8,7) sum=15 -> [15] sorted
        assertEquals(3, result)
    }

    @Test
    @DisplayName("Case: [2, 1, 4, 3, 6, 5]")
    fun minimumPairRemoval_case_alternating() {
        val result = solver.minimumPairRemoval(intArrayOf(2, 1, 4, 3, 6, 5))
        // This will require multiple operations to sort
        assertEquals(4, result)
    }

    @Test
    @DisplayName("Case: leftmost pair when multiple have same sum")
    fun minimumPairRemoval_leftmostPair() {
        val result = solver.minimumPairRemoval(intArrayOf(5, 1, 1, 2))
        // (5,1)=6, (1,1)=2, (1,2)=3 -> pick (1,1) -> [5, 2, 2]
        // (5,2)=7, (2,2)=4 -> pick (2,2) -> [5, 4] NOT sorted
        // (5,4)=9 -> [9] sorted
        assertEquals(3, result)
    }

    @Test
    @DisplayName("Case: [3, 2, 1, 5, 4]")
    fun minimumPairRemoval_case_3_2_1_5_4() {
        val result = solver.minimumPairRemoval(intArrayOf(3, 2, 1, 5, 4))
        // (3,2)=5, (2,1)=3, (1,5)=6, (5,4)=9 -> pick (2,1) -> [3, 3, 5, 4]
        // (3,3)=6, (3,5)=8, (5,4)=9 -> pick (3,3) -> [6, 5, 4] NOT sorted
        // (6,5)=11, (5,4)=9 -> pick (5,4) -> [6, 9] sorted
        assertEquals(3, result)
    }

    @Test
    @DisplayName("Case with negative numbers: [-5, -2, -3, -1]")
    fun minimumPairRemoval_negativeNumbers() {
        val result = solver.minimumPairRemoval(intArrayOf(-5, -2, -3, -1))
        // (-5,-2)=-7, (-2,-3)=-5, (-3,-1)=-4 -> pick (-5,-2) -> [-7, -3, -1] sorted
        assertEquals(1, result)
    }

    @Test
    @DisplayName("Case with mixed positive and negative: [-1, 3, -2, 4]")
    fun minimumPairRemoval_mixedPositiveNegative() {
        val result = solver.minimumPairRemoval(intArrayOf(-1, 3, -2, 4))
        // (-1,3)=2, (3,-2)=1, (-2,4)=2 -> pick (3,-2) -> [-1, 1, 4] sorted
        assertEquals(1, result)
    }

    @Test
    @DisplayName("Case: [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]")
    fun minimumPairRemoval_longDescending() {
        val result = solver.minimumPairRemoval(intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1))
        // This will require multiple operations
        assert(result > 0)
    }

    @Test
    @DisplayName("Case: array with zeros [0, 5, 0, 3]")
    fun minimumPairRemoval_withZeros() {
        val result = solver.minimumPairRemoval(intArrayOf(0, 5, 0, 3))
        // (0,5)=5, (5,0)=5, (0,3)=3 -> pick (0,3) -> [0, 5, 3] NOT sorted
        // (0,5)=5, (5,3)=8 -> pick (0,5) -> [5, 3] NOT sorted
        // (5,3)=8 -> [8] sorted
        assertEquals(3, result)
    }
}
