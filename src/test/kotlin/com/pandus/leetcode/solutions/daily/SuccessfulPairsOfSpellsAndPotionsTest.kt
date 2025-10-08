package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SuccessfulPairsOfSpellsAndPotionsTest {
    private val solution = SuccessfulPairsOfSpellsAndPotions()

    @Test
    fun `test basic example from leetcode`() {
        val spells = intArrayOf(5, 1, 3)
        val potions = intArrayOf(1, 2, 3, 4, 5)
        val success = 7L
        val expected = intArrayOf(4, 0, 3)
        assertArrayEquals(expected, solution.successfulPairs(spells, potions, success))
    }

    @Test
    fun `test second example from leetcode`() {
        val spells = intArrayOf(3, 1, 2)
        val potions = intArrayOf(8, 5, 8)
        val success = 16L
        val expected = intArrayOf(2, 0, 2)
        assertArrayEquals(expected, solution.successfulPairs(spells, potions, success))
    }

    @Test
    fun `test single spell and single potion - successful`() {
        val spells = intArrayOf(5)
        val potions = intArrayOf(3)
        val success = 10L
        val expected = intArrayOf(1)
        assertArrayEquals(expected, solution.successfulPairs(spells, potions, success))
    }

    @Test
    fun `test single spell and single potion - unsuccessful`() {
        val spells = intArrayOf(2)
        val potions = intArrayOf(3)
        val success = 10L
        val expected = intArrayOf(0)
        assertArrayEquals(expected, solution.successfulPairs(spells, potions, success))
    }

    @Test
    fun `test all spells fail`() {
        val spells = intArrayOf(1, 2, 3)
        val potions = intArrayOf(1, 1, 1)
        val success = 10L
        val expected = intArrayOf(0, 0, 0)
        assertArrayEquals(expected, solution.successfulPairs(spells, potions, success))
    }

    @Test
    fun `test all spells succeed with all potions`() {
        val spells = intArrayOf(10, 20, 30)
        val potions = intArrayOf(1, 2, 3)
        val success = 5L
        val expected = intArrayOf(3, 3, 3)
        assertArrayEquals(expected, solution.successfulPairs(spells, potions, success))
    }

    @Test
    fun `test with success value of 1`() {
        val spells = intArrayOf(1, 2, 3)
        val potions = intArrayOf(1, 2, 3)
        val success = 1L
        val expected = intArrayOf(3, 3, 3)
        assertArrayEquals(expected, solution.successfulPairs(spells, potions, success))
    }

    @Test
    fun `test with duplicate values in spells`() {
        val spells = intArrayOf(5, 5, 5)
        val potions = intArrayOf(1, 2, 3, 4, 5)
        val success = 15L
        val expected = intArrayOf(3, 3, 3) // 5 * 3,4,5 >= 15
        assertArrayEquals(expected, solution.successfulPairs(spells, potions, success))
    }

    @Test
    fun `test edge case with minimum constraints`() {
        val spells = intArrayOf(1)
        val potions = intArrayOf(1)
        val success = 1L
        val expected = intArrayOf(1)
        assertArrayEquals(expected, solution.successfulPairs(spells, potions, success))
    }

    @Test
    fun `test exact threshold matching`() {
        val spells = intArrayOf(4)
        val potions = intArrayOf(1, 2, 3, 4, 5)
        val success = 16L // 4 * 4 = 16 exactly
        val expected = intArrayOf(2) // potions 4 and 5 work
        assertArrayEquals(expected, solution.successfulPairs(spells, potions, success))
    }
}
