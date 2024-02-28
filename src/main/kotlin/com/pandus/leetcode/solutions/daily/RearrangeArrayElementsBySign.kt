package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/rearrange-array-elements-by-sign
class RearrangeArrayElementsBySign {
    fun rearrangeArray(nums: IntArray): IntArray {
        val ans = IntArray(nums.size)
        var (lastPositiveIdx, lastNegativeIdx) = 0 to 0
        for (index in ans.indices) {
            if (index % 2 == 0) {
                lastPositiveIdx = findNext(lastPositiveIdx, nums) { pos -> nums[pos] > 0 }
                ans[index] = nums[lastPositiveIdx]
                lastPositiveIdx++
            } else {
                lastNegativeIdx = findNext(lastNegativeIdx, nums) { pos -> nums[pos] < 0 }
                ans[index] = nums[lastNegativeIdx]
                lastNegativeIdx++
            }
        }
        return ans
    }

    private fun findNext(idx: Int, nums: IntArray, bool: (pos: Int) -> Boolean): Int {
        for (index in idx..<nums.size) {
            if (bool(index)) {
                return index
            }
        }
        return -1
    }
}
