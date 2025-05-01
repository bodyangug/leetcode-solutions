package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign
class MaximumNumberOfTasksYouCanAssign {
    fun maxTaskAssign(tasks: IntArray, workers: IntArray, pills: Int, strength: Int): Int {
        tasks.sort()
        workers.sort()

        var low = 0
        var high = minOf(tasks.size, workers.size)
        var answer = 0

        while (low <= high) {
            val mid = (low + high) / 2
            if (canAssign(tasks, workers, pills, strength, mid)) {
                answer = mid
                low = mid + 1
            } else {
                high = mid - 1
            }
        }

        return answer
    }

    private fun canAssign(tasks: IntArray, workers: IntArray, pills: Int, strength: Int, k: Int): Boolean {
        val dq = ArrayDeque<Int>()
        var p = pills
        var i = workers.size - 1

        for (j in (k - 1) downTo 0) {
            while (i >= workers.size - k && workers[i] + strength >= tasks[j]) {
                dq.addFirst(workers[i--])
            }

            if (dq.isEmpty()) return false

            if (dq.last() >= tasks[j]) {
                dq.removeLast() // No pill needed
            } else {
                if (p == 0) return false
                p--
                dq.removeFirst() // Use pill on weakest eligible worker
            }
        }

        return true
    }
}
