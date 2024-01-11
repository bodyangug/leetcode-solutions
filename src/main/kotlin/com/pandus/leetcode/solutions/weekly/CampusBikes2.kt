package com.pandus.leetcode.solutions.weekly

import kotlin.math.*

//Reference: https://leetcode.com/problems/campus-bikes-ii
class CampusBikes2 {
    private var visited = BooleanArray(10)
    private var smallestDistanceSum = Int.MAX_VALUE

    private fun findDistance(worker: IntArray, bike: IntArray): Int {
        return abs(worker[0] - bike[0]) + abs(worker[1] - bike[1])
    }

    private fun minimumDistanceSum(
        workers: Array<IntArray>,
        workerIndex: Int,
        bikes: Array<IntArray>,
        currDistanceSum: Int
    ) {
        if (workerIndex >= workers.size) {
            smallestDistanceSum = min(smallestDistanceSum, currDistanceSum)
            return
        }

        if (currDistanceSum >= smallestDistanceSum) {
            return
        }

        for (bikeIndex in bikes.indices) {
            if (!visited[bikeIndex]) {
                visited[bikeIndex] = true
                minimumDistanceSum(
                    workers, workerIndex + 1, bikes,
                    currDistanceSum + findDistance(workers[workerIndex], bikes[bikeIndex])
                )
                visited[bikeIndex] = false
            }
        }
    }

    fun assignBikes(workers: Array<IntArray>, bikes: Array<IntArray>): Int {
        minimumDistanceSum(workers, 0, bikes, 0)
        return smallestDistanceSum
    }
}