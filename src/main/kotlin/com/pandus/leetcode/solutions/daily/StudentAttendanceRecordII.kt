package com.pandus.leetcode.solutions.daily

import java.util.*


//Reference: https://leetcode.com/problems/student-attendance-record-ii
class StudentAttendanceRecordII {
    private val MOD = 1000000007
    private lateinit var memo: Array<Array<IntArray>>

    // Recursive function to return the count of combinations of length 'n' eligible for the award.
    private fun eligibleCombinations(n: Int, totalAbsences: Int, consecutiveLates: Int): Int {
        // If the combination has become not eligible for the award,
        // then we will not count any combinations that can be made using it.
        if (totalAbsences >= 2 || consecutiveLates >= 3) {
            return 0
        }
        // If we have generated a combination of length 'n' we will count it.
        if (n == 0) {
            return 1
        }
        // If we have already seen this sub-problem earlier, we return the stored result.
        if (memo[n][totalAbsences][consecutiveLates] != -1) {
            return memo[n][totalAbsences][consecutiveLates]
        }
        var count = 0
        // We choose 'P' for the current position.
        count = eligibleCombinations(n - 1, totalAbsences, 0) % MOD
        // We choose 'A' for the current position.
        count = (count + eligibleCombinations(n - 1, totalAbsences + 1, 0)) % MOD
        // We choose 'L' for the current position.
        count = (count + eligibleCombinations(n - 1, totalAbsences, consecutiveLates + 1)) % MOD

        // Return and store the current sub-problem result in the cache.
        return count.also { memo[n][totalAbsences][consecutiveLates] = it }
    }

    fun checkRecord(n: Int): Int {
        // Initialize the cache.
        memo = Array(n + 1) { Array(2) { IntArray(3) } }
        for (array2D in memo) {
            for (array1D in array2D) {
                Arrays.fill(array1D, -1)
            }
        }
        // Return count of combinations of length 'n' eligible for the award.
        return eligibleCombinations(n, 0, 0)
    }
}