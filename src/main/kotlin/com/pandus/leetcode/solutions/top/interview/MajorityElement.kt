package com.pandus.leetcode.solutions.top.interview

// Reference: https://leetcode.com/problems/majority-element/
class MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        val container = HashMap<Int, Int>()
        for (n in nums) {
            container[n] = container.getOrDefault(n, 0) + 1
        }
        return container.maxBy { it.value > nums.size / 2 }.key
    }
}
