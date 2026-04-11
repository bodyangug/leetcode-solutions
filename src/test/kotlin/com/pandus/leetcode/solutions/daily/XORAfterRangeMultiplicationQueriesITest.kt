package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class XORAfterRangeMultiplicationQueriesITest {
    private val solution = XORAfterRangeMultiplicationQueriesI()

    @Test
    fun `test example 1 - all elements multiplied by same value`() {
        val nums = intArrayOf(1, 1, 1)
        val queries = arrayOf(intArrayOf(0, 2, 1, 4))
        assertEquals(4, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test example 2 - multiple queries with step 2 and step 1`() {
        val nums = intArrayOf(2, 3, 1, 5, 4)
        val queries = arrayOf(intArrayOf(1, 4, 2, 3), intArrayOf(0, 2, 1, 2))
        assertEquals(31, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test single element array with single query`() {
        val nums = intArrayOf(5)
        val queries = arrayOf(intArrayOf(0, 0, 1, 3))
        // 5 * 3 = 15, XOR = 15
        assertEquals(15, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test query with step larger than range hitting only selected indices`() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val queries = arrayOf(intArrayOf(0, 4, 3, 2))
        // idx=0: 1*2=2, idx=3: 4*2=8, idx=6 > 4 stop → [2,2,3,8,5]
        // XOR: 2^2^3^8^5 = 0^3^8^5 = 3^8^5 = 11^5 = 14
        assertEquals(14, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test query with step that only touches one element`() {
        val nums = intArrayOf(3, 5, 7)
        val queries = arrayOf(intArrayOf(1, 2, 5, 3))
        // idx=1: 5*3=15, idx=6 > 2 stop → [3,15,7]
        // XOR: 3^15^7 = 12^7 = 11
        assertEquals(11, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test multiply by 1 leaves array unchanged`() {
        val nums = intArrayOf(3, 5, 7)
        val queries = arrayOf(intArrayOf(0, 2, 1, 1))
        // No change → [3,5,7]
        // XOR: 3^5^7 = 6^7 = 1
        assertEquals(1, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test no queries returns XOR of original array`() {
        val nums = intArrayOf(1, 2, 3)
        val queries = emptyArray<IntArray>()
        // XOR: 1^2^3 = 0
        assertEquals(0, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test multiple queries affecting overlapping ranges`() {
        val nums = intArrayOf(1, 1, 1, 1)
        val queries = arrayOf(intArrayOf(0, 3, 1, 2), intArrayOf(0, 3, 1, 3))
        // After first: [2,2,2,2]
        // After second: [6,6,6,6]
        // XOR: 6^6^6^6 = 0
        assertEquals(0, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test step equals range size hitting only start index`() {
        val nums = intArrayOf(4, 6, 8)
        val queries = arrayOf(intArrayOf(0, 1, 3, 5))
        // idx=0: 4*5=20, idx=3 > 1 stop → [20,6,8]
        // XOR: 20^6^8 = 18^8 = 26
        assertEquals(26, solution.xorAfterQueries(nums, queries))
    }
}
