package com.pandus.leetcode.solutions.daily


//Reference: https://leetcode.com/problems/kth-distinct-string-in-an-array
class KthDistinctStringInArray {
    fun kthDistinct(arr: Array<String>, k: Int): String {
        var k = k
        val frequencyMap: MutableMap<String, Int> = HashMap<String, Int>().apply {
            for (str in arr) {
                this[str] = this.getOrDefault(str, 0) + 1
            }
        }

        for (str in arr) {
            if (frequencyMap[str] == 1) {
                k--
            }
            if (k == 0) {
                return str
            }
        }
        return ""
    }
}