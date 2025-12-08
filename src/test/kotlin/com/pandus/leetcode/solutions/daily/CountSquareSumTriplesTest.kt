package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CountSquareSumTriplesTest {
    private val solution = CountSquareSumTriples()

    @Test
    @DisplayName("Example 1: n = 5 - should return 2")
    fun testExample1() {
        val n = 5
        val result = solution.countTriples(n)
        assertEquals(2, result, "For n=5, valid triples are (3,4,5) and (4,3,5)")
    }

    @Test
    @DisplayName("Example 2: n = 10 - should return 4")
    fun testExample2() {
        val n = 10
        val result = solution.countTriples(n)
        assertEquals(4, result, "For n=10, valid triples are (3,4,5), (4,3,5), (6,8,10), (8,6,10)")
    }

    @Test
    @DisplayName("Minimum case: n = 1 - should return 0")
    fun testMinimumCase() {
        val n = 1
        val result = solution.countTriples(n)
        assertEquals(0, result, "No square sum triples exist for n=1")
    }

    @Test
    @DisplayName("Small value: n = 2 - should return 0")
    fun testSmallValue() {
        val n = 2
        val result = solution.countTriples(n)
        assertEquals(0, result, "No square sum triples exist for n=2")
    }

    @Test
    @DisplayName("Small value: n = 3 - should return 0")
    fun testN3() {
        val n = 3
        val result = solution.countTriples(n)
        assertEquals(0, result, "No complete triples exist for n=3 (need at least 5)")
    }

    @Test
    @DisplayName("Small value: n = 4 - should return 0")
    fun testN4() {
        val n = 4
        val result = solution.countTriples(n)
        assertEquals(0, result, "No complete triples exist for n=4 (need at least 5)")
    }

    @Test
    @DisplayName("First valid triple: n = 5 - should return 2")
    fun testFirstValidTriple() {
        val n = 5
        val result = solution.countTriples(n)
        assertEquals(2, result, "First Pythagorean triple 3²+4²=5² gives 2 permutations")
    }

    @Test
    @DisplayName("Between triples: n = 12 - should return 4")
    fun testN12() {
        val n = 12
        val result = solution.countTriples(n)
        assertEquals(4, result, "For n=12, still only (3,4,5) and (6,8,10) permutations")
    }

    @Test
    @DisplayName("Include 5-12-13 triple: n = 13 - should return 6")
    fun testN13() {
        val n = 13
        val result = solution.countTriples(n)
        assertEquals(6, result, "Includes (3,4,5), (6,8,10), and (5,12,13) with permutations")
    }

    @Test
    @DisplayName("Multiple triples: n = 15 - should return 8")
    fun testN15() {
        val n = 15
        val result = solution.countTriples(n)
        assertEquals(8, result, "Includes (3,4,5), (6,8,10), (5,12,13), (9,12,15) with permutations")
    }

    @Test
    @DisplayName("Larger value: n = 20 - should return 10")
    fun testN20() {
        val n = 20
        val result = solution.countTriples(n)
        assertEquals(12, result, "For n=20, includes multiple Pythagorean triples")
    }

    @Test
    @DisplayName("Larger value: n = 25 - should return 12")
    fun testN25() {
        val n = 25
        val result = solution.countTriples(n)
        assertEquals(16, result, "For n=25, includes (7,24,25), (15,20,25) and others")
    }

    @Test
    @DisplayName("Edge case: verify order independence (a,b) vs (b,a)")
    fun testOrderIndependence() {
        // The function counts both (3,4,5) and (4,3,5) as separate triples
        // This test verifies that both orderings are counted
        val n = 5
        val result = solution.countTriples(n)
        // We expect 2 because both (3,4,5) and (4,3,5) satisfy a²+b²=c²
        assertEquals(2, result, "Both (a,b,c) and (b,a,c) should be counted separately")
    }

    @Test
    @DisplayName("Verify no duplicate c values for same (a,b) pair")
    fun testNoDuplicateCValues() {
        // This test verifies the algorithm correctly calculates c = sqrt(a²+b²)
        // and doesn't count invalid triples
        val n = 6
        val result = solution.countTriples(n)
        assertEquals(2, result, "For n=6, only (3,4,5) and (4,3,5) are valid")
    }
}
