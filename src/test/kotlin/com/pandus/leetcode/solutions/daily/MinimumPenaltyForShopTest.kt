package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MinimumPenaltyForShopTest {
    private val solver = MinimumPenaltyForShop()

    @Test
    @DisplayName("Example 1: customers = 'YYNY' returns 2")
    fun bestClosingTime_example1() {
        assertEquals(2, solver.bestClosingTime("YYNY"))
    }

    @Test
    @DisplayName("Example 2: customers = 'NNNNN' returns 0 (close immediately)")
    fun bestClosingTime_example2() {
        assertEquals(0, solver.bestClosingTime("NNNNN"))
    }

    @Test
    @DisplayName("Example 3: customers = 'YYYY' returns 4 (never close during hours)")
    fun bestClosingTime_example3() {
        assertEquals(4, solver.bestClosingTime("YYYY"))
    }

    @Test
    @DisplayName("Edge case: single customer 'Y' returns 1")
    fun bestClosingTime_singleCustomer() {
        assertEquals(1, solver.bestClosingTime("Y"))
    }

    @Test
    @DisplayName("Edge case: single no-show 'N' returns 0")
    fun bestClosingTime_singleNoShow() {
        assertEquals(0, solver.bestClosingTime("N"))
    }

    @Test
    @DisplayName("Pattern: alternating 'YNYN' returns 1")
    fun bestClosingTime_alternating1() {
        assertEquals(1, solver.bestClosingTime("YNYN"))
    }

    @Test
    @DisplayName("All customers at start: 'YYYNNNN' returns 3")
    fun bestClosingTime_customersAtStart() {
        assertEquals(3, solver.bestClosingTime("YYYNNNN"))
    }

    @Test
    @DisplayName("Mixed pattern: 'YNYNYNNYYY' returns optimal closing time")
    fun bestClosingTime_mixedPattern() {
        // Hour 0: penalty = 6 (miss all 6 Y's)
        // Hour 1: penalty = 5 (serve 1 Y)
        // Hour 2: penalty = 6 (add 1 N)
        // Hour 3: penalty = 5 (serve 1 Y)
        // Hour 4: penalty = 6 (add 1 N)
        // Hour 5: penalty = 5 (serve 1 Y)
        // Hour 6: penalty = 6 (add 1 N)
        // Hour 7: penalty = 7 (add 1 N)
        // Hour 8: penalty = 6 (serve 1 Y)
        // Hour 9: penalty = 5 (serve 1 Y)
        // Hour 10: penalty = 4 (serve 1 Y)
        // Minimum penalty is 4 at hour 10
        assertEquals(10, solver.bestClosingTime("YNYNYNNYYY"))
    }

    @Test
    @DisplayName("Long sequence of no-shows returns 0")
    fun bestClosingTime_longNoShows() {
        assertEquals(0, solver.bestClosingTime("NNNNNNNNNN"))
    }

    @Test
    @DisplayName("Long sequence of customers returns length")
    fun bestClosingTime_longCustomers() {
        val customers = "YYYYYYYYYYYY"
        assertEquals(customers.length, solver.bestClosingTime(customers))
    }

    @Test
    @DisplayName("Early optimal: 'YNNNNY' returns 1 (earliest optimal hour)")
    fun bestClosingTime_earlyOptimal() {
        // Hour 0: penalty = 2 (miss 2 Y's)
        // Hour 1: penalty = 1 (serve 1 Y, then add 3 N's, then miss 1 Y = 0+4-1 = 3... wait)
        // Let me recalculate:
        // Hour 0: penalty = 2 (miss Y at 0 and Y at 5)
        // Hour 1: penalty = 0 + 3 + 1 = 4 (0 for Y at 0, +1+1+1 for NNN, +1 for missing Y at 5)
        // Actually at hour 1: we have penalty = 1 (from N,N,N,N,Y = 4 N's and 1 missed Y)
        // Starting from hour 0: penalty = 2
        // After Y (hour 1): penalty = 1
        // After N (hour 2): penalty = 2
        // After N (hour 3): penalty = 3
        // After N (hour 4): penalty = 4
        // After N (hour 5): penalty = 5
        // After Y (hour 6): penalty = 4
        assertEquals(1, solver.bestClosingTime("YNNNNY"))
    }

    @Test
    @DisplayName("Multiple optimal hours: 'YNY' returns 1 (earliest)")
    fun bestClosingTime_multipleOptimal() {
        // Hour 0: penalty = 2 (miss both Y's)
        // Hour 1: penalty = 1 (serve first Y, +1 for N, miss last Y = -1+1+1 = 1)
        // Hour 2: penalty = 2 (serve first Y, +1 for N, serve last Y = -1+1-1+1 = 0... no)
        // Wait: from hour 0: penalty = 2
        // After Y (hour 1): penalty = 1
        // After N (hour 2): penalty = 2
        // After Y (hour 3): penalty = 1
        // So hours 1 and 3 both have penalty 1, return earliest (1)
        assertEquals(1, solver.bestClosingTime("YNY"))
    }
}
