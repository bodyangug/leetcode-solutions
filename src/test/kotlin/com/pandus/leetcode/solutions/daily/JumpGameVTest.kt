package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class JumpGameVTest {
    private val solution = JumpGameV()

    @Test
    @DisplayName("Example 1: arr=[6,4,14,6,8,13,9,7,10,6,12], d=2 should return 4")
    fun testExample1() {
        assertEquals(4, solution.maxJumps(intArrayOf(6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12), 2))
    }

    @Test
    @DisplayName("Example 2: arr=[3,3,3,3,3], d=3 should return 1")
    fun testExample2() {
        assertEquals(1, solution.maxJumps(intArrayOf(3, 3, 3, 3, 3), 3))
    }

    @Test
    @DisplayName("Example 3: arr=[7,6,5,4,3,2,1], d=1 should return 7")
    fun testExample3() {
        assertEquals(7, solution.maxJumps(intArrayOf(7, 6, 5, 4, 3, 2, 1), 1))
    }

    @Test
    @DisplayName("Single element: arr=[5], d=1 should return 1")
    fun testSingleElement() {
        assertEquals(1, solution.maxJumps(intArrayOf(5), 1))
    }

    @Test
    @DisplayName("Two elements descending: arr=[2,1], d=1 should return 2")
    fun testTwoElements() {
        assertEquals(2, solution.maxJumps(intArrayOf(2, 1), 1))
    }
}

