package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/design-a-stack-with-increment-operation
class DesignStackWithIncrementOperation(maxSize: Int) {
    private val stack = IntArray(maxSize)
    private var topIndex: Int = -1

    fun push(x: Int) {
        if (topIndex < stack.size - 1) {
            stack[++topIndex] = x
        }
    }

    fun pop(): Int {
        if (topIndex >= 0) {
            return stack[topIndex--]
        }
        return -1
    }

    fun increment(k: Int, `val`: Int) {
        val limit = min(k, topIndex + 1)
        for (i in 0 until limit) {
            stack[i] += `val`
        }
    }
}
