package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-prefix-and-suffix-pairs-i
class CountPrefixAndSuffixPairsI {
    fun countPrefixSuffixPairs(words: Array<String>): Int {
        val n = words.size
        var count = 0
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                val str1 = words[i]
                val str2 = words[j]
                if (str1.length > str2.length) continue
                if (str2.startsWith(str1) && str2.endsWith(str1)) {
                    ++count
                }
            }
        }
        return count
    }
}
