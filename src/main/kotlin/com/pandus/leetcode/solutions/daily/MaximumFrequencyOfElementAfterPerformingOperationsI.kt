package com.pandus.leetcode.solutions.daily

import java.util.*
import kotlin.math.min

class MaximumFrequencyOfElementAfterPerformingOperationsI {
    fun maxFrequency(nums: IntArray, k: Int, numOperations: Int): Int {
        if (nums.isEmpty()) return 0
        Arrays.sort(nums)
        var left = 0
        var answer = 1

        // counts of each number currently in window
        val counts = HashMap<Int, Int>()
        // frequency bucket: freqCount[f] = how many distinct numbers currently have frequency f in window.
        val freqCount = IntArray(nums.size + 2)
        var maxFreqInWindow = 0

        fun add(x: Int) {
            val old = counts.getOrDefault(x, 0)
            if (old > 0) freqCount[old]--
            val new = old + 1
            counts[x] = new
            freqCount[new]++
            if (new > maxFreqInWindow) maxFreqInWindow = new
        }

        fun remove(x: Int) {
            val old = counts[x] ?: return
            freqCount[old]--
            val new = old - 1
            if (new == 0) {
                counts.remove(x)
            } else {
                counts[x] = new
                freqCount[new]++
            }
            if (freqCount[maxFreqInWindow] == 0) {
                while (maxFreqInWindow > 0 && freqCount[maxFreqInWindow] == 0) maxFreqInWindow--
            }
        }

        for (right in nums.indices) {
            add(nums[right])
            // shrink window while span too large
            while (nums[right] - nums[left] > 2 * k) {
                remove(nums[left])
                left++
            }
            val windowSize = right - left + 1
            val candidate = min(windowSize, maxFreqInWindow + numOperations)
            if (candidate > answer) answer = candidate
        }
        return answer
    }
}
