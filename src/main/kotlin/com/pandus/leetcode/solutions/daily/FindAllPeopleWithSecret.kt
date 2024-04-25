package com.pandus.leetcode.solutions.daily

import java.util.Stack


//Reference: https://leetcode.com/problems/find-all-people-with-secret
class FindAllPeopleWithSecret {

    fun findAllPeople(n: Int, meetings: Array<IntArray>, firstPerson: Int): List<Int> {
        val graph = mutableMapOf<Int, MutableList<IntArray>>()
        meetings.forEach { meeting ->
            val (x, y, t) = meeting
            graph.getOrPut(x) { mutableListOf() }.add(intArrayOf(t, y))
            graph.getOrPut(y) { mutableListOf() }.add(intArrayOf(t, x))
        }

        val earliest = IntArray(n) { Int.MAX_VALUE }.also {
            it[0] = 0
            it[firstPerson] = 0
        }

        val stack = Stack<IntArray>().also {
            it.push(intArrayOf(0, 0))
            it.push(intArrayOf(firstPerson, 0))
        }

        while (stack.isNotEmpty()) {
            val personTime = stack.pop()
            val (person, time) = personTime
            graph.getOrElse(person) { mutableListOf() }.forEach { nextPersonTime ->
                val (t, nextPerson) = nextPersonTime
                if (t >= time && earliest[nextPerson] > t) {
                    earliest[nextPerson] = t
                    stack.push(intArrayOf(nextPerson, t))
                }
            }
        }

        return (0 until n).filter { i ->
            earliest[i] != Int.MAX_VALUE
        }
    }

}
