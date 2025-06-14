package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-difference-by-remapping-a-digit
class MaximumDifferenceByRemappingDigit {
    fun minMaxDifference(num: Int): Int {
        val original = num.toString().toCharArray()

        val maxVersion = original.copyOf()
        for (i in maxVersion.indices) {
            if (maxVersion[i] != '9') {
                val target = maxVersion[i]
                for (j in maxVersion.indices) {
                    if (maxVersion[j] == target) {
                        maxVersion[j] = '9'
                    }
                }
                break
            }
        }

        val minVersion = original.copyOf()
        val target = minVersion[0]
        for (i in minVersion.indices) {
            if (minVersion[i] == target) {
                minVersion[i] = '0'
            }
        }

        return String(maxVersion).toInt() - String(minVersion).toInt()
    }
}
