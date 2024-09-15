package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts
class FindTheLongestSubstringContainingVowelsInEvenCounts {
    fun findTheLongestSubstring(s: String): Int {
        var prefixXOR = 0
        val characterMap = IntArray(26)
        characterMap['a'.code - 'a'.code] = 1
        characterMap['e'.code - 'a'.code] = 2
        characterMap['i'.code - 'a'.code] = 4
        characterMap['o'.code - 'a'.code] = 8
        characterMap['u'.code - 'a'.code] = 16
        val mp = IntArray(32)
        for (i in 0..31) mp[i] = -1
        var longestSubstring = 0
        for (i in s.indices) {
            prefixXOR = prefixXOR xor characterMap[s[i].code - 'a'.code]
            if (mp[prefixXOR] == -1 && prefixXOR != 0) mp[prefixXOR] = i
            longestSubstring = max(longestSubstring.toDouble(), (i - mp[prefixXOR]).toDouble()).toInt()
        }
        return longestSubstring
    }
}
