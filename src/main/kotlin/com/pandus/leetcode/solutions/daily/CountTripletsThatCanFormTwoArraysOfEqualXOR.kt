package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor
class CountTripletsThatCanFormTwoArraysOfEqualXOR {
    fun countTriplets(arr: IntArray): Int {
        var count = 0
        //index i
        for (start in arr.indices) {
            var xorA = 0
            //index j
            for (mid in start + 1 until arr.size) {
                xorA = xorA xor arr[mid - 1]
                var xorB = 0
                //index k
                for (end in mid until arr.size) {
                    xorB = xorB xor arr[end]
                    if (xorA == xorB) {
                        ++count
                    }
                }
            }
        }
        return count
    }
}