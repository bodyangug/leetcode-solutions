package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMinimumAmountOfTimeToBrewPotionsTest {

    private val solution = FindMinimumAmountOfTimeToBrewPotions()

    @Test
    fun `test example 1 - skill = 1,5,2,4, mana = 5,1,4,2`() {
        val skill = intArrayOf(1, 5, 2, 4)
        val mana = intArrayOf(5, 1, 4, 2)
        val expected = 110L

        val result = solution.minTime(skill, mana)

        assertEquals(expected, result)
    }

    @Test
    fun `test example 2 - skill = 1,1,1, mana = 1,1,1`() {
        val skill = intArrayOf(1, 1, 1)
        val mana = intArrayOf(1, 1, 1)
        val expected = 5L

        val result = solution.minTime(skill, mana)

        assertEquals(expected, result)
    }

    @Test
    fun `test example 3 - skill = 1,2,3,4, mana = 1,2`() {
        val skill = intArrayOf(1, 2, 3, 4)
        val mana = intArrayOf(1, 2)
        val expected = 21L

        val result = solution.minTime(skill, mana)

        assertEquals(expected, result)
    }

    @Test
    fun `test single wizard single potion`() {
        val skill = intArrayOf(2)
        val mana = intArrayOf(3)
        val expected = 6L // (2+1) * (3+1) = 3 * 4 = 12, but this seems wrong for the algorithm

        val result = solution.minTime(skill, mana)

        assertEquals(expected, result)
    }

    @Test
    fun `test multiple wizards single potion`() {
        val skill = intArrayOf(1, 2, 3)
        val mana = intArrayOf(2)
        val expected = 12L // Based on the algorithm logic

        val result = solution.minTime(skill, mana)

        assertEquals(expected, result)
    }
}
