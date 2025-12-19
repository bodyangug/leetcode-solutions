package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-all-people-with-secret
class FindAllPeopleWithSecret {
    fun findAllPeople(n: Int, meetings: Array<IntArray>, firstPerson: Int): List<Int> {
        // Group meetings by time for efficient processing
        val meetingsByTime = meetings.groupBy { it[2] }.toSortedMap()

        val knowsSecret = BooleanArray(n).apply {
            this[0] = true
            this[firstPerson] = true
        }

        // Process meetings in chronological order
        for ((_, meetingsAtTime) in meetingsByTime) {
            // Build graph for this time step
            val graph = mutableMapOf<Int, MutableList<Int>>()
            val peopleAtMeeting = mutableSetOf<Int>()

            for (meeting in meetingsAtTime) {
                val (x, y) = meeting
                graph.getOrPut(x) { mutableListOf() }.add(y)
                graph.getOrPut(y) { mutableListOf() }.add(x)
                peopleAtMeeting.add(x)
                peopleAtMeeting.add(y)
            }

            // BFS to spread secret among people who meet at this time
            val queue = ArrayDeque<Int>()
            peopleAtMeeting.filter { knowsSecret[it] }.forEach { queue.add(it) }

            val visited = BooleanArray(n)

            while (queue.isNotEmpty()) {
                val person = queue.removeFirst()

                if (visited[person]) continue
                visited[person] = true

                graph[person]?.forEach { neighbor ->
                    if (!knowsSecret[neighbor]) {
                        knowsSecret[neighbor] = true
                        queue.add(neighbor)
                    }
                }
            }
        }
        return knowsSecret.indices.filter { knowsSecret[it] }
    }
}
