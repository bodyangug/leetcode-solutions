package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MaximumRunningTimeOfNComputersTest {

    private val solution = MaximumRunningTimeOfNComputers()

    @Test
    @DisplayName("Example 1: n=2, batteries=[3,3,3] should return 4")
    fun testExample1() {
        val n = 2
        val batteries = intArrayOf(3, 3, 3)
        val result = solution.maxRunTime(n, batteries)
        assertEquals(4L, result, "With 2 computers and batteries [3,3,3], max runtime is 4")
    }

    @Test
    @DisplayName("Example 2: n=2, batteries=[1,1,1,1] should return 2")
    fun testExample2() {
        val n = 2
        val batteries = intArrayOf(1, 1, 1, 1)
        val result = solution.maxRunTime(n, batteries)
        assertEquals(2L, result, "With 2 computers and batteries [1,1,1,1], max runtime is 2")
    }

    @Test
    @DisplayName("Example 3: n=3, batteries=[10,10,3,5] should return 8")
    fun testExample3() {
        val n = 3
        val batteries = intArrayOf(10, 10, 3, 5)
        val result = solution.maxRunTime(n, batteries)
        assertEquals(8L, result, "With 3 computers and batteries [10,10,3,5], max runtime is 8")
    }

    @Test
    @DisplayName("Single computer with single battery")
    fun testSingleComputerSingleBattery() {
        val n = 1
        val batteries = intArrayOf(5)
        val result = solution.maxRunTime(n, batteries)
        assertEquals(5L, result, "Single computer with battery power 5 should run for 5 minutes")
    }

    @Test
    @DisplayName("Single computer with multiple batteries")
    fun testSingleComputerMultipleBatteries() {
        val n = 1
        val batteries = intArrayOf(2, 3, 5, 7)
        val result = solution.maxRunTime(n, batteries)
        assertEquals(17L, result, "Single computer can use all battery power: 2+3+5+7=17")
    }

    @Test
    @DisplayName("Equal distribution - n computers with n equal batteries")
    fun testEqualDistribution() {
        val n = 4
        val batteries = intArrayOf(10, 10, 10, 10)
        val result = solution.maxRunTime(n, batteries)
        assertEquals(10L, result, "4 computers with 4 batteries of 10 each should run for 10 minutes")
    }

    @Test
    @DisplayName("More batteries than computers")
    fun testMoreBatteriesThanComputers() {
        val n = 2
        val batteries = intArrayOf(5, 5, 5, 5, 5, 5)
        val result = solution.maxRunTime(n, batteries)
        assertEquals(15L, result, "2 computers with 6 batteries of 5 each can run for 15 minutes (30/2)")
    }

    @Test
    @DisplayName("Minimum case - one computer, one battery with power 1")
    fun testMinimumCase() {
        val n = 1
        val batteries = intArrayOf(1)
        val result = solution.maxRunTime(n, batteries)
        assertEquals(1L, result, "Single computer with battery power 1 should run for 1 minute")
    }

    @Test
    @DisplayName("Large values test")
    fun testLargeValues() {
        val n = 2
        val batteries = intArrayOf(1000000000, 1000000000)
        val result = solution.maxRunTime(n, batteries)
        assertEquals(1000000000L, result, "Should handle large integer values correctly")
    }

    @Test
    @DisplayName("All small batteries with many computers")
    fun testManySmallBatteries() {
        val n = 3
        val batteries = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1)
        val result = solution.maxRunTime(n, batteries)
        assertEquals(3L, result, "3 computers with 9 batteries of 1 each should run for 3 minutes (9/3)")
    }

    @Test
    @DisplayName("Sequential battery powers")
    fun testSequentialPowers() {
        val n = 3
        val batteries = intArrayOf(1, 2, 3, 4, 5, 6)
        val result = solution.maxRunTime(n, batteries)
        assertEquals(7L, result, "3 computers with sequential batteries [1,2,3,4,5,6] sum=21, 21/3=7")
    }

    @Test
    @DisplayName("Many computers, exact match batteries")
    fun testExactMatchBatteries() {
        val n = 5
        val batteries = intArrayOf(5, 5, 5, 5, 5)
        val result = solution.maxRunTime(n, batteries)
        assertEquals(5L, result, "Perfect match: 5 computers with 5 batteries of 5 each")
    }
}
