package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/subsets
class Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {
        val output: MutableList<MutableList<Int>> = ArrayList()
        output.add(ArrayList())

        for (num in nums) {
            val newSubsets: MutableList<MutableList<Int>> = ArrayList()
            for (curr in output) {
                val newSubset = ArrayList(curr)
                newSubset.add(num)
                newSubsets.add(newSubset)
            }
            output.addAll(newSubsets)
        }
        return output
    }
}
