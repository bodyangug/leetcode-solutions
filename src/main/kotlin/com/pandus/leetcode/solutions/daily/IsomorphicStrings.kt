package com.pandus.leetcode.solutions.daily


//Reference: https://leetcode.com/problems/isomorphic-strings
class IsomorphicStrings {
    private fun transformString(s: String): IntArray {
        val indexMapping = mutableMapOf<Char, Int>()
        val transformed = IntArray(s.length)
        s.forEachIndexed { index, c ->
            indexMapping.putIfAbsent(c, index)
            transformed[index] = indexMapping[c]!!
        }
        return transformed
    }

    fun isIsomorphic(s: String, t: String): Boolean {
        return transformString(s).contentEquals(transformString(t))
    }
}
