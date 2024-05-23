package com.pandus.leetcode.solutions.daily


//Reference: https://leetcode.com/problems/the-number-of-beautiful-subsets
class NumberOfBeautifulSubsets {
    private var count = 0
    private val visited = mutableMapOf<Int, Int>()

    fun beautifulSubsets(nums: IntArray, k: Int): Int {
        count = 0
        explore(nums, k, 0)
        return count - 1 // Subtract 1 to exclude the empty subset
    }

    private fun explore(nums: IntArray, k: Int, index: Int) {
        if (index == nums.size) {
            count++
            return
        }

        val num = nums[index]

        if (!visited.containsKey(num - k) && !visited.containsKey(num + k)) {
            visited[num] = visited.getOrDefault(num, 0) + 1
            explore(nums, k, index + 1)
            visited[num] = visited[num]!! - 1
            if (visited[num] == 0) {
                visited.remove(num)
            }
        }

        explore(nums, k, index + 1)
    }
}