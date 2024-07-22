package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/sort-the-people
class SortThePeople {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
        return names.indices
            .sortedByDescending { heights[it] }
            .map { names[it] }
            .toTypedArray()
    }
}

fun main() {
    val sortPeople = SortThePeople().sortPeople(arrayOf("Mary", "John", "Emma"), intArrayOf(180, 165, 170))
    sortPeople.forEach { println(it) }
}