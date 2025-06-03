package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes
class MaximumCandiesYouCanGetFromBoxes {
    fun maxCandies(
        status: IntArray,
        candies: IntArray,
        keys: Array<IntArray>,
        containedBoxes: Array<IntArray>,
        initialBoxes: IntArray
    ): Int {
        val n = status.size
        val canOpen = BooleanArray(n) { status[it] == 1 }
        val hasBox = BooleanArray(n)
        val used = BooleanArray(n)
        val q: Queue<Int> = LinkedList()
        var ans = 0

        for (box in initialBoxes) {
            hasBox[box] = true
            if (canOpen[box]) {
                q.offer(box)
                used[box] = true
                ans += candies[box]
            }
        }

        while (q.isNotEmpty()) {
            val box = q.poll()

            for (key in keys[box]) {
                canOpen[key] = true
                if (hasBox[key] && !used[key]) {
                    q.offer(key)
                    used[key] = true
                    ans += candies[key]
                }
            }

            for (inner in containedBoxes[box]) {
                hasBox[inner] = true
                if (canOpen[inner] && !used[inner]) {
                    q.offer(inner)
                    used[inner] = true
                    ans += candies[inner]
                }
            }
        }
        return ans
    }
}
