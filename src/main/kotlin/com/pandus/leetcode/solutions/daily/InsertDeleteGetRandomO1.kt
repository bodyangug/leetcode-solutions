package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/insert-delete-getrandom-o1
class InsertDeleteGetRandomO1 {

    private val storage: HashMap<Int, Int> = HashMap()
    fun insert(`val`: Int): Boolean {
        return storage.put(`val`.hashCode(), `val`) == null
    }

    fun remove(`val`: Int): Boolean {
        return storage.remove(`val`.hashCode()) != null
    }

    fun getRandom(): Int {
        val random = storage.keys.random()
        return storage[random]!!
    }
}
