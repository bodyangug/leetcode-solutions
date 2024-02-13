package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/group-anagrams
class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val ans = mutableMapOf<String, MutableList<String>>()
        strs.forEach {
            val sortedKey = it.toList().sorted().toString()
            ans.computeIfAbsent(sortedKey) { mutableListOf() }.add(it)
        }
        return ans.values.toList()
    }

}
