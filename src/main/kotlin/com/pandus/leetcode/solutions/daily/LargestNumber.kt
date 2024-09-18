package com.pandus.leetcode.solutions.daily

// Reference:https://leetcode.com/problems/largest-number
class LargestNumber {
    fun largestNumber(nums: IntArray): String {
        val sorted = nums.sortedWith { a, b ->
            val a1 = a.toString();
            val b1 = b.toString();
            (b1 + a1).compareTo(a1 + b1);
        }
        if (sorted[0] == 0) return "0";

        val ans = StringBuilder();
        for (it in sorted) {
            ans.append(it.toString());
        }
        return ans.toString();
    }
}