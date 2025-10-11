// filepath: /Users/bo/Documents/my-projects/leetcode-solutions/src/test/kotlin/com/pandus/leetcode/solutions/daily/MaximumTotalDamageWithSpellCastingTest.kt
package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTotalDamageWithSpellCastingTest {

    private val solution = MaximumTotalDamageWithSpellCasting()

    @Test
    fun `test basic case with duplicate powers`() {
        val power = intArrayOf(1, 1, 3, 4)
        val expected = 6L
        val actual = solution.maximumTotalDamage(power)
        assertEquals(expected, actual)
    }

    @Test
    fun `test consecutive powers that conflict`() {
        val power = intArrayOf(7, 1, 6, 6)
        val expected = 13L
        val actual = solution.maximumTotalDamage(power)
        assertEquals(expected, actual)
    }

    @Test
    fun `test single element array`() {
        val power = intArrayOf(5)
        val expected = 5L
        val actual = solution.maximumTotalDamage(power)
        assertEquals(expected, actual)
    }

    @Test
    fun `test all same power values`() {
        val power = intArrayOf(3, 3, 3, 3)
        val expected = 12L
        val actual = solution.maximumTotalDamage(power)
        assertEquals(expected, actual)
    }

    @Test
    fun `test powers with gap greater than 2`() {
        val power = intArrayOf(1, 5, 10, 15)
        val expected = 31L
        val actual = solution.maximumTotalDamage(power)
        assertEquals(expected, actual)
    }

    @Test
    fun `test powers that are exactly 3 apart - boundary case`() {
        val power = intArrayOf(1, 4, 7, 10)
        val expected = 22L
        val actual = solution.maximumTotalDamage(power)
        assertEquals(expected, actual)
    }

    @Test
    fun `test multiple duplicates with conflicts`() {
        val power = intArrayOf(2, 2, 2, 3, 3, 4, 4, 4)
        val expected = 12L
        val actual = solution.maximumTotalDamage(power)
        assertEquals(expected, actual)
    }

    @Test
    fun `test two elements with conflict`() {
        val power = intArrayOf(5, 6)
        val expected = 6L
        val actual = solution.maximumTotalDamage(power)
        assertEquals(expected, actual)
    }

    @Test
    fun `test two elements without conflict`() {
        val power = intArrayOf(1, 10)
        val expected = 11L
        val actual = solution.maximumTotalDamage(power)
        assertEquals(expected, actual)
    }

    @Test
    fun `test many duplicates of same value`() {
        val power = intArrayOf(10, 10, 10, 10, 10)
        val expected = 50L
        val actual = solution.maximumTotalDamage(power)
        assertEquals(expected, actual)
    }
}
