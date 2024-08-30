package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/patching-array
class PatchingArray {
    fun minPatches(nums: IntArray, n: Int): Int {
        var patches = 0
        var i = 0
        var miss: Long = 1 // use long to avoid integer overflow error
        while (miss <= n) {
            if (i < nums.size && nums[i] <= miss) // miss is covered
                miss += nums[i++].toLong() else { // patch miss to the array
                miss += miss
                patches++ // increase the answer
            }
        }
        return patches
    }
}
