package com.pandus.leetcode.solutions.daily


//Reference:https://leetcode.com/problems/custom-sort-string
class CustomSortString {
    fun customSortString(order: String, s: String): String {
        val freq: MutableMap<Char, Int> = HashMap()

        for (element in s) {
            freq[element] = freq.getOrDefault(element, 0) + 1
        }

        val result = StringBuilder()
        for (element in order) {
            while (freq.getOrDefault(element, 0) > 0) {
                result.append(element)
                freq[element] = freq[element]!! - 1
            }
        }

        for (letter in freq.keys) {
            var count = freq[letter]!!
            while (count > 0) {
                result.append(letter)
                count--
            }
        }
        return result.toString()
    }
}