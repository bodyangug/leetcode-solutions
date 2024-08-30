package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/2-keys-keyboard
class TwoKeysKeyboard {
    private var n: Int = 0

    fun minSteps(n: Int): Int {
        if (n == 1) return 0
        this.n = n
        // first step is always a Copy All operation
        return 1 + minStepsHelper(1, 1)
    }

    private fun minStepsHelper(currLen: Int, pasteLen: Int): Int {
        if (currLen == n) return 0
        if (currLen > n) return 1000

        // copy all + paste
        val opt1 = 2 + minStepsHelper(currLen * 2, currLen)
        // paste
        val opt2 = 1 + minStepsHelper(currLen + pasteLen, pasteLen)

        return min(opt1, opt2)
    }
}
