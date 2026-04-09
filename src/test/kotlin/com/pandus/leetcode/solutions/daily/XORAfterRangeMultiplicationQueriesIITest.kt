package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class XORAfterRangeMultiplicationQueriesIITest {
    private val solution = XORAfterRangeMultiplicationQueriesII()

    @Test
    fun `test example 1 - all elements multiplied by same value`() {
        val nums = intArrayOf(1, 1, 1)
        val queries = arrayOf(intArrayOf(0, 2, 1, 4))
        // [1,1,1] -> [4,4,4]; XOR = 4^4^4 = 4
        assertEquals(4, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test example 2 - multiple queries with different steps`() {
        val nums = intArrayOf(2, 3, 1, 5, 4)
        val queries = arrayOf(intArrayOf(1, 4, 2, 3), intArrayOf(0, 2, 1, 2))
        // [2,9,1,15,4] -> [4,18,2,15,4]; XOR = 4^18^2^15^4 = 31
        assertEquals(31, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test no queries returns XOR of original array`() {
        val nums = intArrayOf(1, 2, 3)
        val queries = emptyArray<IntArray>()
        // XOR: 1^2^3 = 0
        assertEquals(0, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test single element with single query`() {
        val nums = intArrayOf(5)
        val queries = arrayOf(intArrayOf(0, 0, 1, 3))
        // 5 * 3 = 15
        assertEquals(15, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test large k touches only start index`() {
        val nums = intArrayOf(4, 6, 8)
        val queries = arrayOf(intArrayOf(0, 1, 3, 5))
        // idx=0: 4*5=20; idx=3 > 1, stop -> [20,6,8]; XOR = 20^6^8 = 26
        assertEquals(26, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test query with step larger than range`() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val queries = arrayOf(intArrayOf(0, 4, 3, 2))
        // idx=0: 1*2=2, idx=3: 4*2=8, idx=6 > 4 stop -> [2,2,3,8,5]
        // XOR: 2^2^3^8^5 = 0^3^13 = 14
        assertEquals(14, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test multiply by 1 leaves array unchanged`() {
        val nums = intArrayOf(3, 5, 7)
        val queries = arrayOf(intArrayOf(0, 2, 1, 1))
        // No change -> [3,5,7]; XOR = 3^5^7 = 1
        assertEquals(1, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test overlapping queries accumulate multipliers`() {
        val nums = intArrayOf(1, 1, 1, 1)
        val queries = arrayOf(intArrayOf(0, 3, 1, 2), intArrayOf(0, 3, 1, 3))
        // After both: all * 6 -> [6,6,6,6]; XOR = 6^6^6^6 = 0
        assertEquals(0, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test step-2 query touches alternating indices`() {
        val nums = intArrayOf(1, 1, 1, 1, 1)
        val queries = arrayOf(intArrayOf(0, 4, 2, 10))
        // idx=0,2,4 * 10 -> [10,1,10,1,10]; XOR = 10^1^10^1^10 = 10
        assertEquals(10, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test multiple small-k queries on same range produce combined effect`() {
        val nums = intArrayOf(1, 1, 1)
        val queries = arrayOf(intArrayOf(0, 2, 1, 2), intArrayOf(0, 2, 1, 3))
        // All elements * 2 * 3 = 6 -> [6,6,6]; XOR = 6^6^6 = 6
        assertEquals(6, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test large-k query where k equals array size touches only first element`() {
        val nums = intArrayOf(3, 3, 3, 3, 3)
        val queries = arrayOf(intArrayOf(0, 4, 5, 4))
        // idx=0: 3*4=12; idx=5 > 4, stop -> [12,3,3,3,3]
        // XOR = 12^3^3^3^3 = 12
        assertEquals(12, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test large modular values do not overflow`() {
        val mod = 1_000_000_007
        val nums = intArrayOf(1_000_000_000, 1_000_000_000)
        val queries = arrayOf(intArrayOf(0, 1, 1, 1_000_000_000))
        // 1e9 * 1e9 % (1e9+7) = (1e18) % (1e9+7)
        val expected0 = (1_000_000_000L * 1_000_000_000L % mod).toInt()
        val expected = expected0 xor expected0
        assertEquals(expected, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test query covering a single index at end of array`() {
        val nums = intArrayOf(2, 4, 6, 8)
        val queries = arrayOf(intArrayOf(3, 3, 1, 5))
        // Only nums[3]: 8*5=40 -> [2,4,6,40]
        // XOR = 2^4^6^40 = 6^6^40 = 40
        assertEquals(40, solution.xorAfterQueries(nums, queries))
    }

    @Test
    fun `test interleaved small and large k queries`() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        // k=1 (small): multiply indices 0..8 by 2 -> all * 2
        // k=9 (large for B=4): multiply index 0 by 3 -> nums[0] * 6
        val queries = arrayOf(intArrayOf(0, 8, 1, 2), intArrayOf(0, 8, 9, 3))
        // After k=1 query: [2,4,6,8,10,12,14,16,18]
        // After k=9 query: only idx=0 touched -> [6,4,6,8,10,12,14,16,18]
        val expected = 6 xor 4 xor 6 xor 8 xor 10 xor 12 xor 14 xor 16 xor 18
        assertEquals(expected, solution.xorAfterQueries(nums, queries))
    }
}
