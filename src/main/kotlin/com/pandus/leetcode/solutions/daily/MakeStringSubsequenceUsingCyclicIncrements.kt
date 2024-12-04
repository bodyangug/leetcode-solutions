package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments
class MakeStringSubsequenceUsingCyclicIncrements {
    fun canMakeSubsequence(str1: String, str2: String): Boolean {
        var str2Index = 0
        val lengthStr1 = str1.length
        val lengthStr2 = str2.length

        var str1Index = 0
        while (str1Index < lengthStr1 && str2Index < lengthStr2) {
            if (str1[str1Index] == str2[str2Index] ||
                (str1[str1Index].code + 1 == str2[str2Index].code) ||
                (str1[str1Index].code - 25 == str2[str2Index].code)
            ) {
                str2Index++
            }
            ++str1Index
        }
        return str2Index == lengthStr2
    }
}
