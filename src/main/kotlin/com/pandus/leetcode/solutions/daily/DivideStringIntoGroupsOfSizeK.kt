package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/divide-a-string-into-groups-of-size-k
class DivideStringIntoGroupsOfSizeK {
    fun divideString(s: String, k: Int, fill: Char): Array<String> {
        val resultSize = (s.length + k - 1) / k
        return Array(resultSize) { i ->
            val start = i * k
            val end = minOf(start + k, s.length)
            val group = s.substring(start, end)
            if (group.length < k) group + fill.toString().repeat(k - group.length) else group
        }
    }
}
