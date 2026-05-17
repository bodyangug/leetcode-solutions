package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/jump-game-iii
class JumpGameIII {
    fun canReach(arr: IntArray, start: Int): Boolean {
        val visited = BooleanArray(arr.size)
        return dfs(arr, start, visited)
    }

    private fun dfs(arr: IntArray, start: Int, visited: BooleanArray): Boolean {
        if (start < 0 || start >= arr.size || visited[start]) {
            return false
        }
        if (arr[start] == 0) {
            return true
        }
        visited[start] = true
        val jumpForward = dfs(arr, start + arr[start], visited)
        val jumpBackward = dfs(arr, start - arr[start], visited)
        return jumpForward || jumpBackward
    }
}
