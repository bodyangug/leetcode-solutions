package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.random.Random

class CheckIfDigitsAreEqualInStringAfterOperationsITest {

    private val solver = CheckIfDigitsAreEqualInStringAfterOperationsI()

    private fun referenceHasSameDigits(s: String): Boolean {
        val n = s.length
        val sArray = s.toCharArray()
        for (i in 1..n - 2) {
            for (j in 0..n - 1 - i) {
                val digit1 = sArray[j].code - '0'.code
                val digit2 = sArray[j + 1].code - '0'.code
                sArray[j] = (((digit1 + digit2) % 10) + '0'.code).toChar()
            }
        }
        return sArray[0] == sArray[1]
    }

    @Test
    fun twoDigitsEqual() {
        assertTrue(solver.hasSameDigits("33"))
        assertTrue(solver.hasSameDigits("00"))
    }

    @Test
    fun twoDigitsNotEqual() {
        assertFalse(solver.hasSameDigits("12"))
        assertFalse(solver.hasSameDigits("90"))
    }

    @Test
    fun longerStringSampleCases() {
        // Manual reasoning examples
        assertFalse(solver.hasSameDigits("123"))
        assertTrue(solver.hasSameDigits("181")) // quick spot check
        assertTrue(solver.hasSameDigits("111"))
        assertFalse(solver.hasSameDigits("908"))
    }

    @Test
    fun allSameDigitsVariousLengths() {
        for (len in 2..12) {
            val s = "7".repeat(len)
            assertTrue(solver.hasSameDigits(s), "Expected true for all-same digits length=$len")
        }
    }

    @Test
    fun randomizedPropertyComparison() {
        repeat(500) {
            val len = Random.nextInt(2, 25) // length between 2 and 24 inclusive
            val s = buildString(len) { repeat(len) { append(Random.nextInt(0, 10)) } }
            val expected = referenceHasSameDigits(s)
            val actual = solver.hasSameDigits(s)
            assertEquals(expected, actual, "Mismatch for input $s")
        }
    }
}
