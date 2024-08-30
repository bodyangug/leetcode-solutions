package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters
class MaximumLengthOfConcatenatedStringWithUniqueCharacters {
    fun maxLength(arr: List<String>): Int {
        return dfs(arr, 0, "", HashSet())
    }

    private fun dfs(arr: List<String>, pos: Int, res: String, uniqueChars: MutableSet<Char>): Int {
        if (res.length != uniqueChars.size) return 0

        var best = res.length
        for (i in pos until arr.size) {
            val currentSet = HashSet(uniqueChars)
            var isValid = true
            for (c in arr[i]) {
                if (!currentSet.add(c)) {
                    isValid = false
                    break
                }
            }
            if (isValid) {
                best = max(best, dfs(arr, i + 1, res + arr[i], currentSet))
            }
        }
        return best
    }
}
