package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class JumpGameTest {

    private val solution = JumpGame()

    @Test
    fun testExample1() {
        val nums = intArrayOf(2, 3, 1, 1, 4)
        assertTrue(solution.canJump(nums))
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(3, 2, 1, 0, 4)
        assertFalse(solution.canJump(nums))
    }

    @Test
    fun testSingleElement() {
        val nums = intArrayOf(0)
        assertTrue(solution.canJump(nums)) // Already at the end
    }

    @Test
    fun testCannotJumpZero() {
        val nums = intArrayOf(1, 0, 1, 0)
        assertFalse(solution.canJump(nums))
    }

    @Test
    fun testLargeJump() {
        val nums = intArrayOf(5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0)
        assertTrue(solution.canJump(nums))
    }

    @Test
    fun testAllOnes() {
        val nums = intArrayOf(1, 1, 1, 1, 1)
        assertTrue(solution.canJump(nums))
    }
}
