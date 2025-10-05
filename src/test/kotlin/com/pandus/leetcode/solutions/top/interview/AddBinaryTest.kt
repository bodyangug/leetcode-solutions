package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AddBinaryTest {

    private val solution = AddBinary()

    @Test
    fun testExample1() {
        assertEquals("100", solution.addBinary("11", "1"))
    }

    @Test
    fun testExample2() {
        assertEquals("10101", solution.addBinary("1010", "1011"))
    }

    @Test
    fun testSameLengthNoCarry() {
        assertEquals("101", solution.addBinary("10", "11"))
    }

    @Test
    fun testDifferentLengths() {
        assertEquals("110", solution.addBinary("1", "101"))
    }

    @Test
    fun testWithZero() {
        assertEquals("1", solution.addBinary("0", "1"))
        assertEquals("101", solution.addBinary("0", "101"))
    }

    @Test
    fun testLargeNumbers() {
        assertEquals("10000", solution.addBinary("1111", "1"))
    }

    @Test
    fun testBothZero() {
        assertEquals("0", solution.addBinary("0", "0"))
    }
}
