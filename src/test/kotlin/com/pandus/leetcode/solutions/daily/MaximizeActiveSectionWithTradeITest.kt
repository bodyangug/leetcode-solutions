package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeActiveSectionWithTradeITest {
    private val solution = MaximizeActiveSectionWithTradeI()

    @Test
    fun `example 1 - no valid trade possible`() {
        assertEquals(1, solution.maxActiveSectionsAfterTrade("01"))
    }

    @Test
    fun `example 2 - single trade fills all sections`() {
        assertEquals(4, solution.maxActiveSectionsAfterTrade("0100"))
    }

    @Test
    fun `example 3 - trade merges surrounding ones`() {
        assertEquals(7, solution.maxActiveSectionsAfterTrade("1000100"))
    }

    @Test
    fun `example 4 - alternating string`() {
        assertEquals(4, solution.maxActiveSectionsAfterTrade("01010"))
    }

    @Test
    fun `all active sections`() {
        assertEquals(4, solution.maxActiveSectionsAfterTrade("1111"))
    }

    @Test
    fun `all inactive sections`() {
        assertEquals(0, solution.maxActiveSectionsAfterTrade("0000"))
    }

    @Test
    fun `single active section`() {
        assertEquals(1, solution.maxActiveSectionsAfterTrade("1"))
    }

    @Test
    fun `single inactive section`() {
        assertEquals(0, solution.maxActiveSectionsAfterTrade("0"))
    }

    @Test
    fun `two separated blocks of ones`() {
        assertEquals(4, solution.maxActiveSectionsAfterTrade("110011"))
    }

    @Test
    fun `leading and trailing zeros`() {
        assertEquals(7, solution.maxActiveSectionsAfterTrade("0011100"))
    }
}
