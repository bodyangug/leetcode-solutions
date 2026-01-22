package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i
class MinimumPairRemovalToSortArrayI {
    fun minimumPairRemoval(nums: IntArray): Int {
        val list: MutableList<Int> = ArrayList()
        for (num in nums) {
            list.add(num)
        }
        var count = 0

        while (list.size > 1) {
            var isAscending = true
            var minSum = Int.MAX_VALUE
            var targetIndex = -1

            for (i in 0..<list.size - 1) {
                val sum = list[i] + list[i + 1]

                if (list[i] > list[i + 1]) {
                    isAscending = false
                }

                if (sum < minSum) {
                    minSum = sum
                    targetIndex = i
                }
            }

            if (isAscending) {
                break
            }

            count++
            list[targetIndex] = minSum
            list.removeAt(targetIndex + 1)
        }
        return count
    }
}
