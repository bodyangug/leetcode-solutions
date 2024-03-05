package com.pandus.leetcode.solutions.daily

import jdk.internal.org.jline.utils.Colors


//Reference: https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends
class MinimumLengthOfStringAfterDeletingSimilarEnds {
    fun minimumLength(s: String): Int {
        val charArray = s.toCharArray()
        var (start, end) = 0 to charArray.lastIndex
        while (start < end && charArray[start] == charArray[end]) {
            val c = charArray[start]
            //prefix
            while (start <= end && charArray[start] == c) start++
            //suffix
            while (end > start && charArray[end] == c) end--
        }
        return end - start + 1
    }
}
