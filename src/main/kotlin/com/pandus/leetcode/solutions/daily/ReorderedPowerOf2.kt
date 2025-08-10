package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/reordered-power-of-2
class ReorderedPowerOf2 {
    fun reorderedPowerOf2(n: Int): Boolean {
        val target = n.toString().toCharArray().sorted().joinToString("")
        val powerSignatures = mutableSetOf<String>()

        var p = 1
        while (p <= 1_000_000_000) {
            powerSignatures.add(p.toString().toCharArray().sorted().joinToString(""))
            p *= 2
        }

        return target in powerSignatures
    }
}
