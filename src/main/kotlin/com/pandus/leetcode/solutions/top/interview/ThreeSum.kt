package com.pandus.leetcode.solutions.top.interview

// Reference: https://leetcode.com/problems/3sum/description/
class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val nums = nums.sorted()
        val resultSet: MutableSet<List<Int>> = HashSet()
        for (i in 0 until nums.size - 2) {
            if (nums[i] > 0) break

            var left = i + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]
                when {
                    sum == 0 -> {
                        resultSet.add(listOf(nums[i], nums[left], nums[right]))
                        left++
                        right--
                    }

                    sum < 0 -> left++
                    else -> right--
                }
            }
        }
        return resultSet.map { it.toList() }
    }
}
