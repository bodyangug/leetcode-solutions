package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SmallestIntegerDivisibleByKTest {

    private val solution = SmallestIntegerDivisibleByK()

    @Test
    @DisplayName("Example 1: k = 1 should return 1 (repunit: 1)")
    fun testExample1() {
        val k = 1
        val result = solution.smallestRepunitDivByK(k)
        assertEquals(1, result, "Repunit 1 is divisible by 1")
    }

    @Test
    @DisplayName("Example 2: k = 2 should return -1 (no repunit divisible by even number)")
    fun testExample2() {
        val k = 2
        val result = solution.smallestRepunitDivByK(k)
        assertEquals(-1, result, "No repunit can be divisible by 2")
    }

    @Test
    @DisplayName("Example 3: k = 3 should return 3 (repunit: 111)")
    fun testExample3() {
        val k = 3
        val result = solution.smallestRepunitDivByK(k)
        assertEquals(3, result, "Repunit 111 is divisible by 3")
    }

    @Test
    @DisplayName("k = 7 should return 6 (repunit: 111111)")
    fun testK7() {
        val k = 7
        val result = solution.smallestRepunitDivByK(k)
        assertEquals(6, result, "Repunit 111111 is divisible by 7")
    }

    @Test
    @DisplayName("k = 9 should return 9 (repunit: 111111111)")
    fun testK9() {
        val k = 9
        val result = solution.smallestRepunitDivByK(k)
        assertEquals(9, result, "Repunit 111111111 is divisible by 9")
    }

    @Test
    @DisplayName("k = 11 should return 2 (repunit: 11)")
    fun testK11() {
        val k = 11
        val result = solution.smallestRepunitDivByK(k)
        assertEquals(2, result, "Repunit 11 is divisible by 11")
    }

    @Test
    @DisplayName("k = 13 should return 6 (repunit: 111111)")
    fun testK13() {
        val k = 13
        val result = solution.smallestRepunitDivByK(k)
        assertEquals(6, result, "Repunit 111111 is divisible by 13")
    }

    @Test
    @DisplayName("k = 17 should return 16")
    fun testK17() {
        val k = 17
        val result = solution.smallestRepunitDivByK(k)
        assertEquals(16, result, "Smallest repunit divisible by 17 has length 16")
    }

    @Test
    @DisplayName("k = 19 should return 18")
    fun testK19() {
        val k = 19
        val result = solution.smallestRepunitDivByK(k)
        assertEquals(18, result, "Smallest repunit divisible by 19 has length 18")
    }

    @Test
    @DisplayName("Edge case: k = 4 should return -1 (even number)")
    fun testEvenNumber() {
        val k = 4
        val result = solution.smallestRepunitDivByK(k)
        assertEquals(-1, result, "No repunit can be divisible by 4")
    }

    @Test
    @DisplayName("Edge case: k = 5 should return -1 (ends in 5)")
    fun testK5() {
        val k = 5
        val result = solution.smallestRepunitDivByK(k)
        assertEquals(-1, result, "No repunit can be divisible by 5")
    }

    @Test
    @DisplayName("Edge case: k = 10 should return -1 (ends in 0)")
    fun testK10() {
        val k = 10
        val result = solution.smallestRepunitDivByK(k)
        assertEquals(-1, result, "No repunit can be divisible by 10")
    }

    @Test
    @DisplayName("Edge case: k = 6 should return -1 (divisible by 2)")
    fun testK6() {
        val k = 6
        val result = solution.smallestRepunitDivByK(k)
        assertEquals(-1, result, "No repunit can be divisible by 6")
    }

    @Test
    @DisplayName("Edge case: k = 8 should return -1 (divisible by 2)")
    fun testK8() {
        val k = 8
        val result = solution.smallestRepunitDivByK(k)
        assertEquals(-1, result, "No repunit can be divisible by 8")
    }

    @Test
    @DisplayName("Edge case: k = 15 should return -1 (divisible by 5)")
    fun testK15() {
        val k = 15
        val result = solution.smallestRepunitDivByK(k)
        assertEquals(-1, result, "No repunit can be divisible by 15")
    }

    @Test
    @DisplayName("Edge case: k = 20 should return -1 (divisible by 2 and 5)")
    fun testK20() {
        val k = 20
        val result = solution.smallestRepunitDivByK(k)
        assertEquals(-1, result, "No repunit can be divisible by 20")
    }

    @Test
    @DisplayName("Edge case: k = 37 should return 3")
    fun testK37() {
        val k = 37
        val result = solution.smallestRepunitDivByK(k)
        assertEquals(3, result, "Repunit 111 is divisible by 37")
    }

    @Test
    @DisplayName("Edge case: k = 41 should return 5")
    fun testK41() {
        val k = 41
        val result = solution.smallestRepunitDivByK(k)
        assertEquals(5, result, "Repunit 11111 is divisible by 41")
    }

    @Test
    @DisplayName("Prime number: k = 23 should return 22")
    fun testK23() {
        val k = 23
        val result = solution.smallestRepunitDivByK(k)
        assertEquals(22, result, "Smallest repunit divisible by 23 has length 22")
    }

    @Test
    @DisplayName("Prime number: k = 29 should return 28")
    fun testK29() {
        val k = 29
        val result = solution.smallestRepunitDivByK(k)
        assertEquals(28, result, "Smallest repunit divisible by 29 has length 28")
    }
}
