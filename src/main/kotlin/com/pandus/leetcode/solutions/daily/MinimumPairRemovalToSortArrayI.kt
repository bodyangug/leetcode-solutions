package com.pandus.leetcode.solutions.daily


// Reference: https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i
class MinimumPairRemovalToSortArrayI {
    // Given an array nums, you can perform the following operation any number of times:
    //Select the adjacent pair with the minimum sum in nums. If multiple such pairs exist, choose the leftmost one.
    //Replace the pair with their sum.
    //Return the minimum number of operations needed to make the array non-decreasing.
    //An array is said to be non-decreasing if each element is greater than or equal to its previous element (if it exists).
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
