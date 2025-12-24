package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AppleRedistributionIntoBoxesTest {
    private val solution = AppleRedistributionIntoBoxes()

    @Test
    fun minimumBoxes_example1_returns2() {
        val apple = intArrayOf(1, 3, 2)
        val capacity = intArrayOf(4, 3, 1, 5, 2)
        assertEquals(2, solution.minimumBoxes(apple, capacity))
    }

    @Test
    fun minimumBoxes_example2_returns4() {
        val apple = intArrayOf(5, 5, 5)
        val capacity = intArrayOf(2, 4, 2, 7)
        assertEquals(4, solution.minimumBoxes(apple, capacity))
    }

    @Test
    fun minimumBoxes_singleApple_singleBox_returns1() {
        val apple = intArrayOf(10)
        val capacity = intArrayOf(15)
        assertEquals(1, solution.minimumBoxes(apple, capacity))
    }

    @Test
    fun minimumBoxes_multipleApples_singleLargeBox_returns1() {
        val apple = intArrayOf(1, 2, 3, 4)
        val capacity = intArrayOf(20)
        assertEquals(1, solution.minimumBoxes(apple, capacity))
    }

    @Test
    fun minimumBoxes_exactFit_returns1() {
        val apple = intArrayOf(5, 5)
        val capacity = intArrayOf(10, 5, 3)
        assertEquals(1, solution.minimumBoxes(apple, capacity))
    }

    @Test
    fun minimumBoxes_needsMultipleSmallBoxes_returnsCorrectCount() {
        val apple = intArrayOf(10)
        val capacity = intArrayOf(3, 3, 3, 3, 3)
        assertEquals(4, solution.minimumBoxes(apple, capacity))
    }

    @Test
    fun minimumBoxes_largeCapacityBoxFirst_usesLargestFirst() {
        val apple = intArrayOf(8)
        val capacity = intArrayOf(1, 2, 10)
        assertEquals(1, solution.minimumBoxes(apple, capacity))
    }

    @Test
    fun minimumBoxes_manyApplesInOneBasket_returns1() {
        val apple = intArrayOf(100)
        val capacity = intArrayOf(50, 60, 70)
        assertEquals(2, solution.minimumBoxes(apple, capacity))
    }

    @Test
    fun minimumBoxes_minimumApples_minimumBoxes_returns1() {
        val apple = intArrayOf(1)
        val capacity = intArrayOf(1)
        assertEquals(1, solution.minimumBoxes(apple, capacity))
    }

    @Test
    fun minimumBoxes_zeroApples_returns0() {
        val apple = intArrayOf(0, 0, 0)
        val capacity = intArrayOf(5, 10, 15)
        assertEquals(0, solution.minimumBoxes(apple, capacity))
    }

    @Test
    fun minimumBoxes_alternatingCapacities_usesOptimal() {
        val apple = intArrayOf(3, 4, 5)
        val capacity = intArrayOf(2, 8, 3, 1, 6)
        assertEquals(2, solution.minimumBoxes(apple, capacity))
    }

    @Test
    fun minimumBoxes_allBoxesNeeded_returnsAllBoxCount() {
        val apple = intArrayOf(20, 20, 20)
        val capacity = intArrayOf(10, 15, 20, 25)
        assertEquals(3, solution.minimumBoxes(apple, capacity))
    }
}
