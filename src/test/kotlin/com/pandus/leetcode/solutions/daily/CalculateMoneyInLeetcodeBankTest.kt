package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CalculateMoneyInLeetcodeBankTest {
    private val solver = CalculateMoneyInLeetcodeBank()

    @Test
    @DisplayName("Basic case: n=4 (single partial week)")
    fun totalMoney_basic_n4() {
        assertEquals(10, solver.totalMoney(4)) // 1+2+3+4
    }

    @Test
    @DisplayName("Basic case: n=10 (full week + 3 days of next week)")
    fun totalMoney_basic_n10() {
        assertEquals(37, solver.totalMoney(10)) // 28 + (2+3+4)
    }

    @Test
    @DisplayName("Basic case: n=20 (two full weeks + 6 days)")
    fun totalMoney_basic_n20() {
        assertEquals(96, solver.totalMoney(20)) // (1..7)=28 + (2..8)=35 + (3..8)=33
    }

    @Test
    @DisplayName("Edge case: n=1 (minimum positive day)")
    fun totalMoney_edge_n1() {
        assertEquals(1, solver.totalMoney(1))
    }
}
