package com.pandus.leetcode.solutions.daily

// Reference: http://leetcode.com/problems/jump-game-ix
class JumpGameIX {
    fun maxValue(nums: IntArray): IntArray {
        val n = nums.size
        val parent = IntArray(n) { it }
        val maxVal = IntArray(n) { nums[it] }
        val minVal = IntArray(n) { nums[it] }

        fun find(x: Int): Int {
            var r = x
            while (parent[r] != r) r = parent[r]
            var c = x
            while (c != r) {
                val next = parent[c]
                parent[c] = r
                c = next
            }
            return r
        }

        fun union(x: Int, y: Int): Int {
            val rx = find(x)
            val ry = find(y)
            if (rx == ry) return rx
            parent[ry] = rx
            maxVal[rx] = maxOf(maxVal[rx], maxVal[ry])
            minVal[rx] = minOf(minVal[rx], minVal[ry])
            return rx
        }

        val stack = ArrayDeque<Int>()

        for (i in 0 until n) {
            var comp = i
            while (stack.isNotEmpty() && maxVal[find(stack.last())] > minVal[find(comp)]) {
                comp = union(comp, stack.removeLast())
            }
            stack.addLast(find(comp))
        }

        return IntArray(n) { maxVal[find(it)] }
    }
}
