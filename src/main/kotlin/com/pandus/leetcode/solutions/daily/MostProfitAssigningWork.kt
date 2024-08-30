package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/most-profit-assigning-work
class MostProfitAssigningWork {
    fun maxProfitAssignment(
        difficulty: IntArray,
        profit: IntArray,
        worker: IntArray
    ): Int {
        val jobProfile: MutableList<IntArray> = ArrayList()
        jobProfile.add(intArrayOf(0, 0))
        for (i in difficulty.indices) {
            jobProfile.add(intArrayOf(difficulty[i], profit[i]))
        }

        // Sort by difficulty values in increasing order.
        jobProfile.sortWith { a: IntArray, b: IntArray ->
            a[0].compareTo(b[0])
        }

        for (i in 0 until jobProfile.size - 1) {
            jobProfile[i + 1][1] = max(jobProfile[i][1], jobProfile[i + 1][1])
        }

        var netProfit = 0
        for (i in worker.indices) {
            val ability = worker[i]

            // Find the job with just smaller or equal difficulty than ability.
            var l = 0
            var r = jobProfile.size - 1
            var jobProfit = 0
            while (l <= r) {
                val mid = (l + r) / 2
                if (jobProfile[mid][0] <= ability) {
                    jobProfit = max(jobProfit, jobProfile[mid][1])
                    l = mid + 1
                } else {
                    r = mid - 1
                }
            }
            // Increment profit of current worker to total profit.
            netProfit += jobProfit
        }
        return netProfit
    }
}
