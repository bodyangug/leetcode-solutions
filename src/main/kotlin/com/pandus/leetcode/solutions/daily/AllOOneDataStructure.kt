package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/all-oone-data-structure
class AllOOneDataStructure {
    val hashmap = HashMap<String, Int>()

    fun inc(key: String) {
        if (hashmap.containsKey(key)) {
            hashmap[key] = hashmap.getValue(key) + 1
        } else {
            hashmap[key] = 1
        }
    }

    fun dec(key: String) {
        if (hashmap.containsKey(key)) {
            hashmap[key] = hashmap.getValue(key) - 1
        }
        if (hashmap[key] != null && hashmap.getValue(key) == 0) {
            hashmap.remove(key)
        }
    }

    fun getMaxKey(): String {
        var max = ""
        var maxValue = 0
        for (entry in hashmap) {
            if (entry.value > maxValue) {
                maxValue = entry.value
                max = entry.key
            }
        }
        return max
    }

    fun getMinKey(): String {
        var min = ""
        var minValue = Int.MAX_VALUE
        for (entry in hashmap) {
            if (entry.value <= minValue) {
                minValue = entry.value
                min = entry.key
            }
        }
        return min
    }
}
