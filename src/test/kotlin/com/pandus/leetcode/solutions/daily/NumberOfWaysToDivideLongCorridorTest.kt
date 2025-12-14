package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToDivideLongCorridorTest {
    private val solution = NumberOfWaysToDivideLongCorridor()

    @Test
    fun `should return 3 for corridor SSPPSPS`() {
        val corridor = "SSPPSPS"
        assertEquals(3, solution.numberOfWays(corridor))
    }

    @Test
    fun `should return 1 for corridor PPSPSP`() {
        val corridor = "PPSPSP"
        assertEquals(1, solution.numberOfWays(corridor))
    }

    @Test
    fun `should return 0 for corridor with single seat S`() {
        val corridor = "S"
        assertEquals(0, solution.numberOfWays(corridor))
    }

    @Test
    fun `should return 0 for corridor with only plants`() {
        val corridor = "PPPPPP"
        assertEquals(0, solution.numberOfWays(corridor))
    }

    @Test
    fun `should return 0 for corridor with odd number of seats`() {
        val corridor = "SPSPS"
        assertEquals(0, solution.numberOfWays(corridor))
    }

    @Test
    fun `should return 1 for corridor with exactly two seats`() {
        val corridor = "SS"
        assertEquals(1, solution.numberOfWays(corridor))
    }

    @Test
    fun `should return 1 for corridor with two seats and plants SSPPP`() {
        val corridor = "SSPPP"
        assertEquals(1, solution.numberOfWays(corridor))
    }

    @Test
    fun `should return 1 for corridor with two seats and plants PPSSPPPP`() {
        val corridor = "PPSSPPPP"
        assertEquals(1, solution.numberOfWays(corridor))
    }

    @Test
    fun `should return correct value for corridor with four seats SSPPSS`() {
        val corridor = "SSPPSS"
        assertEquals(3, solution.numberOfWays(corridor))
    }

    @Test
    fun `should return correct value for corridor with four seats SSPSPPSS`() {
        val corridor = "SSPSPPSS"
        assertEquals(0, solution.numberOfWays(corridor))
    }

    @Test
    fun `should return 0 for empty corridor`() {
        val corridor = ""
        assertEquals(0, solution.numberOfWays(corridor))
    }

    @Test
    fun `should handle corridor with multiple plants between seat pairs`() {
        val corridor = "SSPPPPPPSS"
        assertEquals(7, solution.numberOfWays(corridor))
    }

    @Test
    fun `should handle corridor with no plants between seat pairs`() {
        val corridor = "SSSS"
        assertEquals(1, solution.numberOfWays(corridor))
    }

    @Test
    fun `should handle large corridor with multiple divisions`() {
        val corridor = "SSPPSPSPPSSPPSPS"
        assertEquals(27, solution.numberOfWays(corridor))
    }

    @Test
    fun `should handle corridor with three pairs of seats`() {
        val corridor = "SSPPSSPPSS"
        assertEquals(9, solution.numberOfWays(corridor))
    }
}
