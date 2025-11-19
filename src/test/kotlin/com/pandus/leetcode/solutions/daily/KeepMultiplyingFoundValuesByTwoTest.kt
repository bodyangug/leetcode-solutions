package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KeepMultiplyingFoundValuesByTwoTest {
    private val solver = KeepMultiplyingFoundValuesByTwo()

    @Test
    fun sampleCase1() {
        val nums = intArrayOf(5, 3, 6, 1, 12)
        val original = 3
        assertEquals(24, solver.findFinalValue(nums, original))
    }

    @Test
    fun sampleCase2() {
        val nums = intArrayOf(2, 7, 9)
        val original = 4
        assertEquals(4, solver.findFinalValue(nums, original))
    }

    @Test
    fun originalNotInArray() {
        val nums = intArrayOf(1, 2, 4, 8, 16)
        val original = 3
        assertEquals(3, solver.findFinalValue(nums, original))
    }

    @Test
    fun singleMultiplication() {
        val nums = intArrayOf(5, 10, 20)
        val original = 5
        assertEquals(40, solver.findFinalValue(nums, original))
    }

    @Test
    fun noMultiplication() {
        val nums = intArrayOf(1, 3, 5, 7)
        val original = 2
        assertEquals(2, solver.findFinalValue(nums, original))
    }

    @Test
    fun multipleMultiplications() {
        val nums = intArrayOf(1, 2, 4, 8, 16, 32)
        val original = 1
        assertEquals(64, solver.findFinalValue(nums, original))
    }

    @Test
    fun emptyArray() {
        val nums = intArrayOf()
        val original = 5
        assertEquals(5, solver.findFinalValue(nums, original))
    }

    @Test
    fun singleElementArrayMatching() {
        val nums = intArrayOf(7)
        val original = 7
        assertEquals(14, solver.findFinalValue(nums, original))
    }

    @Test
    fun singleElementArrayNotMatching() {
        val nums = intArrayOf(7)
        val original = 5
        assertEquals(5, solver.findFinalValue(nums, original))
    }

    @Test
    fun largeOriginalValue() {
        val nums = intArrayOf(1000, 2000, 4000)
        val original = 1000
        assertEquals(8000, solver.findFinalValue(nums, original))
    }

    @Test
    fun duplicatesInArray() {
        val nums = intArrayOf(3, 6, 6, 12, 12, 24)
        val original = 3
        assertEquals(48, solver.findFinalValue(nums, original))
    }
}
