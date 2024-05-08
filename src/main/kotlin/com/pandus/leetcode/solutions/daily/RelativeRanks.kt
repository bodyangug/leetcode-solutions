package com.pandus.leetcode.solutions.daily

import java.util.PriorityQueue

//Reference: https://leetcode.com/problems/relative-ranks
class RelativeRanks {
    fun findRelativeRanks(score: IntArray): Array<String?> {
        // Create a max heap of pairs (score, index)
        val heap = PriorityQueue { a: Pair<Int, Int>, b: Pair<Int, Int> -> b.first - a.first }
        for (i in score.indices) {
            heap.add(Pair(score[i], i))
        }

        // Assign ranks to athletes
        val rank = arrayOfNulls<String>(score.size)
        var place = 1
        while (!heap.isEmpty()) {
            val pair = heap.poll()
            val originalIndex: Int = pair.second
            if (place == 1) {
                rank[originalIndex] = "Gold Medal"
            } else if (place == 2) {
                rank[originalIndex] = "Silver Medal"
            } else if (place == 3) {
                rank[originalIndex] = "Bronze Medal"
            } else {
                rank[originalIndex] = place.toString()
            }
            place++
        }
        return rank
    }
}
