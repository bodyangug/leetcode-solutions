package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-unique-binary-string
class FindUniqueBinaryString {
    fun findDifferentBinaryString(nums: Array<String?>): String {
        val n = nums.size
        val numsSet = nums.toSet()

        for (i in 0 until (1 shl n)) {
            val candidate = i.toString(2).padStart(n, '0')
            if (candidate !in numsSet) {
                return candidate
            }
        }
        return ""
    }
}
