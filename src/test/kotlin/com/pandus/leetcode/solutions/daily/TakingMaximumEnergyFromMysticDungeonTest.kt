package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TakingMaximumEnergyFromMysticDungeonTest {

    private val solution = TakingMaximumEnergyFromMysticDungeon()

    @Test
    fun `test example 1 - starting from magician 1 gives energy 3`() {
        val energy = intArrayOf(5, 2, -10, -5, 1)
        val k = 3
        val expected = 3
        val actual = solution.maximumEnergy(energy, k)
        assertEquals(expected, actual)
    }

    @Test
    fun `test example 2 - all negative energies`() {
        val energy = intArrayOf(-2, -3, -1)
        val k = 2
        val expected = -1
        val actual = solution.maximumEnergy(energy, k)
        assertEquals(expected, actual)
    }

    @Test
    fun `test single element array`() {
        val energy = intArrayOf(10)
        val k = 1
        val expected = 10
        val actual = solution.maximumEnergy(energy, k)
        assertEquals(expected, actual)
    }

    @Test
    fun `test single element array with negative energy`() {
        val energy = intArrayOf(-5)
        val k = 1
        val expected = -5
        val actual = solution.maximumEnergy(energy, k)
        assertEquals(expected, actual)
    }

    @Test
    fun `test k equals array length - can only visit one magician`() {
        val energy = intArrayOf(1, 2, 3, 4, 5)
        val k = 5
        val expected = 5
        val actual = solution.maximumEnergy(energy, k)
        assertEquals(expected, actual)
    }

    @Test
    fun `test all positive energies`() {
        val energy = intArrayOf(1, 2, 3, 4, 5)
        val k = 2
        val expected = 9 // Starting from index 0: 1 + 3 + 5 = 9
        val actual = solution.maximumEnergy(energy, k)
        assertEquals(expected, actual)
    }

    @Test
    fun `test mixed positive and negative energies`() {
        val energy = intArrayOf(10, -5, 8, -3, 6)
        val k = 2
        val expected = 24 // Starting from index 0: 10 + 8 + 6 = 24
        val actual = solution.maximumEnergy(energy, k)
        assertEquals(expected, actual)
    }

    @Test
    fun `test k equals 1 - consecutive elements`() {
        val energy = intArrayOf(1, -2, 3, -4, 5)
        val k = 1
        val expected = 5 // Best is starting from last element
        val actual = solution.maximumEnergy(energy, k)
        assertEquals(expected, actual)
    }

    @Test
    fun `test large k value - larger than array`() {
        val energy = intArrayOf(5, 3, 2)
        val k = 10
        val expected = 5
        val actual = solution.maximumEnergy(energy, k)
        assertEquals(expected, actual)
    }

    @Test
    fun `test alternating positive and negative with k=3`() {
        val energy = intArrayOf(10, -20, 5, 15, -10, 8)
        val k = 3
        val expected = 25 // Starting from index 0: 10 + 15 = 25
        val actual = solution.maximumEnergy(energy, k)
        assertEquals(expected, actual)
    }

    @Test
    fun `test two elements with k=1`() {
        val energy = intArrayOf(5, 10)
        val k = 1
        val expected = 15 // 5 + 10
        val actual = solution.maximumEnergy(energy, k)
        assertEquals(expected, actual)
    }

    @Test
    fun `test decreasing negative energies`() {
        val energy = intArrayOf(-1, -2, -3, -4, -5)
        val k = 2
        val expected = -4 // Starting from index 3: -4
        val actual = solution.maximumEnergy(energy, k)
        assertEquals(expected, actual)
    }
}
