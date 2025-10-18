package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfDistinctElementsAfterOperationsTest {
    private val solution = MaximumNumberOfDistinctElementsAfterOperations()

    @Test
    fun `empty array`() {
        assertEquals(0, solution.maxDistinctElements(intArrayOf(), 5))
    }

    @Test
    fun `k zero counts distinct only`() {
        val nums = intArrayOf(5, 5, 6, 7, 7, -1)
        // Distinct: -1,5,6,7 -> 4
        assertEquals(4, solution.maxDistinctElements(nums, 0))
    }

    @Test
    fun `all same value with positive k`() {
        val nums = intArrayOf(10, 10, 10, 10)
        val k = 2
        // Intervals: [8,12] repeated 4 times -> choose 8,9,10,11 -> 4
        assertEquals(4, solution.maxDistinctElements(nums, k))
    }

    @Test
    fun `simple increasing sequence with k one`() {
        val nums = intArrayOf(1, 2, 3)
        val k = 1
        // intervals: [0,2],[1,3],[2,4]; choose 0,1,2 -> 3
        assertEquals(3, solution.maxDistinctElements(nums, k))
    }

    @Test
    fun `negative numbers mixed`() {
        val nums = intArrayOf(-5, -5, -4, -1)
        val k = 1
        // intervals: [-6,-4],[-6,-4],[-5,-3],[-2,0] -> pick -6,-5,-4,-2 -> 4
        assertEquals(4, solution.maxDistinctElements(nums, k))
    }

    @Test
    fun `large k allowing wide spread`() {
        val nums = intArrayOf(100, 200, 300)
        val k = 1_000_000_000 // large but safe
        // intervals almost entire int range -> can pick 3 distinct easily
        assertEquals(3, solution.maxDistinctElements(nums, k))
    }

    @Test
    fun `near int boundaries`() {
        val nums = intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE - 1)
        val k = 5
        // intervals: [MAX-5,MAX+5] etc clamped at Int.MAX_VALUE
        // We can pick MAX-5, MAX-4, MAX-3
        assertEquals(3, solution.maxDistinctElements(nums, k))
    }

    @Test
    fun `dense cluster enabling many picks`() {
        val nums = intArrayOf(0, 0, 0, 1, 1, 1, 2, 2, 2)
        val k = 2
        // intervals around 0: [-2,2] x3; around 1: [-1,3] x3; around 2: [0,4] x3
        // Greedy picks: -2,-1,0,1,2,3,4 -> 7 distinct
        assertEquals(7, solution.maxDistinctElements(nums, k))
    }

    @Test
    fun `single element large k`() {
        val nums = intArrayOf(42)
        val k = 1000
        assertEquals(1, solution.maxDistinctElements(nums, k))
    }
}
