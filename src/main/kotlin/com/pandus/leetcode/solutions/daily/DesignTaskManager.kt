package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/design-task-manager
class DesignTaskManager(tasks: List<List<Int>>) {

    private data class Entry(val priority: Int, val taskId: Int)

    private val heap = PriorityQueue<Entry> { a, b ->
        when {
            a.priority != b.priority -> b.priority - a.priority
            else -> b.taskId - a.taskId
        }
    }

    private val taskToUser = HashMap<Int, Int>()
    private val taskToPriority = HashMap<Int, Int>()

    init {
        for (t in tasks) {
            // t = [userId, taskId, priority]
            add(t[0], t[1], t[2])
        }
    }

    fun add(userId: Int, taskId: Int, priority: Int) {
        taskToUser[taskId] = userId
        taskToPriority[taskId] = priority
        heap.add(Entry(priority, taskId))
    }

    fun edit(taskId: Int, newPriority: Int) {
        taskToPriority[taskId] = newPriority
        heap.add(Entry(newPriority, taskId))
    }

    fun rmv(taskId: Int) {
        taskToUser.remove(taskId)
        taskToPriority.remove(taskId)
    }

    fun execTop(): Int {
        while (heap.isNotEmpty()) {
            val top = heap.peek()
            val curPrio = taskToPriority[top.taskId]
            if (curPrio == null || curPrio != top.priority) {
                heap.poll()
                continue
            }
            heap.poll()
            val userId = taskToUser.remove(top.taskId)!!
            taskToPriority.remove(top.taskId)
            return userId
        }
        return -1
    }
}
