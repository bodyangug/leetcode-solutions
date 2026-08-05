package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/remove-methods-from-project
class RemoveMethodsFromProject {
    fun remainingMethods(n: Int, k: Int, invocations: Array<IntArray>): List<Int> {
        val graph = Array(n) { mutableListOf<Int>() }
        for ((a, b) in invocations) {
            graph[a].add(b)
        }

        val suspicious = BooleanArray(n)
        val stack = ArrayDeque<Int>()
        stack.addLast(k)
        suspicious[k] = true
        while (stack.isNotEmpty()) {
            val node = stack.removeLast()
            for (next in graph[node]) {
                if (!suspicious[next]) {
                    suspicious[next] = true
                    stack.addLast(next)
                }
            }
        }
        for ((a, b) in invocations) {
            if (!suspicious[a] && suspicious[b]) {
                return (0 until n).toList()
            }
        }
        return (0 until n).filter { !suspicious[it] }
    }
}
