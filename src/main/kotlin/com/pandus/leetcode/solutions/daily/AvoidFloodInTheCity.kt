package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/avoid-flood-in-the-city
class AvoidFloodInTheCity {
    fun avoidFlood(rains: IntArray): IntArray {
        val result = IntArray(rains.size)
        val fullLakes = mutableMapOf<Int, Int>() // lake -> day when it became full
        val dryDays = TreeSet<Int>() // available dry days

        for (i in rains.indices) {
            when {
                rains[i] > 0 -> {
                    val lake = rains[i]

                    // If lake is already full, we need to find a dry day to prevent flood
                    if (fullLakes.containsKey(lake)) {
                        val lastFullDay = fullLakes[lake]!!

                        // Find the earliest dry day after the lake became full
                        val dryDay = dryDays.higher(lastFullDay)

                        if (dryDay == null) {
                            // No available dry day, flood is inevitable
                            return intArrayOf()
                        }

                        // Use this dry day to dry the lake
                        result[dryDay] = lake
                        dryDays.remove(dryDay)
                    }

                    // Mark lake as full
                    fullLakes[lake] = i
                    result[i] = -1
                }

                else -> {
                    // It's a dry day, add to available dry days
                    dryDays.add(i)
                    result[i] = 1 // placeholder, will be updated if needed
                }
            }
        }

        return result
    }
}
