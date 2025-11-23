package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class GreatestSumDivisibleByThreeTest {

    private val solution = GreatestSumDivisibleByThree()

    @Test
    @DisplayName("Example 1: [3, 6, 5, 1, 8] should return 18")
    fun testExample1() {
        val nums = intArrayOf(3, 6, 5, 1, 8)
        val result = solution.maxSumDivThree(nums)
        assertEquals(18, result, "Should return 18 (3 + 6 + 1 + 8)")
    }

    @Test
    @DisplayName("Example 2: [4] should return 0")
    fun testExample2() {
        val nums = intArrayOf(4)
        val result = solution.maxSumDivThree(nums)
        assertEquals(0, result, "Should return 0 as we cannot make sum divisible by 3")
    }

    @Test
    @DisplayName("Example 3: [1, 2, 3, 4, 4] should return 12")
    fun testExample3() {
        val nums = intArrayOf(1, 2, 3, 4, 4)
        val result = solution.maxSumDivThree(nums)
        assertEquals(12, result, "Should return 12 (all elements sum)")
    }

    @Test
    @DisplayName("All elements divisible by 3")
    fun testAllDivisibleByThree() {
        val nums = intArrayOf(3, 6, 9, 12, 15)
        val result = solution.maxSumDivThree(nums)
        assertEquals(45, result, "Should return sum of all elements when all are divisible by 3")
    }

    @Test
    @DisplayName("Sum already divisible by 3")
    fun testSumAlreadyDivisible() {
        val nums = intArrayOf(1, 2, 3)
        val result = solution.maxSumDivThree(nums)
        assertEquals(6, result, "Should return 6 (1 + 2 + 3)")
    }

    @Test
    @DisplayName("Need to remove one element with remainder 1")
    fun testRemoveOneRemainder1() {
        val nums = intArrayOf(3, 6, 1)
        val result = solution.maxSumDivThree(nums)
        assertEquals(9, result, "Should return 9 (3 + 6), removing 1")
    }

    @Test
    @DisplayName("Need to remove one element with remainder 2")
    fun testRemoveOneRemainder2() {
        val nums = intArrayOf(3, 6, 2)
        val result = solution.maxSumDivThree(nums)
        assertEquals(9, result, "Should return 9 (3 + 6), removing 2")
    }

    @Test
    @DisplayName("Total sum % 3 = 1, remove smallest element with remainder 1")
    fun testRemoveSmallestRemainder1() {
        val nums = intArrayOf(1, 4, 7, 10)
        val result = solution.maxSumDivThree(nums)
        assertEquals(21, result, "Should return 21 (4 + 7 + 10), removing 1")
    }

    @Test
    @DisplayName("Total sum % 3 = 2, remove smallest element with remainder 2")
    fun testRemoveSmallestRemainder2() {
        val nums = intArrayOf(2, 5, 8, 11)
        val result = solution.maxSumDivThree(nums)
        assertEquals(24, result, "Should return 24 (5 + 8 + 11), removing 2")
    }

    @Test
    @DisplayName("Single element divisible by 3")
    fun testSingleElementDivisible() {
        val nums = intArrayOf(9)
        val result = solution.maxSumDivThree(nums)
        assertEquals(9, result, "Should return 9")
    }

    @Test
    @DisplayName("Single element not divisible by 3")
    fun testSingleElementNotDivisible() {
        val nums = intArrayOf(7)
        val result = solution.maxSumDivThree(nums)
        assertEquals(0, result, "Should return 0 as single element cannot be made divisible by 3")
    }

    @Test
    @DisplayName("Two elements with remainder 1 and 2")
    fun testTwoElementsRemainder1And2() {
        val nums = intArrayOf(1, 2)
        val result = solution.maxSumDivThree(nums)
        assertEquals(3, result, "Should return 3 (1 + 2)")
    }

    @Test
    @DisplayName("All zeros")
    fun testAllZeros() {
        val nums = intArrayOf(0, 0, 0, 0)
        val result = solution.maxSumDivThree(nums)
        assertEquals(0, result, "Should return 0")
    }

    @Test
    @DisplayName("Mix of zeros and positive numbers")
    fun testMixOfZerosAndPositive() {
        val nums = intArrayOf(0, 0, 3, 6, 1)
        val result = solution.maxSumDivThree(nums)
        assertEquals(9, result, "Should return 9 (0 + 0 + 3 + 6)")
    }

    @Test
    @DisplayName("Large array all divisible by 3")
    fun testLargeArrayDivisible() {
        val nums = IntArray(100) { (it + 1) * 3 }
        val result = solution.maxSumDivThree(nums)
        val expected = nums.sum()
        assertEquals(expected, result, "Should return sum of all elements")
    }

    @Test
    @DisplayName("Complex case with optimal removal strategy")
    fun testComplexOptimalRemoval() {
        val nums = intArrayOf(5, 1, 4, 10, 13, 2, 8, 14)
        val result = solution.maxSumDivThree(nums)
        // Total sum = 57, 57 % 3 = 0, so return 57
        assertEquals(57, result, "Should return 57 as sum is already divisible by 3")
    }

    @Test
    @DisplayName("Need to choose between removing 1 or 2 elements")
    fun testChooseBetweenRemovalStrategies() {
        val nums = intArrayOf(1, 1, 1, 2, 2)
        val result = solution.maxSumDivThree(nums)
        // Total sum = 7, 7 % 3 = 1
        // Option 1: Remove one element with remainder 1 -> remove 1, sum = 6
        // Option 2: Remove two elements with remainder 2 -> remove 2, 2, sum = 3
        // Choose option 1
        assertEquals(6, result, "Should return 6")
    }

    @Test
    @DisplayName("Large numbers")
    fun testLargeNumbers() {
        val nums = intArrayOf(10000, 10001, 10002)
        val result = solution.maxSumDivThree(nums)
        // Total sum = 30003, 30003 % 3 = 0
        assertEquals(30003, result, "Should handle large numbers correctly")
    }

    @Test
    @DisplayName("Only elements with remainder 1")
    fun testOnlyRemainder1() {
        val nums = intArrayOf(1, 4, 7, 10, 13)
        val result = solution.maxSumDivThree(nums)
        // Total sum = 35, 35 % 3 = 2
        // Need to remove two smallest elements with remainder 1: 1 and 4
        // Result = 35 - 5 = 30
        assertEquals(30, result, "Should return 30 (7 + 10 + 13)")
    }

    @Test
    @DisplayName("Only elements with remainder 2")
    fun testOnlyRemainder2() {
        val nums = intArrayOf(2, 5, 8, 11, 14)
        val result = solution.maxSumDivThree(nums)
        // Total sum = 40, 40 % 3 = 1
        // Need to remove two smallest elements with remainder 2: 2 and 5
        // Result = 40 - 7 = 33
        assertEquals(33, result, "Should return 33 (8 + 11 + 14)")
    }

    @Test
    @DisplayName("Minimum possible sum scenario")
    fun testMinimumSum() {
        val nums = intArrayOf(100, 1, 1)
        val result = solution.maxSumDivThree(nums)
        // Total sum = 102, 102 % 3 = 0
        assertEquals(102, result, "Should return 102")
    }

    @Test
    @DisplayName("Cannot remove enough elements")
    fun testCannotRemoveEnough() {
        val nums = intArrayOf(1, 1)
        val result = solution.maxSumDivThree(nums)
        // Total sum = 2, 2 % 3 = 2
        // Need to remove one element with remainder 2 (don't have) or two with remainder 1
        // Remove both 1s: result = 0
        assertEquals(0, result, "Should return 0")
    }

    @Test
    @DisplayName("Three elements forming perfect sum")
    fun testThreeElementsPerfectSum() {
        val nums = intArrayOf(4, 5, 6)
        val result = solution.maxSumDivThree(nums)
        // Total sum = 15, 15 % 3 = 0
        assertEquals(15, result, "Should return 15")
    }

    @Test
    @DisplayName("Mixed large and small numbers")
    fun testMixedLargeAndSmall() {
        val nums = intArrayOf(1, 1, 1, 1000, 1001)
        val result = solution.maxSumDivThree(nums)
        // Total sum = 2004, 2004 % 3 = 0
        assertEquals(2004, result, "Should return 2004")
    }
}
