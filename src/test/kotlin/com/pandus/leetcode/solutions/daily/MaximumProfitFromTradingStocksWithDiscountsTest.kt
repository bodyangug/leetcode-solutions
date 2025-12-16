package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MaximumProfitFromTradingStocksWithDiscountsTest {
    private val solution = MaximumProfitFromTradingStocksWithDiscounts()

    @Test
    @DisplayName("Example 1: Two employees with hierarchy, employee 2 gets discount from employee 1")
    fun testExample1() {
        val n = 2
        val present = intArrayOf(1, 2)
        val future = intArrayOf(4, 3)
        val hierarchy = arrayOf(intArrayOf(1, 2))
        val budget = 3

        val result = solution.maxProfit(n, present, future, hierarchy, budget)

        assertEquals(5, result, "Employee 1 profit (3) + Employee 2 profit (2) = 5")
    }

    @Test
    @DisplayName("Example 2: Two employees with hierarchy, only one can afford to buy")
    fun testExample2() {
        val n = 2
        val present = intArrayOf(3, 4)
        val future = intArrayOf(5, 8)
        val hierarchy = arrayOf(intArrayOf(1, 2))
        val budget = 4

        val result = solution.maxProfit(n, present, future, hierarchy, budget)

        assertEquals(4, result, "Only Employee 2 can buy, earning profit of 4")
    }

    @Test
    @DisplayName("Example 3: Three employees with hierarchy, employee 1 and 3 buy together")
    fun testExample3() {
        val n = 3
        val present = intArrayOf(4, 6, 8)
        val future = intArrayOf(7, 9, 11)
        val hierarchy = arrayOf(intArrayOf(1, 2), intArrayOf(1, 3))
        val budget = 10

        val result = solution.maxProfit(n, present, future, hierarchy, budget)

        assertEquals(10, result, "Employee 1 profit (3) + Employee 3 profit (7) = 10")
    }

    @Test
    @DisplayName("Example 4: Three employees in chain hierarchy, all can buy with discounts")
    fun testExample4() {
        val n = 3
        val present = intArrayOf(5, 2, 3)
        val future = intArrayOf(8, 5, 6)
        val hierarchy = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))
        val budget = 7

        val result = solution.maxProfit(n, present, future, hierarchy, budget)

        assertEquals(12, result, "All employees buy: profit = 3 + 4 + 5 = 12")
    }

    @Test
    @DisplayName("Single employee with sufficient budget")
    fun testSingleEmployee() {
        val n = 1
        val present = intArrayOf(5)
        val future = intArrayOf(10)
        val hierarchy = emptyArray<IntArray>()
        val budget = 5

        val result = solution.maxProfit(n, present, future, hierarchy, budget)

        assertEquals(5, result, "Single employee profit: 10 - 5 = 5")
    }

    @Test
    @DisplayName("Single employee with insufficient budget")
    fun testSingleEmployeeInsufficientBudget() {
        val n = 1
        val present = intArrayOf(10)
        val future = intArrayOf(15)
        val hierarchy = emptyArray<IntArray>()
        val budget = 5

        val result = solution.maxProfit(n, present, future, hierarchy, budget)

        assertEquals(0, result, "Cannot afford stock, profit = 0")
    }

    @Test
    @DisplayName("Zero budget results in no purchases")
    fun testZeroBudget() {
        val n = 2
        val present = intArrayOf(1, 2)
        val future = intArrayOf(4, 3)
        val hierarchy = arrayOf(intArrayOf(1, 2))
        val budget = 0

        val result = solution.maxProfit(n, present, future, hierarchy, budget)

        assertEquals(0, result, "With zero budget, no profit can be made")
    }

    @Test
    @DisplayName("Discount makes purchase possible for child employee")
    fun testDiscountEnablesPurchase() {
        val n = 2
        val present = intArrayOf(2, 4)
        val future = intArrayOf(5, 10)
        val hierarchy = arrayOf(intArrayOf(1, 2))
        val budget = 4

        val result = solution.maxProfit(n, present, future, hierarchy, budget)

        assertEquals(11, result, "Employee 1 buys (profit 3), Employee 2 gets discount (profit 8)")
    }

    @Test
    @DisplayName("Multiple children can benefit from parent's discount")
    fun testMultipleChildrenDiscount() {
        val n = 4
        val present = intArrayOf(2, 4, 4, 6)
        val future = intArrayOf(5, 8, 9, 12)
        val hierarchy = arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(1, 4))
        val budget = 8

        val result = solution.maxProfit(n, present, future, hierarchy, budget)

        // Employee 1 buys at 2 (profit 3)
        // Employee 3 gets discount to 2 (profit 7)
        // Employee 4 gets discount to 3 (profit 9)
        // Total cost: 2 + 2 + 3 = 7, total profit: 3 + 7 + 9 = 19
        assertEquals(19, result, "Parent and multiple children benefit from discount")
    }
}
