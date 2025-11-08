package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MinimumOneBitOperationsToMakeIntegersZeroTest {
    private val solver = MinimumOneBitOperationsToMakeIntegersZero()

    @Test
    @DisplayName("Edge case: n=0 (already zero)")
    fun minimumOneBitOperations_edge_n0() {
        assertEquals(0, solver.minimumOneBitOperations(0))
    }

    @Test
    @DisplayName("Basic case: n=1 (single bit set)")
    fun minimumOneBitOperations_basic_n1() {
        assertEquals(1, solver.minimumOneBitOperations(1))
    }

    @Test
    @DisplayName("Basic case: n=2 (binary: 10)")
    fun minimumOneBitOperations_basic_n2() {
        assertEquals(3, solver.minimumOneBitOperations(2))
    }

    @Test
    @DisplayName("Basic case: n=3 (binary: 11)")
    fun minimumOneBitOperations_basic_n3() {
        assertEquals(2, solver.minimumOneBitOperations(3))
    }

    @Test
    @DisplayName("Basic case: n=4 (binary: 100)")
    fun minimumOneBitOperations_basic_n4() {
        assertEquals(7, solver.minimumOneBitOperations(4))
    }

    @Test
    @DisplayName("Basic case: n=5 (binary: 101)")
    fun minimumOneBitOperations_basic_n5() {
        assertEquals(6, solver.minimumOneBitOperations(5))
    }

    @Test
    @DisplayName("Basic case: n=6 (binary: 110)")
    fun minimumOneBitOperations_basic_n6() {
        assertEquals(4, solver.minimumOneBitOperations(6))
    }

    @Test
    @DisplayName("Basic case: n=7 (binary: 111)")
    fun minimumOneBitOperations_basic_n7() {
        assertEquals(5, solver.minimumOneBitOperations(7))
    }

    @Test
    @DisplayName("Medium case: n=8 (binary: 1000)")
    fun minimumOneBitOperations_medium_n8() {
        assertEquals(15, solver.minimumOneBitOperations(8))
    }

    @Test
    @DisplayName("Medium case: n=9 (binary: 1001)")
    fun minimumOneBitOperations_medium_n9() {
        assertEquals(14, solver.minimumOneBitOperations(9))
    }

    @Test
    @DisplayName("Medium case: n=15 (binary: 1111)")
    fun minimumOneBitOperations_medium_n15() {
        assertEquals(10, solver.minimumOneBitOperations(15))
    }

    @Test
    @DisplayName("Medium case: n=16 (binary: 10000)")
    fun minimumOneBitOperations_medium_n16() {
        assertEquals(31, solver.minimumOneBitOperations(16))
    }

    @Test
    @DisplayName("Medium case: n=31 (binary: 11111)")
    fun minimumOneBitOperations_medium_n31() {
        assertEquals(21, solver.minimumOneBitOperations(31))
    }

    @Test
    @DisplayName("Power of 2 case: n=32 (2^5)")
    fun minimumOneBitOperations_powerOf2_n32() {
        assertEquals(63, solver.minimumOneBitOperations(32))
    }

    @Test
    @DisplayName("Power of 2 case: n=64 (2^6)")
    fun minimumOneBitOperations_powerOf2_n64() {
        assertEquals(127, solver.minimumOneBitOperations(64))
    }

    @Test
    @DisplayName("Power of 2 case: n=128 (2^7)")
    fun minimumOneBitOperations_powerOf2_n128() {
        assertEquals(255, solver.minimumOneBitOperations(128))
    }

    @Test
    @DisplayName("Power of 2 minus 1 case: n=63 (2^6-1, all bits set)")
    fun minimumOneBitOperations_allBitsSet_n63() {
        assertEquals(42, solver.minimumOneBitOperations(63))
    }

    @Test
    @DisplayName("Power of 2 minus 1 case: n=127 (2^7-1, all bits set)")
    fun minimumOneBitOperations_allBitsSet_n127() {
        assertEquals(85, solver.minimumOneBitOperations(127))
    }
}
