package com.pandus.leetcode.solutions.daily

import java.util.PriorityQueue
import java.util.Queue

//Reference: https://leetcode.com/problems/furthest-building-you-can-reach
class FurthestBuildingYouCanReach {
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        val brickAllocations: Queue<Int> = PriorityQueue { a, b -> b - a }
        var bricks = bricks
        var ladders = ladders

        for (i in 0 until heights.lastIndex) {
            val climb = (heights[i + 1] - heights[i]).coerceAtLeast(0)
            if (climb > 0) {
                brickAllocations.add(climb)
                bricks -= climb
            }

            if (bricks >= 0) continue

            if (ladders <= 0) return i

            bricks += requireNotNull(brickAllocations.poll())
            ladders--
        }

        return heights.lastIndex
    }
}
