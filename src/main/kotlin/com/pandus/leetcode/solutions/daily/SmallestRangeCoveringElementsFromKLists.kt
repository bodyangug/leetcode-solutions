package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists
class SmallestRangeCoveringElementsFromKLists {
    fun smallestRange(nums: List<List<Int>>): IntArray {
        val k = nums.size
        val indices = IntArray(k)
        val range = intArrayOf(0, Int.MAX_VALUE)

        while (true) {
            var curMin = Int.MAX_VALUE
            var curMax = Int.MIN_VALUE
            var minListIndex = 0

            for (i in 0 until k) {
                val currentElement = nums[i][indices[i]]

                if (currentElement < curMin) {
                    curMin = currentElement
                    minListIndex = i
                }

                if (currentElement > curMax) {
                    curMax = currentElement
                }
            }

            if (curMax - curMin < range[1] - range[0]) {
                range[0] = curMin
                range[1] = curMax
            }

            if (++indices[minListIndex] == nums[minListIndex].size) break
        }
        return range
    }
}
