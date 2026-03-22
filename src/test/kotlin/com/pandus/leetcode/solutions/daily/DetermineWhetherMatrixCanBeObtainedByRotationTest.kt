package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DetermineWhetherMatrixCanBeObtainedByRotationTest {
    private val solution = DetermineWhetherMatrixCanBeObtainedByRotation()

    @Test
    @DisplayName("Example 1: mat rotated 90° clockwise equals target -> true")
    fun testExample1() {
        val mat = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))
        val target = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
        assertTrue(solution.findRotation(mat, target))
    }

    @Test
    @DisplayName("Example 2: no rotation makes mat equal to target -> false")
    fun testExample2() {
        val mat = arrayOf(intArrayOf(0, 1), intArrayOf(1, 1))
        val target = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
        assertFalse(solution.findRotation(mat, target))
    }

    @Test
    @DisplayName("Example 3: mat rotated 180° (two 90° rotations) equals target -> true")
    fun testExample3() {
        val mat = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(1, 1, 1))
        val target = arrayOf(intArrayOf(1, 1, 1), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0))
        assertTrue(solution.findRotation(mat, target))
    }

    @Test
    @DisplayName("mat already equals target (0° rotation) -> true")
    fun testNoRotationNeeded() {
        val mat = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
        val target = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
        assertTrue(solution.findRotation(mat, target))
    }

    @Test
    @DisplayName("mat rotated 270° clockwise equals target -> true")
    fun testRotation270() {
        val mat = arrayOf(intArrayOf(0, 0, 1), intArrayOf(0, 1, 0), intArrayOf(1, 0, 0))
        // 270° clockwise = 90° counter-clockwise
        val target = arrayOf(intArrayOf(1, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 1))
        assertTrue(solution.findRotation(mat, target))
    }

    @Test
    @DisplayName("1x1 identity matrix: mat equals target -> true")
    fun test1x1Equal() {
        val mat = arrayOf(intArrayOf(1))
        val target = arrayOf(intArrayOf(1))
        assertTrue(solution.findRotation(mat, target))
    }

    @Test
    @DisplayName("1x1 matrices that differ -> false")
    fun test1x1NotEqual() {
        val mat = arrayOf(intArrayOf(0))
        val target = arrayOf(intArrayOf(1))
        assertFalse(solution.findRotation(mat, target))
    }

    @Test
    @DisplayName("All-zeros matrix: any rotation is still all zeros -> true")
    fun testAllZeros() {
        val mat = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))
        val target = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))
        assertTrue(solution.findRotation(mat, target))
    }

    @Test
    @DisplayName("4x4 matrix requiring 90° rotation -> true")
    fun test4x4Rotation90() {
        val mat = arrayOf(
            intArrayOf(0, 0, 0, 1),
            intArrayOf(0, 0, 1, 0),
            intArrayOf(0, 1, 0, 0),
            intArrayOf(1, 0, 0, 0)
        )
        // 90° clockwise rotation
        val target = arrayOf(
            intArrayOf(1, 0, 0, 0),
            intArrayOf(0, 1, 0, 0),
            intArrayOf(0, 0, 1, 0),
            intArrayOf(0, 0, 0, 1)
        )
        assertTrue(solution.findRotation(mat, target))
    }
}
