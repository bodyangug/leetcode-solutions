package com.pandus.leetcode.solutions.daily

import java.util.Collections


//Reference: https://leetcode.com/problems/sort-the-jumbled-numbers
class SortTheJumbledNumbers {
    fun sortJumbled(mapping: IntArray, nums: IntArray): IntArray {
        val storePairs = nums.mapIndexed { index, num ->
            var mappedValue = 0
            var temp = num
            var place = 1

            if (temp != 0) {
                while (temp != 0) {
                    mappedValue += place * mapping[temp % 10]
                    place *= 10
                    temp /= 10
                }
            } else {
                mappedValue = mapping[0]
            }
            mappedValue to index
        }.sortedBy { it.first }

        return IntArray(nums.size) { i -> nums[storePairs[i].second] }
    }
}

fun main() {
    SortTheJumbledNumbers().sortJumbled(
        mapping = intArrayOf(8, 2, 9, 5, 3, 7, 1, 0, 6, 4),
        nums = intArrayOf(
            418,
            4191,
            916,
            948,
            629641556,
            574,
            111171937,
            28250,
            42775632,
            6086,
            85796326,
            696292542,
            186,
            67559,
            2167,
            366,
            854,
            2441,
            78176,
            621,
            4257,
            2250097,
            509847,
            7506,
            77,
            50,
            4135258,
            4036,
            59934,
            59474,
            3646243,
            9049356,
            85852,
            90298188,
            2448206,
            30401413,
            33190382,
            968234660,
            7973,
            668786,
            992777977,
            77,
            355766,
            221,
            246409664,
            216290476,
            45,
            87,
            836414,
            40952
        )
    )
}