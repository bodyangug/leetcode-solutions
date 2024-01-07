package com.pandus.leetcode.solutions.daily

import kotlin.math.max

//Reference: https://leetcode.com/problems/maximum-profit-in-job-scheduling
class MaximumProfitInJobScheduling {
    var memo = IntArray(50001)
    private fun findNextJob(startTime: IntArray, lastEndingTime: Int): Int {
        var startIndex = 0
        var endIndex = startTime.size - 1
        var resultIndex = startTime.size

        while (startIndex <= endIndex) {
            val midIndex = (startIndex + endIndex) / 2

            if (startTime[midIndex] >= lastEndingTime) {
                resultIndex = midIndex
                endIndex = midIndex - 1
            } else {
                startIndex = midIndex + 1
            }
        }

        return resultIndex
    }

    private fun findMaxProfit(jobs: List<Triple<Int, Int, Int>>, startTime: IntArray): Int {
        for (position in jobs.indices.reversed()) {
            //Binary search
            val nextIndex = findNextJob(startTime, jobs[position].second)

            val currentProfit = jobs[position].third + (memo.getOrNull(nextIndex) ?: 0)
            memo[position] = max(currentProfit, memo.getOrElse(position + 1) { 0 })
        }
        return memo[0]
    }

    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        val jobs: List<Triple<Int, Int, Int>> = ArrayList<Triple<Int, Int, Int>>().also { list ->
            list.addAll(startTime.indices.map {
                Triple(startTime[it], endTime[it], profit[it])
            })
        }.sortedBy { it.first }

        for (i in startTime.indices) {
            startTime[i] = jobs[i].first
        }
        return findMaxProfit(jobs, startTime)
    }
}